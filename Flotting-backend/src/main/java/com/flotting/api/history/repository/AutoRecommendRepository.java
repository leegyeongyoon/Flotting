package com.flotting.api.history.repository;

import com.flotting.api.history.entity.AutoRecommendHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRecommendRepository extends JpaRepository<AutoRecommendHistory, Long> {

    List<AutoRecommendHistory> findByReceiver_UserNoOrProfile_UserNo(Long receiverId, Long profileId);
}
