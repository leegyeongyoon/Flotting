package com.flotting.api.history.service;

import com.flotting.api.history.entity.AutoRecommendHistory;
import com.flotting.api.history.repository.AutoRecommendRepository;
import com.flotting.api.user.entity.UserDetailProfile;
import com.flotting.api.user.entity.UserSimpleProfile;
import com.flotting.api.user.model.UserFilterRequestDto;
import com.flotting.api.user.model.UserResponseDto;
import com.flotting.api.user.service.UserService;
import com.flotting.api.util.type.GenderEnum;
import com.flotting.api.util.type.PreferenceEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Slf4j
public class AutoRecommendService {

    private final UserService userService;
    private final AutoRecommendRepository autoRecommendRepository;

    /**
     * userSimpleProfile의 랜덤 2인 매칭
     */
    //TODO 매칭기준 기획 필요
    public void createAutoRecommend(Long detailProfileId) {
        UserDetailProfile detailUser = userService.getDetailUser(detailProfileId);
        UserSimpleProfile user = detailUser.getUserSimpleProfile();
        /**
         * [
         *      {type : body, value : normal},
         *      {type : location, value : south}
         * ]
         * String -> JSON
         *https://docs.google.com/spreadsheets/d/1Qo3gz2-cI15_nvB-tAHQiPhWMVNekzpsnxhoJqnyNbI/edit?pli=1#gid=376416439
         *
         * 1순위 : 동일 등급& 취향1개일치
         * 2순위 : 취향1개 일치하는 사람 필터 e등급비교 상관없음
         * 3순위 : 2순위에서 걸러진 사람이 3명 이상이면 그 중 유사 등급으로 내림차순 하여 2명 필터 차이가 덜나는 점수부터 오름차순
         *
         * 취향 preferenceValue 매니저가 등록해줘야 함.
         * key & value 등록 필요
         */
        int totalScore = detailUser.getTotalScore();
        GenderEnum gender = detailUser.getGender();
        PreferenceEnum preference = detailUser.getPreference();
        //[1,2,3,4]
        List<String> value = detailUser.getPreferenceValue();

        //1순위
        Set<UserResponseDto> firstResult = userService.getEqualScoreAndPreferenceUsers(gender, totalScore, preference, value);
        if(firstResult.size() == 0 ) {
            log.info("1순위 취향 일치 리스트 없음. userEmail : {} score : {} gender : {} preference : {} value : {}"
                    , detailUser.getEmail(), totalScore, gender.name(), preference.name(), value);
        }

        //2순위
        Set<UserResponseDto> secondResult = userService.getEqualPreferenceUsers(gender, totalScore, preference, value);
        if(secondResult.size() == 0 ) {
            log.info("2,3순위 취향 일치 리스트 없음. userEmail : {} gender : {} preference : {} value : {}"
                    , detailUser.getEmail(), gender.name(), preference.name(), value);
        }

        firstResult.addAll(secondResult);
        List<UserResponseDto> userResponseDtos = firstResult.stream().toList();

        //TODO 이미 소개팅 받은 사람 후보에서 제거 필요
        //TODO 2차 프로필에 매니저 승인 시, 취향 1가지 value고르는 화면 필요
        //ex : 거리 라면 어떤 위치가 좋은지, 경기도 북부 남부 등
        //취향 key가 어떻게 나뉠 수 있는지 보기
        IntStream.range(0, 1).forEach(idx -> {
            UserResponseDto recommendedProfile = userResponseDtos.get(idx);
            Long recommendedUserId = recommendedProfile.getDetailProfileId();
            UserDetailProfile recommendedUser = userService.getDetailUser(recommendedUserId);
            AutoRecommendHistory autoRecommendHistory = AutoRecommendHistory.builder()
                    .receiver(recommendedUser)
                    .profile(detailUser)
                    .build();
            log.info("Save RecommendedHistory! receiver : {} recommendUser: {}", detailUser.getEmail(), recommendedUser.getEmail());
            AutoRecommendHistory savedEntity = autoRecommendRepository.save(autoRecommendHistory);
        });
    }
}
