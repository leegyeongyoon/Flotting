package com.flotting.api.user.repository.querydsl.impl;


import com.flotting.api.user.model.UserFilterRequestDto;
import com.flotting.api.user.model.UserDetailResponseDto;
import com.flotting.api.user.repository.querydsl.UserDetailQueryDsl;
import com.flotting.domain.type.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.flotting.domain.QUserDetailProfile.userDetailProfile;
import static com.flotting.domain.QUserSimpleProfile.userSimpleProfile;

@RequiredArgsConstructor
@Repository
public class UserDetailQueryDslImpl implements UserDetailQueryDsl {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailResponseDto> findUsersByGrade(GradeEnum grade) {
        return jpaQueryFactory
                .selectFrom(userDetailProfile)
                .where(userDetailProfile.grade.eq(grade))
                .fetch()
                .stream().map(UserDetailResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailResponseDto> findAllDetailUsers() {
        return jpaQueryFactory
                .selectFrom(userDetailProfile)
                .fetch()
                .stream().map(UserDetailResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailResponseDto> findUsersByFilter(UserFilterRequestDto filter) {
        return jpaQueryFactory
                .selectFrom(userDetailProfile)
                .rightJoin(userSimpleProfile)
                .on(userSimpleProfile.userDetailProfile.eq(userDetailProfile))
                .where(genderEq(filter.getGender())
                        .and(bodyEq(filter.getBody()))
                        .and(userDetailProfile.height.between(filter.getStartValue(filter.getStartHeight()), filter.getEndValue(filter.getEndHeight())))
                        .and(statusEq(filter.getStatus()))
                        .and(locationEq(filter.getLocation()))
                        .and(userSimpleProfile.age.between(filter.getStartValue(filter.getStartAge()), filter.getEndValue(filter.getEndAge())))
                        .and(gradeEq(filter.getGrade()))
                        .and(jobEq(filter.getJob()))
                        .and(smokingEq(filter.getSmoke())))
                .fetch()
                .stream().map(UserDetailResponseDto::new)
                .collect(Collectors.toList());
    }

    private BooleanBuilder genderEq(GenderEnum genderEnum) {
        return nullSafeBuilder(() -> userDetailProfile.gender.eq(genderEnum));
    }

    private BooleanBuilder bodyEq(BodyEnum bodyEnum) {
        return nullSafeBuilder(() -> userDetailProfile.body.eq(bodyEnum));
    }

    private BooleanBuilder statusEq(UserStatusEnum statusEnum) {
        return nullSafeBuilder(() -> userSimpleProfile.userStatus.eq(statusEnum));
    }

    private BooleanBuilder locationEq(LocationEnum locationEnum) {
        return nullSafeBuilder(() -> userDetailProfile.location.eq(locationEnum));
    }

    private BooleanBuilder gradeEq(GradeEnum gradeEnum) {
        return nullSafeBuilder(() -> userDetailProfile.grade.eq(gradeEnum));
    }

    private BooleanBuilder smokingEq(Boolean smoking) {
        return nullSafeBuilder(() -> userDetailProfile.smoking.eq(smoking));
    }

    private BooleanBuilder jobEq(JobEnum jobEnum) {
        return nullSafeBuilder(() -> userSimpleProfile.job.eq(jobEnum));
    }
}
