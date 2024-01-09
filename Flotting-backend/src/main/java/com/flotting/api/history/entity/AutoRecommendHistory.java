package com.flotting.api.history.entity;

import com.flotting.api.user.entity.UserSimpleProfile;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * 자동 추천 이력 테이블
 */
@Entity
@Table(name = "auto_recommend_history",
        indexes = @Index(name = "receiverIndex", columnList = "receiver"))
public class AutoRecommendHistory {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    /**
     * 자동 추천 일자
     */
    private LocalDate createdAt;

    /**
     * 추천 프로필 수신자
     */
    @ManyToOne
    @JoinColumn(name = "receiver")
    private UserSimpleProfile receiver;

    /**
     * 추천 프로필
     */
    @ManyToOne
    @JoinColumn(name = "recommend_profile")
    private UserSimpleProfile profile;
}
