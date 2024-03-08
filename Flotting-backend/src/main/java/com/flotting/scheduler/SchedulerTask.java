package com.flotting.scheduler;

import com.flotting.api.history.service.MatchingHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SchedulerTask {

    private final MatchingHistoryService matchingHistoryService;

    /**
     * 매칭권 회수
     */
    @Scheduled(cron = "0 0 0 31 12 *")
    public void withdrawMatchingTicket() {
        matchingHistoryService.withdraw();
    }
}
