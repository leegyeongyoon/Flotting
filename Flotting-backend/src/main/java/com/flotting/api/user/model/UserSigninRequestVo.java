package com.flotting.api.user.model;

import lombok.Getter;

@Getter
public class UserSigninRequestVo {
    private String userName;
    private Long phoneNumber;
    private String email;
}
