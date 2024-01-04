package com.flotting.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * 결제 이력 테이블
 */
@Entity
@Table(name = "payment_history")
public class PaymentHistory {

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
    private UserSimpleProfile payer;

    /**
     * 결제 매칭 id
     */
    @OneToOne
    @JoinColumn(name = "paid_matching_id")
    private MatchingHistory matchingHistory;


}
