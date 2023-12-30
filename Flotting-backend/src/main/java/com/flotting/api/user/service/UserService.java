package com.flotting.api.user.service;

import com.flotting.api.user.model.*;
import com.flotting.api.user.repository.UserDetailRepository;
import com.flotting.api.user.repository.UserSimpleRepository;
import com.flotting.domain.UserDetailProfile;
import com.flotting.domain.UserSimpleProfile;
import com.flotting.domain.type.GradeEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private  final UserSimpleRepository userSimpleRepository;
    private  final UserDetailRepository userDetailRepository;

    /**
     * user등급별 조회
     */
    @Transactional(readOnly = true)
    public List<UserDetailResponseDto> getDetailUsersByGrade(String grade) {
        return userDetailRepository.findUsersByGrade(GradeEnum.of(grade));
    }

    /**
     * 모든 user목록 1차프로필 조회
     */
    @Transactional(readOnly = true)
    public List<UserSimpleResponseDto> getSimpleUsers() {
        return userSimpleRepository.findAllSimpleUsers();
    }

    /**
     * 모든 user목록 2차프로필 조회
     */
    @Transactional(readOnly = true)
    public List<UserDetailResponseDto> getDetailUsers() {
        return userDetailRepository.findAllDetailUsers();
    }

    /**
     * 필터에 해당하는 user목록 2차프로필 조회
     */
    @Transactional(readOnly = true)
    public List<UserDetailResponseDto> getUsersByFilter(UserFilterRequestDto filter) {
        return userDetailRepository.findUsersByFilter(filter);
    }

    /**
     * user 1차 프로필 저장
     */
    @Transactional
    public UserSimpleProfile saveSimpleUserInfo(UserSimpleRequestDto requestDto) {
        UserSimpleProfile user = new UserSimpleProfile(requestDto);
        UserSimpleProfile savedUser = userSimpleRepository.save(user);
        log.info("savedEntity user : {}", savedUser);
        return savedUser;
    }

    /**
     * user 2차 프로필 저장
     */
    @Transactional
    public UserDetailProfile saveDetailUserInfo(UserDetailRequestDto requestDto) {
        UserDetailProfile userDetailProfile = new UserDetailProfile(requestDto);
        UserDetailProfile savedUser = userDetailRepository.save(userDetailProfile);
        log.info("savedEntity user : {}", savedUser);
        return savedUser;
    }
}
