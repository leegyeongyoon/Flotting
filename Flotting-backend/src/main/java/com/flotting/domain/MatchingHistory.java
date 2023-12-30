package com.flotting.domain;

import com.flotting.domain.type.CSEnum;
import com.flotting.domain.type.MatchingProcessEnum;
import com.flotting.domain.type.ProcessStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 매칭 이력 관리 테이블
 */
@Entity
@Table(name = "matching_history",
    indexes = {@Index(name = "receiverIndex", columnList = "receiver"),
                @Index(name = "requesterIndex", columnList = "requester"),
                @Index(name = "matchingIndex", columnList = "matchingProcess")})
public class MatchingHistory {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 요청 일자
     */
    private LocalDateTime requestedAt;

    /**
     * 승낙 일자
     */
    private LocalDateTime receivedAt;

    /**
     * 요청자
     */
    @ManyToOne
    @JoinColumn(name = "requester")
    private UserSimpleProfile requester;

    /**
     * 승낙자
     */
    @ManyToOne
    @JoinColumn(name = "receiver")
    private UserSimpleProfile receiver;

    /**
     * 매칭 상태
     */
    private MatchingProcessEnum matchingProcess;
}
