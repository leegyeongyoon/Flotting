package com.flotting.api.user.model;

import com.flotting.api.user.enums.*;
import com.flotting.api.util.ExcelDownloadable;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserResponseDto implements ExcelDownloadable {

    @Schema(description = "simpleProfileId")
    private Long userNo;

    @Schema(description = "이름")
    private String name;

    @Schema(description = "나이")
    private Integer age;

    @Schema(description = "전화번호")
    private String phoneNumber;

    @Schema(description = "계정상태")
    private String userStatus;

    @Schema(description = "직업", allowableValues = {"PROFESSIONAL", "MID_MAJOR_COMPANY", "FINANCE", "PUBLIC_COMPANY",
            "EDU", "LAB", "MEDICAL", "BUSNINESS","SMALL_COMPANY", "FREELANCER", "STUDENT",
    })
    private String job;

    @Schema(description = "신장")
    private Integer height;

    @Schema(description = "성별", allowableValues={"F", "M"})
    private String gender;

    @Schema(description = "거주지", allowableValues = {"SEOUL_NORTH", "SEOUL_SOUTH", "SEOUL_WEST", "SEOUL_EAST",
            "GGYEONGGI_NORTH", "GGYEONGGI_SOUTH", "GGYEONGGI_WEST", "GGYEONGGI_EAST"
    })
    private String location;

    @Schema(description = "이메일")
    private String email;

    @Schema(description = "신청 경로", allowableValues = {"SMALL_CLASS_C", "SMALL_CLASS_M", "FRIP", "MOONTO", "INSTA", "RECOMMEND", "NAVER", "ETC", "PORTAL"})
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

    @Schema(description = "졸업 이력", allowableValues = {"HIGH_SCHOOL_GRADUATION", "JUNIOR_COLLEGE_ATTENDING", "JUNIOR_COLLEGE_GRADUATION", "COLLEGE_ATTENDING", "COLLEGE_GRADUATION", "COLLEGE_ACADEMY_ATTENDING", "COLLEGE_ACADEMY_GRADUATION"})
    private String education;

    @Schema(description = "흡연 여부")
    private Boolean smoking;

    @Schema(description = "음주 빈도", allowableValues = {"THREE_WEEK", "TWO_WEEK", "ONE_WEEK", "ZERO_WEEK"})
    private String drinking;

    @Schema(description = "등급", allowableValues = {"G", "D", "P"})
    private String grade;

    @Schema(description = "2차 프로필 id")
    private Long detailProfileId;

    public UserResponseDto(UserSimpleResponseDto simpleInfo, UserDetailResponseDto detailInfo) {
        this.userNo = simpleInfo.getUserNo();
        this.age = simpleInfo.getAge();
        this.job= simpleInfo.getJob();
        this.userStatus = simpleInfo.getUserStatus();
        this.phoneNumber = simpleInfo.getPhoneNumber();
        this.name = simpleInfo.getName();;
        this.appliedPath = detailInfo.getAppliedPath();
        this.body = detailInfo.getBody();
        this.detailJob = detailInfo.getDetailJob();
        this.charm = detailInfo.getCharm();
        this.drinking = detailInfo.getDrinking();
        this.education = detailInfo.getEducation();
        this.email = detailInfo.getEmail();
        this.grade = detailInfo.getGrade();;
        this.height = detailInfo.getHeight();
        this.hobby = detailInfo.getHobby();
        this.location = detailInfo.getLocation();
        this.loveValues = detailInfo.getLoveValues();
        this.nickName = detailInfo.getNickName();;
        this.preference = detailInfo.getPreference();;
        this.preferenceDetail = detailInfo.getPreferenceDetail();
        this.gender = detailInfo.getGender();
        this.smoking = detailInfo.getSmoking();
        this.recommendUserName = detailInfo.getRecommendUserName();
        this.detailProfileId = detailInfo.getSeq();
    }

    @QueryProjection
    public UserResponseDto(Long userNo, Integer age, JobEnum job, UserStatusEnum userStatus, String phoneNumber,
                           String name, AppliedPathEnum appliedPath, BodyEnum body, String detailJob, String charm,
                           DrinkingEnum drinking, EducationEnum education, String email, GradeEnum grade,
                           Integer height, String hobby, LocationEnum location,
                           String loveValues, String nickName, PreferenceEnum preference, String preferenceDetail,
                           GenderEnum gender, Boolean smoking, String recommendUserName, Long detailProfileId) {
        this.userNo = userNo;
        this.age = age;
        this.job= job.name();;
        this.userStatus = userStatus.name();
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.appliedPath = appliedPath.name();;
        this.body = body.name();
        this.detailJob = detailJob;
        this.charm = charm;
        this.drinking = drinking.name();
        this.education = education.name();
        this.email = email;
        this.grade = grade.name();
        this.height = height;
        this.hobby = hobby;
        this.location = location.name();;
        this.loveValues = loveValues;
        this.nickName = nickName;
        this.preference = preference.name();;
        this.preferenceDetail = preferenceDetail;
        this.gender = gender.name();;
        this.smoking = smoking;
        this.recommendUserName = recommendUserName;
        this.detailProfileId = detailProfileId;
    }


    @Override
    public String[] getHeaders() {
        String[] headers = {"이름", "나이", "전화번호", "계정상태", "직업", "신장", "성별", "거주지", "이메일", "신청 경로", "추천인 이름",
                "선호도1위", "선호 구체적 설명", "나의 매력", "나의 연애관", "취미", "닉네임", "체형", "직장명", "졸업 이력", "흡연 여부", "음주 빈도", "등급"};
        return headers;
    }

    @Override
    public String[] getCellDatas() {
        String[] cellDatas = {
                this.name, String.valueOf(this.age), this.phoneNumber, this.userStatus, this.job, String.valueOf(this.height), this.gender, this.location,
                this.email, this.appliedPath, this.recommendUserName, this.getPreference(), this.preferenceDetail, this.charm, this.loveValues, this.hobby,
                this.nickName, this.body, this.detailJob, this.education, String.valueOf(this.smoking), this.drinking, this.grade
        };
        return cellDatas;
    }
}
