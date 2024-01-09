package com.flotting.api.history.entity;

import com.flotting.api.manager.entity.ManagerProfile;
import com.flotting.api.user.entity.UserSimpleProfile;
import com.flotting.api.util.type.CSEnum;
import com.flotting.api.util.type.ProcessStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * cs 이력 관리 테이블
 */
@Entity
@Table(name = "cs_history",
        indexes = @Index(name = "statusIndex", columnList = "status"))
public class CSHistory {

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
    private ManagerProfile manager;

    /**
     * 신청자
     */
    @ManyToOne
    @JoinColumn(name = "requester_id")
    private UserSimpleProfile requester;

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
