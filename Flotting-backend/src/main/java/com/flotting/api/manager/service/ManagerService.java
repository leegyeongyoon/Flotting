package com.flotting.api.manager.service;

import com.flotting.api.manager.entity.ManagerProfileEntity;
import com.flotting.api.manager.repository.ManagerRepository;
import com.flotting.api.user.entity.UserDetailEntity;
import com.flotting.api.user.service.UserService;
import com.flotting.config.TokenUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final UserService userService;

    /**
     * 매니저 조회
     * @param managerId
     * @return
     */
    @Transactional(readOnly = true)
    public ManagerProfileEntity getManager(Long managerId) {
        ManagerProfileEntity manager = managerRepository.findById(managerId)
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 매니저"));
        return manager;
    }

    /**
     * 매니저 프로필 승인
     * @param tokenUser
     * @param detailProfileId
     */
    @Transactional
    public void approveInfo(TokenUser tokenUser, Long detailProfileId) {
        ManagerProfileEntity manager = getManager(tokenUser.getUserNo());
        UserDetailEntity detailProfile = userService.getDetailUser(detailProfileId);
        detailProfile.approveProfile(manager);
    }
}