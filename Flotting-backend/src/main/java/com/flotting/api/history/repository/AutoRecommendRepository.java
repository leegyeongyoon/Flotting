package com.flotting.api.history.repository;

import com.flotting.api.history.entity.AutoRecommendHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRecommendRepository extends JpaRepository<AutoRecommendHistory, Long> {
}
