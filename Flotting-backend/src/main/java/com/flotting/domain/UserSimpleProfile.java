package com.flotting.domain;

import com.flotting.api.user.model.UserSimpleRequestDto;
import com.flotting.api.user.model.UserSimpleResponseDto;
import com.flotting.domain.type.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 1차 프로필 테이블
 */
@Entity
@Table(name = "user_simple_profile")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserSimpleProfile extends BaseEntity implements UserDetails {

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

    public UserSimpleProfile(UserSimpleRequestDto requestDto , String encodedPassword) {

        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.password = encodedPassword;
        this.phoneNumber = requestDto.getPhoneNumber();
        this.job = JobEnum.of(requestDto.getJob());
        this.userStatus = UserStatusEnum.DORMANT;
    }
    public static UserSimpleResponseDto toResponseDto(UserSimpleProfile userSimpleProfile) {
        return UserSimpleResponseDto.builder()
                .id(userSimpleProfile.getSeq())
                .name(userSimpleProfile.getName())
                .phoneNumber(userSimpleProfile.getPhoneNumber())
                .job(userSimpleProfile.getJob().name())
                .build();
    }

    public void setDetailUser(UserDetailProfile detailProfile) {
        this.userDetailProfile = detailProfile;
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
}
