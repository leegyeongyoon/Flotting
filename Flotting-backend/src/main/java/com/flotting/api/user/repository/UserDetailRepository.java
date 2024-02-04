package com.flotting.api.user.repository;


import com.flotting.api.user.repository.querydsl.UserDetailQueryDsl;
import com.flotting.api.user.entity.UserDetailProfile;
import com.flotting.api.util.type.GenderEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDetailRepository extends JpaRepository<UserDetailProfile, Long>, UserDetailQueryDsl {

    List<UserDetailProfile> findByGenderAndTotalScore(GenderEnum gender, int totalScore);
}
