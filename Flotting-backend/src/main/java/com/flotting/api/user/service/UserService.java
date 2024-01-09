package com.flotting.api.user.service;

import com.flotting.api.user.model.*;
import com.flotting.api.user.repository.UserDetailRepository;
import com.flotting.api.user.repository.UserSimpleRepository;
import com.flotting.config.TokenUser;
import com.flotting.api.user.entity.UserDetailProfile;
import com.flotting.api.user.entity.UserSimpleProfile;
import com.flotting.api.util.type.GradeEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserSimpleRepository userSimpleRepository;
    private final UserDetailRepository userDetailRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * user등급별 조회
     */
    @Transactional(readOnly = true)
    public List<UserDetailResponseDto> getDetailUserInfosByGrade(TokenUser tokenUser, String grade) {
        return userDetailRepository.findUsersByGrade(GradeEnum.of(grade));
    }

    /**
     * 모든 user목록 1차프로필 조회
     */
    @Transactional(readOnly = true)
    public List<UserSimpleResponseDto> getSimpleUserInfos(TokenUser tokenUser) {
        return userSimpleRepository.findAllSimpleUserInfos();
    }

    /**
     * 모든 user목록 2차프로필 조회
     */
    @Transactional(readOnly = true)
    public List<UserDetailResponseDto> getDetailUserInfos(TokenUser tokenUser) {
        return userDetailRepository.findAll()
                .stream().map(UserDetailResponseDto::new)
                .collect(Collectors.toList());
    }

    /**
     * 필터에 해당하는 user목록 2차프로필 조회
     */
    @Transactional(readOnly = true)
    public List<UserResponseDto> getUsersByFilter(TokenUser tokenUser, UserFilterRequestDto filter) {
        return userDetailRepository.findUsersByFilter(filter);
    }

    /**
     * user 1차 프로필 저장
     */
    @Transactional
    public UserSimpleResponseDto saveSimpleUserInfo(TokenUser tokenUser, UserSimpleRequestDto requestDto) {
        UserSimpleProfile user = new UserSimpleProfile(requestDto);
        UserSimpleProfile savedUser = userSimpleRepository.save(user);
        log.info("savedEntity user : {}", savedUser);
        UserSimpleResponseDto userSimpleResponseDto = new UserSimpleResponseDto(savedUser);
        return userSimpleResponseDto;
    }

    /**
     * 1차 프로필 수정
     */
    @Transactional
    public UserSimpleResponseDto updateSimpleUserInfo(TokenUser tokenUser, Long targetUserId, UserSimpleRequestDto requestDto) {
        UserSimpleProfile simpleUser = getSimpleUser(targetUserId);

        UserSimpleProfile updatedProfile = simpleUser.updateInfo(requestDto);
        UserSimpleResponseDto userSimpleResponseDto = new UserSimpleResponseDto(updatedProfile);
        return userSimpleResponseDto;
    }

    /**
     * user 2차 프로필 저장
     */
    @Transactional
    public UserDetailResponseDto saveDetailUserInfo(TokenUser tokenUser, Long targetUserId, UserDetailRequestDto requestDto) {
        UserDetailProfile userDetailProfile = new UserDetailProfile(requestDto);
        UserSimpleProfile simpleUser = getSimpleUser(targetUserId);

        simpleUser.setDetailUser(userDetailProfile);
        UserDetailProfile savedUser = userDetailRepository.save(userDetailProfile);

        log.info("savedEntity user : {}", savedUser);
        return new UserDetailResponseDto(savedUser);
    }

    /**
     * 2차 프로필 수정
     */
    @Transactional
    public UserDetailResponseDto updateDetailUserInfo(TokenUser tokenUser, Long targetUserId, UserDetailRequestDto requestDto) {
        UserDetailProfile detailUser = getDetailUser(targetUserId);

        UserDetailProfile updatedProfile = detailUser.updateInfo(requestDto);
        UserDetailResponseDto userDetailResponseDto = new UserDetailResponseDto(updatedProfile);
        return userDetailResponseDto;
    }

    /**
     * 1차 프로필 조회
     */
    @Transactional(readOnly = true)
    public UserSimpleProfile getSimpleUser(Long profileId) {
        UserSimpleProfile userSimpleProfile = userSimpleRepository.findById(profileId)
                .orElseThrow(() -> new IllegalArgumentException("1차 프로필 미등록 사용자!! profileId : " + profileId));
        return userSimpleProfile;
    }

    /**
     * 2차 프로필 조회
     */
    @Transactional(readOnly = true)
    public UserDetailProfile getDetailUser(Long profileId) {
        UserDetailProfile userDetailProfile = userDetailRepository.findById(profileId)
                .orElseThrow(() -> new IllegalArgumentException("2차 프로필 미등록 사용자!! profileId : " + profileId));
        return userDetailProfile;
    }

    /**
     * 1차 프로필 Dto 조회
     */
    @Transactional(readOnly = true)
    public UserSimpleResponseDto getSimpleUserDto(Long profileId) {
        UserSimpleProfile userSimpleProfile = getSimpleUser(profileId);
        return new UserSimpleResponseDto(userSimpleProfile);
    }

    /**
     * 2차 프로필 Dto 조회
     */
    @Transactional(readOnly = true)
    public UserDetailResponseDto getDetailUserDto(Long profileId) {
        UserDetailProfile userDetail = getDetailUser(profileId);
        return new UserDetailResponseDto(userDetail);
    }


}
