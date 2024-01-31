package com.flotting.api.user.service;

import com.flotting.api.user.entity.UserDetailEntity;
import com.flotting.api.user.entity.UserSimpleEntity;
import com.flotting.api.user.model.*;
import com.flotting.api.user.repository.UserDetailRepository;
import com.flotting.api.user.repository.UserSimpleRepository;
import com.flotting.api.user.enums.GradeEnum;
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
    public List<UserDetailResponseDto> getDetailUserInfosByGrade(String grade) {
        return userDetailRepository.findUsersByGrade(GradeEnum.of(grade));
    }

    /**
     * 모든 user목록 1차프로필 조회
     */
    @Transactional(readOnly = true)
    public List<UserSimpleResponseDto> getSimpleUserInfos() {
        return userSimpleRepository.findAllSimpleUserInfos();
    }

    /**
     * 모든 user목록 2차프로필 조회
     */
    @Transactional(readOnly = true)
    public List<UserDetailResponseDto> getDetailUserInfos() {
        return userDetailRepository.findAll()
                .stream().map(UserDetailResponseDto::new)
                .collect(Collectors.toList());
    }

    /**
     * 필터에 해당하는 user목록 2차프로필 조회
     */
    @Transactional(readOnly = true)
    public List<UserResponseDto> getUsersByFilter(UserFilterRequestDto filter) {
        return userDetailRepository.findUsersByFilter(filter);
    }

    /**
     * user 1차 프로필 저장
     */
    @Transactional
    public UserSimpleResponseDto saveSimpleUserInfo(UserSimpleRequestDto requestDto) {
        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        UserSimpleEntity user = new UserSimpleEntity(requestDto, encodedPassword);
        UserSimpleEntity savedUser = userSimpleRepository.save(user);
        log.info("savedEntity user : {}", savedUser);
        return new UserSimpleResponseDto(savedUser);
    }

    /**
     * 1차 프로필 수정
     */
    @Transactional
    public UserSimpleResponseDto updateSimpleUserInfo(Long targetUserId, UserSimpleRequestDto requestDto) {
        UserSimpleEntity simpleUser = getSimpleUser(targetUserId);

        UserSimpleEntity updatedProfile = simpleUser.updateInfo(requestDto);
        return new UserSimpleResponseDto(updatedProfile);
    }

    /**
     * user 2차 프로필 저장
     */
    @Transactional
    public UserDetailResponseDto saveDetailUserInfo(Long targetUserId, UserDetailRequestDto requestDto) {
        UserDetailEntity userDetailEntity = new UserDetailEntity(requestDto);
        UserSimpleEntity simpleUser = getSimpleUser(targetUserId);

        simpleUser.setDetailUser(userDetailEntity);
        UserDetailEntity savedUser = userDetailRepository.save(userDetailEntity);

        log.info("savedEntity user : {}", savedUser);
        return new UserDetailResponseDto(savedUser);
    }

    /**
     * 2차 프로필 수정
     */
    @Transactional
    public UserDetailResponseDto updateDetailUserInfo(Long targetUserId, UserDetailRequestDto requestDto) {
        UserDetailEntity detailUser = getDetailUser(targetUserId);

        UserDetailEntity updatedProfile = detailUser.updateInfo(requestDto);
        return new UserDetailResponseDto(updatedProfile);
    }

    /**
     * 1차 프로필 조회
     */
    @Transactional(readOnly = true)
    public UserSimpleEntity getSimpleUser(Long profileId) {
        return userSimpleRepository.findById(profileId)
                .orElseThrow(() -> new IllegalArgumentException("1차 프로필 미등록 사용자!! profileId : " + profileId));
    }

    /**
     * 2차 프로필 조회
     */
    @Transactional(readOnly = true)
    public UserDetailEntity getDetailUser(Long profileId) {
        return userDetailRepository.findById(profileId)
                .orElseThrow(() -> new IllegalArgumentException("2차 프로필 미등록 사용자!! profileId : " + profileId));
    }

    /**
     * 1차 프로필 Dto 조회
     */
    @Transactional(readOnly = true)
    public UserSimpleResponseDto getSimpleUserDto(Long profileId) {
        UserSimpleEntity userSimpleEntity = getSimpleUser(profileId);
        return new UserSimpleResponseDto(userSimpleEntity);
    }

    /**
     * 2차 프로필 Dto 조회
     */
    @Transactional(readOnly = true)
    public UserDetailResponseDto getDetailUserDto(Long profileId) {
        UserDetailEntity userDetail = getDetailUser(profileId);
        return new UserDetailResponseDto(userDetail);
    }


}
