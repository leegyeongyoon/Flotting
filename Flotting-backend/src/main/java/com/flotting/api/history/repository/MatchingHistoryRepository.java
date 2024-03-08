package com.flotting.api.history.repository;

import com.flotting.api.history.entity.MatchingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchingHistoryRepository extends JpaRepository<MatchingHistory, Long> {
}
