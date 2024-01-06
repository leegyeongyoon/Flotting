package com.flotting.api.user.model;

import com.flotting.api.manager.model.ManagerProfileDto;
import com.flotting.domain.UserDetailProfile;
import com.flotting.domain.UserSimpleProfile;
import com.flotting.domain.type.LocationEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "2차 프로필 사용자 정보")
public class UserDetailResponseDto {

    @Schema(description = "신장")
    private Integer height;

    @Schema(description = "성별")
    private String gender;

    @Schema(description = "거주지", allowableValues = {"SEOUL_NORTH", "SEOUL_SOUTH", "SEOUL_WEST", "SEOUL_EAST",
            "GGYEONGGI_NORTH", "GGYEONGGI_SOUTH", "GGYEONGGI_WEST", "GGYEONGGI_EAST"
    })
    private String location;

    @Schema(description = "이메일")
    private String email;

    @Schema(description = "신청 경로", allowableValues = {"A", "B", "C", "D", "E", "F", "G", "H", "I"})
    private String appliedPath;

    @Schema(description = "추천인 이름")
    private String recommendUserName;

    @Schema(description = "선호도1위", allowableValues = {"JOB", "DISTANCE", "AGE", "HEIGHT"})
    private String preference;

    @Schema(description = "선호 구체적 설명")
    private String preferenceDetail;

    @Schema(description = "나의 매력")
    private String charm;

    @Schema(description = "나의 연애관")
    private String loveValues;

    @Schema(description = "취미")
    private String hobby;

    @Schema(description = "닉네임")
    private String nickName;

    @Schema(description = "체형**추후에 단순 문자로 바꿀 필요성(NORMAL -> A) 있음.",
            allowableValues = {"NORMAL", "SLIM", "VOLUME", "SOLID","CHUBBY", "RELIABLE", "MUSCULAR"})
    private String body;

    @Schema(description = "직장명")
    private String detailJob;

    @Schema(description = "졸업 이력", allowableValues = {"A", "B", "C", "D", "E", "F", "G"})
    private String education;

    @Schema(description = "흡연 여부")
    private Boolean smoking;

    @Schema(description = "음주 빈도", allowableValues = {"A", "B", "C", "D"})
    private String drinking;

    @Schema(description =  "신원 검증 image uri")
    private String identityVerificationURI;

    @Schema(description = "등급", allowableValues = {"G", "D", "P"})
    private String grade;

    @Schema(description = "프로필 승인한 매니저")
    private ManagerProfileDto manager;

    public UserDetailResponseDto(UserDetailProfile user) {
        this.appliedPath = user.getAppliedPath().name();
        this.body = user.getBody().name();
        this.detailJob = user.getDetailJob();
        this.charm = user.getCharm();
        this.drinking = user.getDrinking().name();
        this.education = user.getEducation().name();
        this.email = user.getEmail();
        this.grade = user.getGrade().name();
        this.height = user.getHeight();
        this.hobby = user.getHobby();
        this.identityVerificationURI = user.getIdentityVerificationURI();
        this.location = user.getLocation().name();
        this.loveValues = user.getLoveValues();
        this.nickName = user.getNickName();
        this.preference = user.getPreference().name();
        this.preferenceDetail = user.getPreferenceDetail();
        this.gender = user.getGender().name();
        this.smoking = user.getSmoking();
        this.recommendUserName = user.getRecommendUserName();
        this.manager = new ManagerProfileDto(user.getManager());
    }

}
