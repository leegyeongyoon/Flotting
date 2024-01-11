package com.flotting.api.payment.entity;

import com.flotting.api.matching.entity.MatchingHistoryEntity;
import com.flotting.api.user.entity.UserSimpleEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * 결제 이력 테이블
 */
@Entity
@Table(name = "payment_history")
public class PaymentHistoryEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 결제일
     */
    private LocalDateTime paid_at;

    /**
     * 결제자
     */
    @ManyToOne
    @JoinColumn(name = "payer")
    private UserSimpleEntity payer;

    /**
     * 결제 매칭 id
     */
    @OneToOne
    @JoinColumn(name = "paid_matching_id")
    private MatchingHistoryEntity matchingHistoryEntity;


}
