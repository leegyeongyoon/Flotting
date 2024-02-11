package com.flotting.api.user.repository;


import com.flotting.api.user.entity.UserDetailEntity;
import com.flotting.api.user.repository.querydsl.UserDetailQueryDsl;
import com.flotting.api.user.enums.GenderEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long>, UserDetailQueryDsl {
    List<UserDetailEntity> findByGenderAndTotalScore(GenderEnum gender, int totalScore);
}
