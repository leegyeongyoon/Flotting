package com.flotting.api.user.controller;

import com.flotting.api.user.model.UserProfileEntity;
import com.flotting.api.user.model.UserLoginRequestVo;
import com.flotting.api.user.model.UserSigninRequestVo;
import com.flotting.api.user.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserProfileController {
    private final UserProfileService userProfileService;

    @CrossOrigin("*")
    @PostMapping("/login")
    private String login(@RequestBody UserLoginRequestVo userLoginRequestVo) {
        return userProfileService.userLogin(userLoginRequestVo);
    }


}
