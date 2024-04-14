package com.flotting.api.user.repository.querydsl.impl;


import com.flotting.api.user.entity.UserSimpleEntity;
import com.flotting.api.user.enums.*;
import com.flotting.api.user.model.QUserResponseDto;
import com.flotting.api.user.model.UserDetailResponseDto;
import com.flotting.api.user.model.UserFilterRequestDto;
import com.flotting.api.user.model.UserResponseDto;
import com.flotting.api.user.repository.querydsl.UserDetailQueryDsl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
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
    public List<UserDetailResponseDto> findAllDetailUsers(Pageable pageable) {
        return jpaQueryFactory
                .selectFrom(userDetailEntity)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch()
                .stream().map(UserDetailResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDto> findUsersByFilter(UserFilterRequestDto filter, Pageable pageable) {
        List<UserResponseDto> result = jpaQueryFactory
                .select(new QUserResponseDto(userSimpleEntity.userNo, userSimpleEntity.age, userSimpleEntity.job, userSimpleEntity.userStatus, userSimpleEntity.phoneNumber,
                        userSimpleEntity.name, userDetailEntity.appliedPath, userDetailEntity.body, userDetailEntity.detailJob, userDetailEntity.charm,
                        userDetailEntity.drinking, userDetailEntity.education, userDetailEntity.email, userDetailEntity.grade,
                        userDetailEntity.height, userDetailEntity.hobby, userDetailEntity.location,
                        userDetailEntity.loveValues, userDetailEntity.nickName, userDetailEntity.preference, userDetailEntity.preferenceDetail,
                        userDetailEntity.gender, userDetailEntity.smoking, userDetailEntity.recommendUserName, userDetailEntity.seq))
                .from(userSimpleEntity)
                .leftJoin(userSimpleEntity.userDetailEntity, userDetailEntity)
                .where(userSimpleEntity.userDetailEntity.eq(userDetailEntity)
                        .and(genderEq(filter.getGender()))
                        .and(bodyIn(filter.getBody()))
                        .and(heightBetween(filter.getHeight()))
                        .and(statusIn(filter.isDormant()))
                        .and(locationIn(filter.getLocation()))
                        .and(ageBetween(filter.getAge()))
                        .and(gradeIn(filter.getGrade()))
                        .and(jobIn(filter.getJob()))
                        .and(smokingEq(filter.isSmoke()))
                        .and(userDetailEntity.isApproved.eq(filter.isApproved())))
                .offset(pageable.isPaged() ? pageable.getOffset() : 0)
                .limit(pageable.isPaged() ? pageable.getPageSize() : Integer.MAX_VALUE)
                .fetch();
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<UserResponseDto> findUsersByScoreAndPreference(GenderEnum gender, int totalScore, PreferenceEnum preference, List<String> preferenceValue) {
        Set<UserResponseDto> result = jpaQueryFactory
                .select(new QUserResponseDto(userSimpleEntity.userNo, userSimpleEntity.age, userSimpleEntity.job, userSimpleEntity.userStatus, userSimpleEntity.phoneNumber,
                        userSimpleEntity.name, userDetailEntity.appliedPath, userDetailEntity.body, userDetailEntity.detailJob, userDetailEntity.charm,
                        userDetailEntity.drinking, userDetailEntity.education, userDetailEntity.email, userDetailEntity.grade,
                        userDetailEntity.height, userDetailEntity.hobby, userDetailEntity.location,
                        userDetailEntity.loveValues, userDetailEntity.nickName, userDetailEntity.preference, userDetailEntity.preferenceDetail,
                        userDetailEntity.gender, userDetailEntity.smoking, userDetailEntity.recommendUserName, userDetailEntity.seq))
                .from(userSimpleEntity)
                .leftJoin(userSimpleEntity.userDetailEntity, userDetailEntity)
                .where(userSimpleEntity.userDetailEntity.eq(userDetailEntity)
                        .and(genderNotEq(gender))
                        .and(userDetailEntity.totalScore.eq(totalScore))
                        .and(preferenceEq(preference, preferenceValue)))
                .limit(2)
                .fetch()
                .stream().collect(Collectors.toSet());
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Set<UserResponseDto> findUsersByPreference(GenderEnum gender, int score, PreferenceEnum preference, List<String> preferenceValue) {
        Set<UserResponseDto> result = jpaQueryFactory
                .select(new QUserResponseDto(userSimpleEntity.userNo, userSimpleEntity.age, userSimpleEntity.job, userSimpleEntity.userStatus, userSimpleEntity.phoneNumber,
                        userSimpleEntity.name, userDetailEntity.appliedPath, userDetailEntity.body, userDetailEntity.detailJob, userDetailEntity.charm,
                        userDetailEntity.drinking, userDetailEntity.education, userDetailEntity.email, userDetailEntity.grade,
                        userDetailEntity.height, userDetailEntity.hobby, userDetailEntity.location,
                        userDetailEntity.loveValues, userDetailEntity.nickName, userDetailEntity.preference, userDetailEntity.preferenceDetail,
                        userDetailEntity.gender, userDetailEntity.smoking, userDetailEntity.recommendUserName, userDetailEntity.seq))
                .from(userSimpleEntity)
                .leftJoin(userSimpleEntity.userDetailEntity, userDetailEntity)
                .where(userSimpleEntity.userDetailEntity.eq(userDetailEntity)
                        .and(genderNotEq(gender))
                        .and(preferenceEq(preference, preferenceValue)))
                .orderBy(userDetailEntity.totalScore.subtract(score).abs().asc())
                .limit(2)
                .fetch()
                .stream().collect(Collectors.toSet());
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDetailResponseDto> findUsersByGradeAndSimpleProfileIdNotInOrderByAgeDiffAsc(GradeEnum grade, List<Long> ids, UserSimpleEntity targetUser, int limit) {
        return jpaQueryFactory
                .selectFrom(userDetailEntity)
                .where(userDetailEntity.grade.eq(grade)
                        .and(userDetailEntity.userSimpleEntity.userNo.notIn(ids))
                        .and(userDetailEntity.gender.ne(targetUser.getUserDetailEntity().getGender())))
                .orderBy(userDetailEntity.userSimpleEntity.age.subtract(targetUser.getAge()).abs().asc())
                .limit(limit)
                .fetch()
                .stream().map(UserDetailResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDetailResponseDto> findUsersBySimpleProfileIdNotInOrderByAgeDiffAsc(List<Long> ids, UserSimpleEntity targetUser, int limit) {
        return jpaQueryFactory
                .selectFrom(userDetailEntity)
                .where((userDetailEntity.userSimpleEntity.userNo.notIn(ids))
                        .and(userDetailEntity.gender.ne(targetUser.getUserDetailEntity().getGender())))
                .orderBy(userDetailEntity.grade.desc(), userDetailEntity.userSimpleEntity.age.subtract(targetUser.getAge()).abs().asc())
                .limit(limit)
                .fetch()
                .stream().map(UserDetailResponseDto::new)
                .collect(Collectors.toList());
    }

    private BooleanBuilder preferenceEq(PreferenceEnum preferenceEnum, List<String> value) {
        switch(preferenceEnum) {
            case AGE:
                List<Integer> ages = value.stream().map(Integer::parseInt).collect(Collectors.toList());
                return nullSafeBuilder(() -> userSimpleEntity.age.in(ages));
            case DISTANCE:
                List<LocationEnum> locations = value.stream().map(LocationEnum::valueOf).collect(Collectors.toList());
                return nullSafeBuilder(() -> userDetailEntity.location.in(locations));
            case HEIGHT:
                List<Integer> heights = value.stream().map(Integer::parseInt).collect(Collectors.toList());
                return nullSafeBuilder(() -> userDetailEntity.height.in(heights));
            case JOB:
                List<JobEnum> jobs = value.stream().map(JobEnum::valueOf).collect(Collectors.toList());
                return nullSafeBuilder(() -> userSimpleEntity.job.in(jobs));
            default :
                return nullSafeBuilder(() -> userSimpleEntity.age.ne(0));
        }
    }

    private BooleanBuilder heightBetween(UserFilterRequestDto.ScopeModel height) {
        return nullSafeBuilder(() -> userDetailEntity.height.between(height.getMin(), height.getMin()));
    }

    private BooleanBuilder ageBetween(UserFilterRequestDto.ScopeModel age) {
        return nullSafeBuilder(() -> userSimpleEntity.age.between(age.getMin(), age.getMax()));
    }

    private BooleanBuilder genderEq(GenderEnum genderEnum) {
        return nullSafeBuilder(() -> userDetailEntity.gender.eq(genderEnum));
    }

    private BooleanBuilder genderNotEq(GenderEnum genderEnum) {
        return nullSafeBuilder(() -> userDetailEntity.gender.notIn(genderEnum));
    }

    private BooleanBuilder bodyIn(List<BodyEnum> bodyEnum) {
        return nullSafeBuilder(() -> userDetailEntity.body.in(bodyEnum));
    }

    private BooleanBuilder statusIn(boolean isDormant) {
        return nullSafeBuilder(() -> {
            if(isDormant) {
                return userSimpleEntity.userStatus.eq(UserStatusEnum.DORMANT);
            } else {
                return userSimpleEntity.userStatus.in(UserStatusEnum.NORMAL);
            }
        });
    }

    private BooleanBuilder locationIn(List<LocationEnum> locationEnum) {
        return nullSafeBuilder(() -> userDetailEntity.location.in(locationEnum));
    }

    private BooleanBuilder gradeIn(List<GradeEnum> gradeEnum) {
        return nullSafeBuilder(() -> userDetailEntity.grade.in(gradeEnum));
    }

    private BooleanBuilder smokingEq(boolean isSmoke) {
        return nullSafeBuilder(() -> userDetailEntity.smoking.eq(isSmoke));
    }

    private BooleanBuilder jobIn(List<JobEnum> jobEnum) {
        return nullSafeBuilder(() -> userSimpleEntity.job.in(jobEnum));
    }

}
