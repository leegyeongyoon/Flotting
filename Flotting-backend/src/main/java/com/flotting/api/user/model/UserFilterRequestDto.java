package com.flotting.api.user.model;

import com.flotting.api.util.type.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
public class UserFilterRequestDto {

    GenderEnum gender;
    BodyEnum body;
    Integer startHeight;
    Integer endHeight;
    UserStatusEnum status;
    LocationEnum location;
    Integer startAge;
    Integer endAge;
    GradeEnum grade;
    JobEnum job;
    Boolean smoke;

    public void setGender(String gender) {
        this.gender = GenderEnum.of(gender);
    }

    public void setBody(String body) {
        this.body = BodyEnum.of(body);
    }

    public void setStatus(String status) {
        this.status = UserStatusEnum.of(status);
    }

    public void setLocation(String location) {
        this.location = LocationEnum.of(location);
    }

    public void setGrade(String grade) {
        this.grade = GradeEnum.of(grade);
    }

    public void setJob(String job) {
        this.job = JobEnum.of(job);
    }

    public Integer getStartValue(Integer value) {
        if(Objects.isNull(value)) {
            return 0;
        }
        return value;
    }

    public Integer getEndValue(Integer value) {
        if(Objects.isNull(value)) {
            return 200;
        }
        return value;
    }
}
