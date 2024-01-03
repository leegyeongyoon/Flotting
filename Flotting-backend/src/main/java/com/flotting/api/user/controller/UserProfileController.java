package com.flotting.api.user.controller;

import com.flotting.api.user.model.UserRequestVo;
import com.flotting.api.user.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserProfileController {
    private final UserProfileService userProfileService;

    @CrossOrigin("*")
    @PostMapping("/user/login")
    private String login(@RequestBody UserRequestVo userRequestVo) {
        return userProfileService.userLogin(userRequestVo);
    }
}
