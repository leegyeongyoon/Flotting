package com.flotting.api.user.repository.querydsl.impl;


import com.flotting.api.user.model.UserDetailResponseDto;
import com.flotting.api.user.model.UserSimpleRequestDto;
import com.flotting.api.user.model.UserSimpleResponseDto;
import com.flotting.api.user.repository.querydsl.UserSimpleQueryDsl;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.flotting.domain.QUserSimpleProfile.userSimpleProfile;

@RequiredArgsConstructor
@Repository
public class UserSimpleQueryDslImpl implements UserSimpleQueryDsl {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    @Transactional(readOnly = true)
    public List<UserSimpleResponseDto> findAllSimpleUsers() {
        return jpaQueryFactory
                .selectFrom(userSimpleProfile)
                .fetch()
                .stream().map(UserSimpleResponseDto::new)
                .collect(Collectors.toList());
    }

}
