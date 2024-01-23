package com.flotting.api.history.service;

import com.flotting.api.user.entity.UserDetailProfile;
import com.flotting.api.user.entity.UserSimpleProfile;
import com.flotting.api.user.model.UserFilterRequestDto;
import com.flotting.api.user.model.UserResponseDto;
import com.flotting.api.user.service.UserService;
import com.flotting.api.util.type.PreferenceEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AutoRecommendService {

    private final UserService userService;
    /**
     * userSimpleProfile의 랜덤 2인 매칭
     */
    //TODO 매칭기준 기획 필요
    public void createAutoRecommend(Long userNo) {
        UserSimpleProfile user = userService.getSimpleUser(userNo);

        UserDetailProfile detailUser = userService.getDetailUser(userNo);
        /**
         * [
         *      {type : body, value : normal},
         *      {type : location, value : south}
         * ]
         * String -> JSON
         *https://docs.google.com/spreadsheets/d/1Qo3gz2-cI15_nvB-tAHQiPhWMVNekzpsnxhoJqnyNbI/edit?pli=1#gid=376416439
         *
         * 1순위 : 동일 등급& 취향1개일치
         * 2순위 : 취향1개 일치하는 사람 필터
         * 3순위 : 2순위에서 걸러진 사람이 3명 이상이면 그 중 유사 등급으로 내림차순 하여 2명 필터
         */

        UserFilterRequestDto userFilterRequestDto = new UserFilterRequestDto();


        List<UserResponseDto> usersByFilter = userService.getUsersByFilter(userFilterRequestDto);




    }
}
