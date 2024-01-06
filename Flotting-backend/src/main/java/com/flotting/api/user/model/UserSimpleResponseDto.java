package com.flotting.api.user.model;

import com.flotting.domain.ManagerProfile;
import com.flotting.domain.UserDetailProfile;
import com.flotting.domain.UserSimpleProfile;
import com.flotting.domain.type.JobEnum;
import com.flotting.domain.type.UserStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class UserSimpleResponseDto {

    private Long seq;

    /**
     * 생성일
     */
    private LocalDateTime createdAt;

    /**
     * 이름
     */
    private String name;

    /**
     * 나이
     */
    private Integer age;

    /**
     * 전화번호
     */
    private String phoneNumber;

    /**
     * 계정상태
     */
    private String userStatus;

    /**
     * 공무원&공기업, 중견기업&대기업, 전문직, 사업가
     */
    private String job;

    public UserSimpleResponseDto(UserSimpleProfile user) {
        this.seq = user.getSeq();
        this.createdAt = user.getCreatedAt();
        this.age = user.getAge();
        this.job= user.getJob().name();
        this.userStatus = user.getUserStatus().name();
        this.phoneNumber = user.getPhoneNumber();
        this.name = user.getName();
    }
}
