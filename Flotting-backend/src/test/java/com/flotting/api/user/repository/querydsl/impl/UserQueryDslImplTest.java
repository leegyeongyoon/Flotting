package com.flotting.api.user.repository.querydsl.impl;

import com.flotting.api.user.SampleDataMaker;
import com.flotting.api.user.model.*;
import com.flotting.api.user.service.UserService;
import com.flotting.config.TokenUser;
import com.flotting.domain.UserDetailProfile;
import com.flotting.domain.UserSimpleProfile;
import com.flotting.domain.type.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class UserQueryDslImplTest extends SampleDataMaker {

    @Autowired
    private UserService userService;

    private TokenUser defaultUser = TokenUser.defaultUser();
    
    @Test
    public void 사용자_1차프로필_저장() {
        //given
        UserSimpleRequestDto requestDto = UserSimpleRequestDto.builder()
                .name("ABC")
                .job(JobEnum.BUSNINESS.name())
                .age(20)
                .phoneNumber("01043394339")
                .build();

        //when
        UserSimpleResponseDto userSimpleProfile = userService.saveSimpleUserInfo(requestDto);

        //then
        Assertions.assertThat(userSimpleProfile).isNotNull();
        Assertions.assertThat(userSimpleProfile.getName()).isEqualTo(requestDto.getName());
    }

    @Test
    public void 사용자_2차프로필_저장() {
        //given
        UserDetailRequestDto requestDto = UserDetailRequestDto.builder()
                .height(190)
                .smoking(Boolean.FALSE)
                .body(BodyEnum.SLIM.name())
                .charm("abc")
                .detailJob("abc")
                .drinking(DrinkingEnum.A.name())
                .education(EducationEnum.A.name())
                .email("abc")
                .grade(GradeEnum.D.name())
                .hobby("abc")
                .location(LocationEnum.SEOUL_EAST.name())
                .loveValues("abc")
                .nickName("bing")
                .path(AppliedPathEnum.H.name())
                .gender(GenderEnum.F.name())
                .preference(PreferenceEnum.AGE.name())
                .preferenceDetail("abc")
                .recommendUserName("abc")
                .URI("uri").build();

        //when
        UserDetailProfile savedEntity = userService.saveDetailUserInfo(requestDto);

        //then
        Assertions.assertThat(savedEntity).isNotNull();
        Assertions.assertThat(savedEntity.getBody().name()).isEqualTo(requestDto.getBody());
    }

    @Test
    public void 사용자_1차프로필_조회() {
        //given
        makeUserData();

        //when
        List<UserSimpleResponseDto> simpleUsers = userService.getSimpleUsers(defaultUser);

        //then
        Assertions.assertThat(simpleUsers.size()).isEqualTo(6);
    }

    @Test
    public void 사용자_2차프로필_조회() {
        //given
        makeUserData();

        //when
        List<UserDetailResponseDto> detailUsers = userService.getDetailUsers(defaultUser);

        //then
        Assertions.assertThat(detailUsers.size()).isEqualTo(6);
    }

    @Test
    public void 사용자_등급별_조회() {
        //given
        makeUserData();

        //when
        List<UserDetailResponseDto> users = userService.getDetailUsersByGrade(defaultUser, GradeEnum.D.name());

        //then
        Assertions.assertThat(users.size()).isEqualTo(3);
    }

    @Test
    public void 사용자_필터링() {
        //given
        makeUserData();

        //when
        UserFilterRequestDto userFilterRequestDto = new UserFilterRequestDto();
        userFilterRequestDto.setBody(BodyEnum.NORMAL.name());
        List<UserDetailResponseDto> users = userService.getUsersByFilter(defaultUser, userFilterRequestDto);

        //then
        Assertions.assertThat(users.size()).isEqualTo(1);
        Assertions.assertThat(users.get(0).getBody()).isEqualTo(BodyEnum.NORMAL.name());
    }
}