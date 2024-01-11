package com.flotting.api.user.repository;


import com.flotting.api.user.repository.querydsl.UserDetailQueryDsl;
import com.flotting.api.user.entity.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long>, UserDetailQueryDsl {
}
