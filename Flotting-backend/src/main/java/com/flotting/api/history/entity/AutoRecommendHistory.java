package com.flotting.api.history.entity;

import com.flotting.api.user.entity.UserDetailEntity;
import com.flotting.api.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 자동 추천 이력 테이블
 */
@Entity
@Table(name = "auto_recommend_history",
        indexes = @Index(name = "receiverIndex", columnList = "receiver"))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AutoRecommendHistory extends BaseEntity {

    /**
     * 추천 프로필 수신자
     */
    @ManyToOne
    @JoinColumn(name = "receiver")
    private UserDetailEntity receiver;

    /**
     * 추천 프로필
     */
    @ManyToOne
    @JoinColumn(name = "recommend_profile")
    private UserDetailEntity profile;

    @Builder
    public AutoRecommendHistory(UserDetailEntity receiver, UserDetailEntity profile) {
        this.receiver = receiver;
        this.profile = profile;
    }
}
