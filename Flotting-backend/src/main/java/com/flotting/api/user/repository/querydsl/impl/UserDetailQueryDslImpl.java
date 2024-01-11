package com.flotting.api.user.repository.querydsl.impl;


import com.flotting.api.user.enums.*;
import com.flotting.api.user.model.QUserResponseDto;
import com.flotting.api.user.model.UserFilterRequestDto;
import com.flotting.api.user.model.UserDetailResponseDto;
import com.flotting.api.user.model.UserResponseDto;
import com.flotting.api.user.repository.querydsl.UserDetailQueryDsl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.flotting.api.user.entity.QUserDetailEntity.userDetailEntity;
import static com.flotting.api.user.entity.QUserSimpleEntity.userSimpleEntity;

@RequiredArgsConstructor
@Repository
public class UserDetailQueryDslImpl implements UserDetailQueryDsl {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailResponseDto> findUsersByGrade(GradeEnum grade) {
        return jpaQueryFactory
                .selectFrom(userDetailEntity)
                .where(userDetailEntity.grade.eq(grade))
                .fetch()
                .stream().map(UserDetailResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailResponseDto> findAllDetailUsers() {
        return jpaQueryFactory
                .selectFrom(userDetailEntity)
                .fetch()
                .stream().map(UserDetailResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDto> findUsersByFilter(UserFilterRequestDto filter) {
        List<UserResponseDto> result = jpaQueryFactory
                .select(new QUserResponseDto(userSimpleEntity.userNo, userSimpleEntity.age, userSimpleEntity.job, userSimpleEntity.userStatus, userSimpleEntity.phoneNumber,
                        userSimpleEntity.name, userDetailEntity.appliedPath, userDetailEntity.body, userDetailEntity.detailJob, userDetailEntity.charm,
                        userDetailEntity.drinking, userDetailEntity.education, userDetailEntity.email, userDetailEntity.grade,
                        userDetailEntity.height, userDetailEntity.hobby, userDetailEntity.location,
                        userDetailEntity.loveValues, userDetailEntity.nickName, userDetailEntity.preference, userDetailEntity.preferenceDetail,
                        userDetailEntity.gender, userDetailEntity.smoking, userDetailEntity.recommendUserName))
                .from(userSimpleEntity)
                .leftJoin(userSimpleEntity.userDetailEntity, userDetailEntity)
                .where(userSimpleEntity.userDetailEntity.eq(userDetailEntity)
                        .and(genderEq(filter.getGender()))
                        .and(bodyEq(filter.getBody()))
                        .and(userDetailEntity.height.between(filter.getStartValue(filter.getStartHeight()), filter.getEndValue(filter.getEndHeight())))
                        .and(statusEq(filter.getStatus()))
                        .and(locationEq(filter.getLocation()))
                        .and(userSimpleEntity.age.between(filter.getStartValue(filter.getStartAge()), filter.getEndValue(filter.getEndAge())))
                        .and(gradeEq(filter.getGrade()))
                        .and(jobEq(filter.getJob()))
                        .and(smokingEq(filter.getSmoke())))
                .fetch();
        return result;
    }

    private BooleanBuilder genderEq(GenderEnum genderEnum) {
        return nullSafeBuilder(() -> userDetailEntity.gender.eq(genderEnum));
    }

    private BooleanBuilder bodyEq(BodyEnum bodyEnum) {
        return nullSafeBuilder(() -> userDetailEntity.body.eq(bodyEnum));
    }

    private BooleanBuilder statusEq(UserStatusEnum statusEnum) {
        return nullSafeBuilder(() -> userSimpleEntity.userStatus.eq(statusEnum));
    }

    private BooleanBuilder locationEq(LocationEnum locationEnum) {
        return nullSafeBuilder(() -> userDetailEntity.location.eq(locationEnum));
    }

    private BooleanBuilder gradeEq(GradeEnum gradeEnum) {
        return nullSafeBuilder(() -> userDetailEntity.grade.eq(gradeEnum));
    }

    private BooleanBuilder smokingEq(Boolean smoking) {
        return nullSafeBuilder(() -> userDetailEntity.smoking.eq(smoking));
    }

    private BooleanBuilder jobEq(JobEnum jobEnum) {
        return nullSafeBuilder(() -> userSimpleEntity.job.eq(jobEnum));
    }


}
