package com.flotting.api.user.repository.querydsl.impl;

import com.flotting.api.user.SampleDataMaker;
import com.flotting.api.user.enums.*;
import com.flotting.api.user.model.*;
import com.flotting.api.user.service.UserService;
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
        UserSimpleResponseDto userSimpleResponseDto = userService.saveSimpleUserInfo(requestDto);

        //then
        Assertions.assertThat(userSimpleResponseDto).isNotNull();
        Assertions.assertThat(userSimpleResponseDto.getName()).isEqualTo(requestDto.getName());
    }

    @Test
    public void 사용자_2차프로필_저장() {
        //given
        UserSimpleResponseDto userSimpleResponseDto = userService.saveSimpleUserInfo(UserSimpleRequestDto.builder()
                .name("ABC")
                .job(JobEnum.BUSNINESS.name())
                .age(20)
                .phoneNumber("01043394339")
                .build());
        UserDetailRequestDto requestDto = UserDetailRequestDto.builder()
                .height(190)
                .smoking(Boolean.FALSE)
                .body(BodyEnum.SLIM.name())
                .charm("abc")
                .detailJob("abc")
                .drinking(DrinkingEnum.ONE_WEEK.name())
                .education(EducationEnum.COLLEGE_ACADEMY_ATTENDING.name())
                .email("abc")
                .grade(GradeEnum.D.name())
                .hobby("abc")
                .location(LocationEnum.SEOUL_EAST.name())
                .loveValues("abc")
                .nickName("bing")
                .path(AppliedPathEnum.ETC.name())
                .gender(GenderEnum.F.name())
                .preference(PreferenceEnum.AGE.name())
                .preferenceDetail("abc")
                .recommendUserName("abc")
                .URI("uri").build();

        //when
        UserDetailResponseDto userDetailResponseDto = userService.saveDetailUserInfo(userSimpleResponseDto.getUserNo(), requestDto);

        //then
        Assertions.assertThat(userDetailResponseDto).isNotNull();
        Assertions.assertThat(userDetailResponseDto.getBody()).isEqualTo(requestDto.getBody());
    }

    @Test
    public void 사용자_1차프로필_조회() {
        //given
        makeUserData();

        //when
        List<UserSimpleResponseDto> SimpleUserInfos = userService.getSimpleUserInfos();

        //then
        Assertions.assertThat(SimpleUserInfos.size()).isEqualTo(6);
    }

    @Test
    public void 사용자_2차프로필_조회() {
        //given
        List<UserResponseDto> userResponseDtos = makeUserData();

        //when
        List<UserDetailResponseDto> detailUsers = userService.getDetailUserInfos();

        //then
        Assertions.assertThat(detailUsers.size()).isEqualTo(6);
    }

    @Test
    public void 사용자_등급별_조회() {
        //given
        List<UserResponseDto> userResponseDtos = makeUserData();

        //when
        List<UserDetailResponseDto> users = userService.getDetailUserInfosByGrade(GradeEnum.D.name());

        //then
        Assertions.assertThat(users.size()).isEqualTo(3);
    }

    @Test
    public void 사용자_필터링() {
        //TODO 입력안하는거는 all
        //given
        makeUserData();

        //when
        UserFilterRequestDto userFilterRequestDto = new UserFilterRequestDto();
        List<String> body = List.of(BodyEnum.NORMAL.name(), BodyEnum.RELIABLE.name());
        userFilterRequestDto.setBody(body);
        List<UserResponseDto> users = userService.getUsersByFilter(userFilterRequestDto);

        //then
        Assertions.assertThat(users.size()).isEqualTo(1);
        Assertions.assertThat(users.get(0).getBody()).isEqualTo(BodyEnum.NORMAL.name());
    }
}