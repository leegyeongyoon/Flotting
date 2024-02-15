package com.flotting.api.user.entity;

import com.flotting.api.user.model.UserSimpleRequestDto;
import com.flotting.api.user.enums.GenderEnum;
import com.flotting.api.user.enums.JobEnum;
import com.flotting.api.user.enums.UserStatusEnum;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * 1차 프로필 테이블
 */
@Entity
@Table(name = "user_simple_profile")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserSimpleEntity implements UserDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userNo;

    /**
     * 생성일
     */
    private LocalDateTime createdAt;

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    /**
     * 이름
     */
    private String name;

    /**
     * 패스워드(pass CI를 인코딩 한 값)
     */
    private String password;

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
    @Enumerated(value = EnumType.STRING)
    private UserStatusEnum userStatus = UserStatusEnum.NORMAL;

    /**
     * 공무원&공기업, 중견기업&대기업, 전문직, 사업가
     */
    private JobEnum job;

    /**
     * 2차 프로필 id
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_detail_entity")
    private UserDetailEntity userDetailEntity;

    public UserSimpleEntity(UserSimpleRequestDto requestDto , String encodedPassword) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.password = encodedPassword;
        this.phoneNumber = requestDto.getPhoneNumber();
        this.job = JobEnum.of(requestDto.getJob());
        this.userStatus = UserStatusEnum.DORMANT;
    }

    public void setDetailUser(UserDetailEntity detailProfile) {
        this.userDetailEntity = detailProfile;
    }

    public UserSimpleEntity updateInfo(UserSimpleRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.phoneNumber = requestDto.getPhoneNumber();
        this.job = JobEnum.of(requestDto.getJob());
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public int getAgeScore(GenderEnum gender) {
        if (GenderEnum.M.equals(gender)) {
            if (this.age >= 40) {
                return 2;
            } else {
                return 0;
            }
        } else {
            if (this.age >= 36) {
                return 0;
            } else if (this.age >= 30) {
                return 5;
            } else if (this.age >= 25) {
                return 10;
            } else if (this.age >= 20) {
                return 15;
            } else {
                return 0;
            }
        }
    }
}
