package com.flotting.api.user.model;

import com.flotting.domain.ManagerProfile;
import com.flotting.domain.UserSimpleProfile;
import com.flotting.domain.type.*;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
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

    @Builder
    public UserDetailRequestDto(String path, String body, String detailJob, String charm,
                                String drinking, String education, String email, String grade,
                                Integer height, String hobby, String URI, String location,
                                String loveValues, String nickName, String preference, String preferenceDetail,
                                String gender, Boolean smoking, String recommendUserName) {
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
    }
}
