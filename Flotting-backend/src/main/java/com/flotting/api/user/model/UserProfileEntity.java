package com.flotting.api.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Getter
@Table(name="USER_PROFILE")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserProfileEntity implements UserDetails {

    @Id
    @Column(name="USER_NO" , columnDefinition = "INT COMMENT '유저 번호'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(name="USER_NAME", columnDefinition = "varchar(30) COMMENT '유저 이름'")
    private String userName;

    @Column(name="USER_STATUS", columnDefinition = "varchar(30) COMMENT '유저 상태'")
    private String userStatus;

    @Column(name="PHONE_NUMBER", columnDefinition = "INT COMMENT '휴대폰 번호'")
    private Long phoneNumber;

    @Column(name="EMAIL", columnDefinition = "varchar(30) COMMENT '이메일'")
    private String email;

    @Column(name="AGE", columnDefinition = "INT COMMENT '나이'")
    private Long age;

    @Column(name="JOB", columnDefinition = "varchar(30) COMMENT '직업'")
    private String job;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.userName;
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

    public static UserProfileEntity signUserBuilder(UserSigninRequestVo userSigninRequestVo){
        return UserProfileEntity.builder()
                .userName(userSigninRequestVo.getUserName())
                .email(userSigninRequestVo.getEmail())
                .phoneNumber(userSigninRequestVo.getPhoneNumber())
                .build();
    }
}
