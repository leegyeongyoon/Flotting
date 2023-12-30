package com.flotting.api.user.repository;


import com.flotting.api.user.repository.querydsl.UserSimpleQueryDsl;
import com.flotting.domain.UserDetailProfile;
import com.flotting.domain.UserSimpleProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSimpleRepository extends JpaRepository<UserSimpleProfile, Long>, UserSimpleQueryDsl {
}
