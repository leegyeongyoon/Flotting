package com.flotting.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Getter
public class BaseEntity {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long seq;

    /**
     * 생성일
     */
    private LocalDateTime createdAt;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }
}
