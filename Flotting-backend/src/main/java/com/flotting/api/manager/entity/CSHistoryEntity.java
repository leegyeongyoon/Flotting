package com.flotting.api.manager.entity;

import com.flotting.api.user.entity.UserSimpleEntity;
import com.flotting.api.manager.enums.CSEnum;
import com.flotting.api.user.enums.ProcessStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * cs 이력 관리 테이블
 */
@Entity
@Table(name = "cs_history",
        indexes = @Index(name = "statusIndex", columnList = "status"))
public class CSHistoryEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 접수일
     */
    private LocalDate requestDate;

    /**
     * 처리 매니저
     */
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private ManagerProfileEntity manager;

    /**
     * 신청자
     */
    @ManyToOne
    @JoinColumn(name = "requester_id")
    private UserSimpleEntity requester;

    /**
     * 처리현황
     */
    private ProcessStatus status;

    /**
     * 처리내역
     */
    private String content;

    /**
     * 상담 유형
     */
    private CSEnum csType;
}