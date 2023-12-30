package com.flotting.api.user.model;

import com.flotting.domain.UserSimpleProfile;
import com.flotting.domain.type.JobEnum;
import com.flotting.domain.type.UserStatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserSimpleRequestDto {

    private String name;

    private Integer age;

    private String phoneNumber;

    private String job;

    @Builder
    public UserSimpleRequestDto (String name, Integer age, String phoneNumber, String job) {
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.job = job;
        this.name = name;
    }
}
