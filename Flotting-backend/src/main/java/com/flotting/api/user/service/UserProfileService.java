package com.flotting.api.user.service;

import com.flotting.api.user.model.UserProfileEntity;
import com.flotting.api.user.model.UserLoginRequestVo;
import com.flotting.api.user.model.UserSigninRequestVo;
import com.flotting.api.user.repository.UserProfileRepository;
import com.flotting.common.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public String userLogin(UserLoginRequestVo userLoginRequestVo) {
        Optional<UserProfileEntity> userProfileEntity = userProfileRepository.findByUserNoAndEmail(userLoginRequestVo.getUserNo(), userLoginRequestVo.getEmail());
        if (userProfileEntity.isPresent()) {
            return jwtTokenProvider.createToken(userProfileEntity.get().getEmail(), List.of("ROLE_USER"));
        }
        return "인증 실패";
    }

    public UserProfileEntity singin(UserSigninRequestVo userSigninRequestVo) {
        UserProfileEntity userProfileEntity = UserProfileEntity.signUserBuilder(userSigninRequestVo);
        return userProfileRepository.save(userProfileEntity);
    }
}
