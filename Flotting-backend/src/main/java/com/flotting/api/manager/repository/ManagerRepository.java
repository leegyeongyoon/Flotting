package com.flotting.api.manager.repository;

import com.flotting.domain.ManagerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerProfile, Long> {
}
