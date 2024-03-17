package com.flotting.api.history.service;

import com.flotting.api.history.entity.AutoRecommendHistory;
import com.flotting.api.user.SampleDataMaker;
import com.flotting.api.user.model.UserSimpleResponseDto;
import com.flotting.api.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class AutoRecommendServiceTest extends SampleDataMaker {

    @Autowired
    private AutoRecommendService autoRecommendService;
    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void autoRecommendTest() {
        //given
        makeUserData();

        //when
        //TODO 자동매칭알고리즘 테스트
        List<UserSimpleResponseDto> simpleUserInfos = userService.getSimpleUserInfos(Pageable.ofSize(20));
        UserSimpleResponseDto firstUser = simpleUserInfos.get(0);
        autoRecommendService.createAutoRecommend(firstUser.getUserNo());
        List<AutoRecommendHistory> result = autoRecommendService.getAll();

        //then
        Assertions.assertEquals(result.get(0).getReceiver().getUserNo(), firstUser.getUserNo());
        Assertions.assertEquals(result.get(1).getReceiver().getUserNo(), firstUser.getUserNo());
    }

}