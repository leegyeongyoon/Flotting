package com.flotting.api.history.service;

import com.flotting.api.user.SampleDataMaker;
import com.flotting.api.user.model.UserDetailResponseDto;
import com.flotting.api.user.repository.UserDetailRepository;
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
    private UserDetailRepository userDetailRepository;

    @Test
    @Transactional
    public void autoRecommendTest() {
        //given
        makeUserData();

        //when
        List<UserDetailResponseDto> allUsers = userDetailRepository.findAllDetailUsers(Pageable.unpaged());
        UserDetailResponseDto firstUser = allUsers.get(0);
        autoRecommendService.createAutoRecommend(firstUser.getSeq());

        //then
    }

}