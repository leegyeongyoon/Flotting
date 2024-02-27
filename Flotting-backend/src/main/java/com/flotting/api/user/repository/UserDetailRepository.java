package com.flotting.api.user.repository;


import com.flotting.api.user.entity.UserDetailEntity;
import com.flotting.api.user.enums.GenderEnum;
import com.flotting.api.user.repository.querydsl.UserDetailQueryDsl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long>, UserDetailQueryDsl {
    List<UserDetailEntity> findByGenderAndTotalScore(GenderEnum gender, int totalScore);

    Page<UserDetailEntity> findAllByIsApprovedOrderByCreatedAtDesc(Pageable pageable, boolean isApproved);

    Page<UserDetailEntity> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
