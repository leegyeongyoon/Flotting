package com.flotting.api.user.repository;


import com.flotting.api.user.repository.querydsl.UserDetailQueryDsl;
import com.flotting.api.user.repository.querydsl.UserSimpleQueryDsl;
import com.flotting.domain.UserDetailProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetailProfile, Long>, UserDetailQueryDsl {
}
