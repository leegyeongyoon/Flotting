package com.flotting.api.user.repository.querydsl.impl;


import com.flotting.api.user.model.QUserResponseDto;
import com.flotting.api.user.model.UserFilterRequestDto;
import com.flotting.api.user.model.UserDetailResponseDto;
import com.flotting.api.user.model.UserResponseDto;
import com.flotting.api.user.repository.querydsl.UserDetailQueryDsl;
import com.flotting.api.util.type.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.CollectionExpression;
import com.querydsl.core.types.Expression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.flotting.api.user.entity.QUserDetailProfile.userDetailProfile;
import static com.flotting.api.user.entity.QUserSimpleProfile.userSimpleProfile;
import static com.flotting.api.util.type.PreferenceEnum.*;


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
    public List<UserResponseDto> findUsersByFilter(UserFilterRequestDto filter) {
        List<UserResponseDto> result = jpaQueryFactory
                .select(new QUserResponseDto(userSimpleProfile.userNo, userSimpleProfile.age, userSimpleProfile.job, userSimpleProfile.userStatus, userSimpleProfile.phoneNumber,
                        userSimpleProfile.name, userDetailProfile.appliedPath, userDetailProfile.body, userDetailProfile.detailJob, userDetailProfile.charm,
                        userDetailProfile.drinking, userDetailProfile.education, userDetailProfile.email, userDetailProfile.grade,
                        userDetailProfile.height, userDetailProfile.hobby, userDetailProfile.location,
                        userDetailProfile.loveValues, userDetailProfile.nickName, userDetailProfile.preference, userDetailProfile.preferenceDetail,
                        userDetailProfile.gender, userDetailProfile.smoking, userDetailProfile.recommendUserName, userDetailProfile.seq))
                .from(userSimpleProfile)
                .leftJoin(userSimpleProfile.userDetailProfile, userDetailProfile)
                .where(userSimpleProfile.userDetailProfile.eq(userDetailProfile)
                        .and(genderEq(filter.getGender()))
                        .and(bodyEq(filter.getBody()))
                        .and(userDetailProfile.height.between(filter.getStartValue(filter.getStartHeight()), filter.getEndValue(filter.getEndHeight())))
                        .and(statusEq(filter.getStatus()))
                        .and(locationEq(filter.getLocation()))
                        .and(userSimpleProfile.age.between(filter.getStartValue(filter.getStartAge()), filter.getEndValue(filter.getEndAge())))
                        .and(gradeEq(filter.getGrade()))
                        .and(jobEq(filter.getJob()))
                        .and(smokingEq(filter.getSmoke())))
                .fetch();
        return result;
    }

    @Override
    public Set<UserResponseDto> findUsersByScoreAndPreference(GenderEnum gender, int totalScore, PreferenceEnum preference, List<String> preferenceValue) {
        Set<UserResponseDto> result = jpaQueryFactory
                .select(new QUserResponseDto(userSimpleProfile.userNo, userSimpleProfile.age, userSimpleProfile.job, userSimpleProfile.userStatus, userSimpleProfile.phoneNumber,
                        userSimpleProfile.name, userDetailProfile.appliedPath, userDetailProfile.body, userDetailProfile.detailJob, userDetailProfile.charm,
                        userDetailProfile.drinking, userDetailProfile.education, userDetailProfile.email, userDetailProfile.grade,
                        userDetailProfile.height, userDetailProfile.hobby, userDetailProfile.location,
                        userDetailProfile.loveValues, userDetailProfile.nickName, userDetailProfile.preference, userDetailProfile.preferenceDetail,
                        userDetailProfile.gender, userDetailProfile.smoking, userDetailProfile.recommendUserName, userDetailProfile.seq))
                .from(userSimpleProfile)
                .leftJoin(userSimpleProfile.userDetailProfile, userDetailProfile)
                .where(userSimpleProfile.userDetailProfile.eq(userDetailProfile)
                        .and(genderNotEq(gender))
                        .and(userDetailProfile.totalScore.eq(totalScore))
                        .and(preferenceEq(preference, preferenceValue)))
                .limit(2)
                .fetch()
                .stream().collect(Collectors.toSet());
        return result;
    }

    @Override
    public Set<UserResponseDto> findUsersByPreference(GenderEnum gender, int score, PreferenceEnum preference, List<String> preferenceValue) {
        Set<UserResponseDto> result = jpaQueryFactory
                .select(new QUserResponseDto(userSimpleProfile.userNo, userSimpleProfile.age, userSimpleProfile.job, userSimpleProfile.userStatus, userSimpleProfile.phoneNumber,
                        userSimpleProfile.name, userDetailProfile.appliedPath, userDetailProfile.body, userDetailProfile.detailJob, userDetailProfile.charm,
                        userDetailProfile.drinking, userDetailProfile.education, userDetailProfile.email, userDetailProfile.grade,
                        userDetailProfile.height, userDetailProfile.hobby, userDetailProfile.location,
                        userDetailProfile.loveValues, userDetailProfile.nickName, userDetailProfile.preference, userDetailProfile.preferenceDetail,
                        userDetailProfile.gender, userDetailProfile.smoking, userDetailProfile.recommendUserName, userDetailProfile.seq))
                .from(userSimpleProfile)
                .leftJoin(userSimpleProfile.userDetailProfile, userDetailProfile)
                .where(userSimpleProfile.userDetailProfile.eq(userDetailProfile)
                        .and(genderNotEq(gender))
                        .and(preferenceEq(preference, preferenceValue)))
                .orderBy(userDetailProfile.totalScore.subtract(score).abs().asc())
                .limit(2)
                .fetch()
                .stream().collect(Collectors.toSet());
        return result;
    }

    private BooleanBuilder preferenceEq(PreferenceEnum preferenceEnum, List<String> value) {
        switch(preferenceEnum) {
            case AGE:
                List<Integer> ages = value.stream().map(Integer::parseInt).collect(Collectors.toList());
                return nullSafeBuilder(() -> userSimpleProfile.age.in(ages));
            case DISTANCE:
                List<LocationEnum> locations = value.stream().map(LocationEnum::valueOf).collect(Collectors.toList());
                return nullSafeBuilder(() -> userDetailProfile.location.in(locations));
            case HEIGHT:
                List<Integer> heights = value.stream().map(Integer::parseInt).collect(Collectors.toList());
                return nullSafeBuilder(() -> userDetailProfile.height.in(heights));
            case JOB:
                List<JobEnum> jobs = value.stream().map(JobEnum::valueOf).collect(Collectors.toList());
                return nullSafeBuilder(() -> userSimpleProfile.job.in(jobs));
            default :
                return nullSafeBuilder(() -> userSimpleProfile.age.ne(0));
        }
    }

    private BooleanBuilder genderEq(GenderEnum genderEnum) {
        return nullSafeBuilder(() -> userDetailProfile.gender.eq(genderEnum));
    }

    private BooleanBuilder genderNotEq(GenderEnum genderEnum) {
        return nullSafeBuilder(() -> userDetailProfile.gender.notIn(genderEnum));
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
