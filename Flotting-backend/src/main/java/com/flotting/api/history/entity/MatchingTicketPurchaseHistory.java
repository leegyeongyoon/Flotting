package com.flotting.api.history.entity;


import com.flotting.api.user.entity.UserSimpleEntity;
import com.flotting.api.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class MatchingTicketPurchaseHistory extends BaseEntity {

    /**
     * 구매자 id
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserSimpleEntity userSimpleEntity;

    /**
     * 사용일자
     */
    private LocalDateTime usedAt;

    /**
     * 매칭 이력 id
     */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "matchingTicketPurchaseHistory")
    private MatchingHistory matchingHistory;

    public void withdraw() {
        this.usedAt = null;
        this.matchingHistory = null;
    }

    @Builder
    public MatchingTicketPurchaseHistory (UserSimpleEntity userSimpleEntity, LocalDateTime usedAt) {
        this.userSimpleEntity = userSimpleEntity;
        this.usedAt = usedAt;
    }
}
