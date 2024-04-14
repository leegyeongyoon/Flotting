package com.flotting.api.user.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailRequestDto {

    private Integer height;

    private String gender;

    private String location;

    private String email;

    private String appliedPath;

    private String recommendUserName;

    private String preference;

    private String preferenceDetail;

    private String charm;

    private String loveValues;

    private String hobby;

    private String nickName;

    private String body;

    private String detailJob;

    private String education;

    private Boolean smoking;

    private String drinking;

    private String identityVerificationURI;

    private String grade;

    private Long managerId;

    private Integer totalScore;

    private Integer faceScore;

    private List<String> preferenceValue;

    private LocalDate approvedAt;

    @Builder
    public UserDetailRequestDto(String path, String body, String detailJob, String charm,
                                String drinking, String education, String email, String grade,
                                Integer height, String hobby, String URI, String location,
                                String loveValues, String nickName, String preference, String preferenceDetail,
                                String gender, Boolean smoking, String recommendUserName,
                                List<String> preferenceValue, Integer totalScore, Integer faceScore, LocalDate approvedAt) {
        this.appliedPath = path;
        this.body = body;
        this.detailJob = detailJob;
        this.charm = charm;
        this.drinking = drinking;
        this.education =  education;
        this.email = email;
        this.grade = grade;
        this.height = height;
        this.hobby = hobby;
        this.identityVerificationURI = URI;
        this.location = location;
        this.loveValues = loveValues;
        this.nickName = nickName;
        this.preference = preference;
        this.preferenceDetail = preferenceDetail;
        this.gender = gender;
        this.smoking = smoking;
        this.recommendUserName = recommendUserName;
        this.preferenceValue = preferenceValue;
        this.totalScore = totalScore;
        this.faceScore = faceScore;
        this.approvedAt = approvedAt;
    }
}
