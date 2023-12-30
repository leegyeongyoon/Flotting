package com.flotting.api.user.repository.querydsl;

import com.flotting.api.user.model.UserFilterRequestDto;
import com.flotting.api.user.model.UserDetailResponseDto;
import com.flotting.domain.type.GradeEnum;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.List;
import java.util.function.Supplier;

public interface UserDetailQueryDsl {

    List<UserDetailResponseDto> findUsersByGrade(GradeEnum grade);

    List<UserDetailResponseDto> findAllDetailUsers();

    List<UserDetailResponseDto> findUsersByFilter(UserFilterRequestDto filter);

    default BooleanBuilder nullSafeBuilder(Supplier<BooleanExpression> f) {
        try {
            return new BooleanBuilder(f.get());
        } catch (IllegalArgumentException | NullPointerException e) {
            return new BooleanBuilder();
        }
    }
}
