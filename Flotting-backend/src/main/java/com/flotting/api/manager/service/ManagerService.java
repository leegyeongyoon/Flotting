package com.flotting.api.manager.service;

import com.flotting.api.manager.repository.ManagerRepository;
import com.flotting.api.user.service.UserService;
import com.flotting.config.TokenUser;
import com.flotting.domain.ManagerProfile;
import com.flotting.domain.UserDetailProfile;
import com.flotting.domain.UserSimpleProfile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

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
    public ManagerProfile getManager(Long managerId) {
        ManagerProfile manager = managerRepository.findById(managerId)
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
        ManagerProfile manager = getManager(tokenUser.getSeq());
        UserDetailProfile detailProfile = userService.getDetailUser(detailProfileId);
        detailProfile.approveProfile(manager);
    }
}