package com.flotting.api.user.repository.querydsl;

import com.flotting.api.user.model.UserFilterRequestDto;
import com.flotting.api.user.model.UserDetailResponseDto;
import com.flotting.api.user.model.UserResponseDto;
import com.flotting.api.user.enums.GenderEnum;
import com.flotting.api.user.enums.GradeEnum;
import com.flotting.api.user.enums.PreferenceEnum;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public interface UserDetailQueryDsl {

    List<UserDetailResponseDto> findUsersByGrade(GradeEnum grade);

    List<UserDetailResponseDto> findAllDetailUsers();

    List<UserResponseDto> findUsersByFilter(UserFilterRequestDto filter);

    Set<UserResponseDto> findUsersByScoreAndPreference(GenderEnum gender, int totalScore, PreferenceEnum preference, List<String> preferenceValue);
    Set<UserResponseDto> findUsersByPreference(GenderEnum gender, int score, PreferenceEnum preference, List<String> preferenceValue);

    default BooleanBuilder nullSafeBuilder(Supplier<BooleanExpression> f) {
        try {
            return new BooleanBuilder(f.get());
        } catch (IllegalArgumentException | NullPointerException e) {
            return new BooleanBuilder();
        }
    }
}
