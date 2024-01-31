package com.flotting.api.user.repository.querydsl;

import com.flotting.api.user.model.UserDetailResponseDto;
import com.flotting.api.user.model.UserSimpleResponseDto;

import java.util.List;

public interface UserSimpleQueryDsl {

    List<UserSimpleResponseDto> findAllSimpleUserInfos();

}
