package com.flotting.domain;

import com.flotting.api.user.model.UserSimpleRequestDto;
import com.flotting.api.user.model.UserSimpleResponseDto;
import com.flotting.domain.type.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 1차 프로필 테이블
 */
@Entity
@Table(name = "user_simple_profile")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserSimpleProfile extends BaseEntity {

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
    @Column(unique = true)
    private String phoneNumber;

    /**
     * 계정상태
     */
    private UserStatusEnum userStatus;

    /**
     * 공무원&공기업, 중견기업&대기업, 전문직, 사업가
     */
    private JobEnum job;

    /**
     * 1차 프로필 id
     */
    @OneToOne
    @JoinColumn(name = "user_detail_profile")
    private UserDetailProfile userDetailProfile;

    /**
     * 프로필 승인 매니저
     */
    @OneToOne
    @JoinColumn(name = "manager_id")
    private ManagerProfile manager;

    public UserSimpleResponseDto getSimpleUserInfo() {
        return new UserSimpleResponseDto(this);
    }

    public UserSimpleProfile(UserSimpleRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.job = JobEnum.of(requestDto.getJob());
        this.userStatus = UserStatusEnum.DORMANT;
    }

    public void setDetailUser(UserDetailProfile detailProfile) {
        this.userDetailProfile = detailProfile;
    }
}
