package com.flotting.api.user.service;

import com.flotting.api.user.model.UserProfileEntity;
import com.flotting.api.user.model.UserRequestVo;
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

    public String userLogin(UserRequestVo userRequestVo) {
        Optional<UserProfileEntity> userProfileEntity = userProfileRepository.findByUserNoAndEmail(userRequestVo.getUserNo(), userRequestVo.getEmail());
        if (userProfileEntity.isPresent()) {
            return jwtTokenProvider.createToken(userProfileEntity.get().getEmail(), List.of("ROLE_USER"));
        }
        return "인증 실패";
    }
}
