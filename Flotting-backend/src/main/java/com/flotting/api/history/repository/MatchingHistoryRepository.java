package com.flotting.api.history.repository;

import com.flotting.api.history.entity.MatchingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchingHistoryRepository extends JpaRepository<MatchingHistory, Long> {

    List<MatchingHistory> findByRequester_UserNoOrReceiver_UserNo(Long requesterId, Long receiverId);
}
