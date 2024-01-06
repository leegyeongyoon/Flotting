package com.flotting.api.user.repository;


import com.flotting.api.user.model.UserProfileEntity;
import com.flotting.api.user.repository.querydsl.UserSimpleQueryDsl;
import com.flotting.domain.UserDetailProfile;
import com.flotting.domain.UserSimpleProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSimpleRepository extends JpaRepository<UserSimpleProfile, Long>, UserSimpleQueryDsl {
    Optional<UserSimpleProfile> findOneWithAuthoritiesByName(String userName);

}
