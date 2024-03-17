package com.flotting.api.user.entity;

import com.flotting.api.manager.entity.ManagerProfileEntity;
import com.flotting.api.user.enums.*;
import com.flotting.api.user.model.UserDetailRequestDto;
import com.flotting.api.util.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 2차 프로필 테이블
 */
@Entity
@Table(name = "user_detail_profile",
        indexes = @Index(name = "gradeIndex", columnList = "grade"))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserDetailEntity extends BaseEntity {


    /**
     * 신장
     */
    private Integer height;

    /**
     * 성별
     */
    @Enumerated(value = EnumType.STRING)
    private GenderEnum gender;

    /**
     * 주소
     */
    @Enumerated(value = EnumType.STRING)
    private LocationEnum location;

    /**
     * 이메일
     */
    @Column(unique = true)
    private String email;

    /**
     * 신청경로
     */
    @Enumerated(value = EnumType.STRING)
    private AppliedPathEnum appliedPath;

    /**
     * 추천인
     */
    private String recommendUserName;

    /**
     * 취향1가지 key
     */
    @Enumerated(value = EnumType.STRING)
    private PreferenceEnum preference;
    /**
     * 취향 1가지 value
     */
    @ElementCollection
    private List<String> preferenceValue;

    /**
     * 가장중요한 조건
     */
    private String preferenceDetail;

    /**
     * 나의 매력
     */
    private String charm;

    /**
     * 나의 연애관
     */
    private String loveValues;

    /**
     * 나의 취미
     */
    private String hobby;

    /**
     * 닉네임
     */
    private String nickName;

    /**
     * 체형
     */
    @Enumerated(value = EnumType.STRING)
    private BodyEnum body;

    /**
     * 상세 직업
     */
    private String detailJob;

    /**
     * 학력
     */
    @Enumerated(value = EnumType.STRING)
    private EducationEnum education;

    /**
     * 흡연 여부
     */
    private Boolean smoking;

    /**
     * 음주
     */
    @Enumerated(value = EnumType.STRING)
    private DrinkingEnum drinking;

    /**
     * 프로필등록 image uri(1~3장)
     * , 로 구
     */
    @Column(length = 1000)
    private String profileImageURIs;

    /**
     * 신원 검증 image uri(1~2장)분
     * , 로 구분
     */
    @Column(length = 1000)
    private String identityVerificationURI;

    /**
     * 프로필 등급
     */
    @Enumerated(value = EnumType.STRING)
    private GradeEnum grade;

    /**
     * 프로필 승인 매니저
     */
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private ManagerProfileEntity manager;

    /**
     * 승인여부
     */
    private Boolean isApproved;

    /**
     * 등급 점수
     */
    private Integer totalScore;

    /**
     * 외모 점수
     */
    private Integer faceScore;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "userDetailEntity", cascade = CascadeType.ALL)
    private UserSimpleEntity userSimpleEntity;

    private String rejectedReason;

    @Builder
    public UserDetailEntity(UserDetailRequestDto requestDto) {
        this.appliedPath = AppliedPathEnum.of(requestDto.getAppliedPath());
        this.body = BodyEnum.of(requestDto.getBody());
        this.detailJob = requestDto.getDetailJob();
        this.charm = requestDto.getCharm();
        this.drinking = DrinkingEnum.of(requestDto.getDrinking());
        this.education = EducationEnum.of(requestDto.getEducation());
        this.email = requestDto.getEmail();
        this.grade = GradeEnum.of(requestDto.getGrade());
        this.height = requestDto.getHeight();
        this.hobby = requestDto.getHobby();
        this.identityVerificationURI = requestDto.getIdentityVerificationURI();
        this.location = LocationEnum.of(requestDto.getLocation());
        this.loveValues = requestDto.getLoveValues();
        this.nickName = requestDto.getNickName();
        this.preference = PreferenceEnum.of(requestDto.getPreference());
        this.preferenceDetail = requestDto.getPreferenceDetail();
        this.gender = GenderEnum.of(requestDto.getGender());
        this.smoking = requestDto.getSmoking();
        this.recommendUserName = requestDto.getRecommendUserName();
    }

    public UserDetailEntity updateInfo(UserDetailRequestDto requestDto) {
        this.appliedPath = AppliedPathEnum.of(requestDto.getAppliedPath());
        this.body = BodyEnum.of(requestDto.getBody());
        this.detailJob = requestDto.getDetailJob();
        this.charm = requestDto.getCharm();
        this.drinking = DrinkingEnum.of(requestDto.getDrinking());
        this.education = EducationEnum.of(requestDto.getEducation());
        this.email = requestDto.getEmail();
        this.grade = GradeEnum.of(requestDto.getGrade());
        this.height = requestDto.getHeight();
        this.hobby = requestDto.getHobby();
        this.identityVerificationURI = requestDto.getIdentityVerificationURI();
        this.location = LocationEnum.of(requestDto.getLocation());
        this.loveValues = requestDto.getLoveValues();
        this.nickName = requestDto.getNickName();
        this.preference = PreferenceEnum.of(requestDto.getPreference());
        this.preferenceDetail = requestDto.getPreferenceDetail();
        this.gender = GenderEnum.of(requestDto.getGender());
        this.smoking = requestDto.getSmoking();
        this.recommendUserName = requestDto.getRecommendUserName();
        return this;
    }

    public UserDetailEntity approveProfile(ManagerProfileEntity manager) {
        this.isApproved = true;
        this.manager = manager;
        return this;
    }

    public UserDetailEntity rejectProfile(ManagerProfileEntity manager, String reason) {
        this.isApproved = false;
        this.rejectedReason = reason;
        this.manager = manager;
        return this;
    }

    public void setTotalScore(int score) {

        this.totalScore = score;
    }

    public void setSimpleUser(UserSimpleEntity simpleUser) {
        this.userSimpleEntity = simpleUser;
    }

    public int getHeightScore(GenderEnum gender) {
        if(GenderEnum.M.equals(gender)) {
            if(this.height >= 175) {
                return 12;
            } else if (this.height >= 170) {
                return 8;
            } else if (this.height >= 165) {
                return 4;
            } else {
                return 0;
            }
        } else {
            if(this.height >= 175) {
                return 0;
            } else if (this.height >= 170) {
                return 2;
            } else if (this.height >= 160) {
                return 6;
            } else if (this.height >= 150) {
                return 4;
            } else {
                return 0;
            }
        }
    }

}
