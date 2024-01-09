package com.flotting.api.manager.repository;

import com.flotting.api.manager.entity.ManagerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerProfile, Long> {
}
