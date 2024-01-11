package com.flotting.api.matching.entity;

import com.flotting.api.user.entity.UserSimpleEntity;
import com.flotting.api.matching.enums.MatchingProcessEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * 매칭 이력 관리 테이블
 */
@Entity
@Table(name = "matching_history",
    indexes = {@Index(name = "receiverIndexs", columnList = "receiver"),
                @Index(name = "requesterIndex", columnList = "requester"),
                @Index(name = "matchingIndex", columnList = "matchingProcess")})
public class MatchingHistoryEntity {

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
    private UserSimpleEntity requester;

    /**
     * 승낙자
     */
    @ManyToOne
    @JoinColumn(name = "receiver")
    private UserSimpleEntity receiver;

    /**
     * 매칭 상태
     */
    private MatchingProcessEnum matchingProcess;
}
