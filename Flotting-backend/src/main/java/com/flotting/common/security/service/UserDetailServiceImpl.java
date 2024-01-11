package com.flotting.common.security.service;

import com.flotting.api.user.entity.UserSimpleEntity;
import com.flotting.api.user.repository.UserSimpleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserSimpleRepository userSimpleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        UserSimpleEntity userSimpleEntity = userSimpleRepository.findOneWithAuthoritiesByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with phoneNumber: " + phoneNumber));
        System.out.println("userSimpleEntity = " + userSimpleEntity);


        return userSimpleEntity;
    }
}
