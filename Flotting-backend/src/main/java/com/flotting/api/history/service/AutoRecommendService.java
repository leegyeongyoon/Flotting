package com.flotting.api.history.service;

import com.flotting.api.history.entity.AutoRecommendHistory;
import com.flotting.api.history.repository.AutoRecommendRepository;
import com.flotting.api.user.entity.UserDetailEntity;
import com.flotting.api.user.entity.UserSimpleEntity;
import com.flotting.api.user.enums.GradeEnum;
import com.flotting.api.user.model.UserDetailResponseDto;
import com.flotting.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class AutoRecommendService {

    private final UserService userService;
    private final AutoRecommendRepository autoRecommendRepository;
    private final MatchingHistoryService matchingHistoryService;

    /**
     * userSimpleEntity의 랜덤 2인 매칭
     * 이전에 소개받은 사람이 나와선 안된다.
     * 가입 후 2주동안은 한등급 높은 이성을 소개해준다.
     * 그 이후부터는 동일등급의 이성을 소개해준다.
     * 2명이상의 리스트가 나올경우, 나이차가 적은 사람 순으로 정렬해서 2명만 소개, 만약 3명이상이면 랜덤 2명고르기
     * 자동 매칭 결과가 2명 미만일 경우 프로필 대신에 매니저에게 문의주세요 문구생성
     */
    //TODO 매칭기준 기획 필요
    public void createAutoRecommend(Long simpleProfileId) {
        UserSimpleEntity targetUser = userService.getSimpleUser(simpleProfileId);
        UserDetailEntity targetDetailUser = targetUser.getUserDetailEntity();
        /**
         * 자동 매칭 이력에 존재하는 사람 제외
         * 플러팅 이력 존재하는 사람 제외
         * 가입 기간 2주 이하 이상 체크 필요
         *      < 2주 : 한등급 높은 이성등급
         *      > 2부 : 동일 이성등급
         * 2명 초과일 경우, 나이차 적은 순 오름차순 정렬하여 2명 필터
         * 이래도 2명 초과일 경우, 랜덤 2명 필터
         * 2명 미만일 경우, 매니저에게 문의주세요 문구생성
         */
        //TODO : 가입 일자 기준이 1차 프로필 등록 직후 or  2차프로필 등록 직후
        boolean isSignedUpOverTwoWeeks = LocalDateTime.now().isAfter(targetDetailUser.getCreatedAt().plusWeeks(2));
        GradeEnum targetGrade = isSignedUpOverTwoWeeks ? targetDetailUser.getGrade() : GradeEnum.getUpperGrade(targetDetailUser.getGrade());
        Set<Long> alreadyAutoRecommendedUsers = getRecommendedUsers(targetUser.getUserNo());
        Set<Long> alreadyMatchedUsers = matchingHistoryService.getRecommendedUsers(targetUser.getUserNo());
        alreadyAutoRecommendedUsers.addAll(alreadyMatchedUsers);
        List<Long> exceptIds = alreadyAutoRecommendedUsers.stream().toList();

        List<UserDetailResponseDto> result = userService.getUsersByGradeAndSimpleProfileIdsNotInLimitTwo(targetGrade, exceptIds, targetUser);
        if (result.size() < 2){
            //TODO 2명 미만일 경우, 매니저에게 문의주세요 문구생성
        }

        result.forEach(data -> {
            Long recommendedUserId = data.getSeq();
            UserDetailEntity recommendedUser = userService.getDetailUser(recommendedUserId);
            AutoRecommendHistory autoRecommendHistory = AutoRecommendHistory.builder()
                    .receiver(targetUser)
                    .profile(recommendedUser.getUserSimpleEntity())
                    .build();
            log.info("Save RecommendedHistory! receiver : {} recommendUser: {}", targetDetailUser.getEmail(), recommendedUser.getEmail());
            AutoRecommendHistory savedEntity = autoRecommendRepository.save(autoRecommendHistory);
        });
    }

    @Transactional(readOnly = true)
    public Set<Long> getRecommendedUsers(Long targetUserId) {
        Set<Long> result = new HashSet<>();
        result.add(targetUserId);
        List<AutoRecommendHistory> datas = autoRecommendRepository.findByReceiver_UserNoOrProfile_UserNo(targetUserId, targetUserId);
        datas.forEach(data -> {
            result.add(data.getProfile().getUserNo());
            result.add(data.getReceiver().getUserNo());
        });
        result.remove(targetUserId);
        log.info("getRecommendedUsers! targetUser : {} RecommendedUsers : {}", targetUserId, result.toString());
        return result;
    }

    @Transactional(readOnly = true)
    public List<AutoRecommendHistory> getAll() {
        return autoRecommendRepository.findAll();
    }
}
