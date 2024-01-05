package com.flotting.api.user.repository;

import com.flotting.api.user.model.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {

//    Optional<UserProfileEntity> findById(int userNo);
    Optional<UserProfileEntity> findOneWithAuthoritiesByUserName(String userName);

    Optional<UserProfileEntity> findByUserNoAndEmail(long userNo, String email);
}