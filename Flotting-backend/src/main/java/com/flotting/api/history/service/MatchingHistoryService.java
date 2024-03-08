package com.flotting.api.history.service;

import com.flotting.api.history.entity.MatchingHistory;
import com.flotting.api.history.repository.MatchingHistoryRepository;
import com.flotting.api.util.type.MatchingProcessEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MatchingHistoryService {

    private  final MatchingHistoryRepository matchingHistoryRepository;

    @Transactional(readOnly = true)
    public List<MatchingHistory> getAll() {
        return matchingHistoryRepository.findAll();
    }

    @Transactional
    public void withdraw() {
        List<MatchingHistory> matchingHistories = getAll();
        matchingHistories.forEach(matchingHistory -> {
            LocalDateTime requestedAt = matchingHistory.getRequestedAt();
            boolean isExpired = requestedAt.plusDays(2).isBefore(LocalDateTime.now());
            log.info("Matching History Requester: {} Receiver: {} requestedAt: {} isExpired: {}",
                    matchingHistory.getRequester(), matchingHistory.getReceiver(), requestedAt, isExpired);
            if(MatchingProcessEnum.INPROGRESS.equals(matchingHistory.getMatchingProcess()) && isExpired) {
                matchingHistory.withdraw();
            }
        });
    }

    @Transactional
    public void saveMatchingHistory(MatchingHistory matchingHistory) {
        matchingHistoryRepository.save(matchingHistory);
    }
}
