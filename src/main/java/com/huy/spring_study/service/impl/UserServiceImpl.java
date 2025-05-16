package com.huy.spring_study.service.impl;

import com.huy.spring_study.configuration.security.AuthoritiesConstants;
import com.huy.spring_study.configuration.security.SecurityUtils;
import com.huy.spring_study.custom_transactional.CustomTransactional;
import com.huy.spring_study.domain.Authority;
import com.huy.spring_study.domain.User;
import com.huy.spring_study.dto.RegisterDTO;
import com.huy.spring_study.dto.UserDTO;
import com.huy.spring_study.mapper.RegisterMapper;
import com.huy.spring_study.mapper.UserMapper;
import com.huy.spring_study.repository.AuthorityRepository;
import com.huy.spring_study.repository.UserRepository;
import com.huy.spring_study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final UserMapper userMapper;
    private final RegisterMapper registerMapper;

    @Override
    @CustomTransactional
    public User registerUser(RegisterDTO registerDTO) {
        User newUser = registerMapper.toEntity(registerDTO);

        Set<Authority> authorities = new HashSet<>();
        authorityRepository.findById(AuthoritiesConstants.USER).ifPresent(authorities::add);
        newUser.setAuthorities(authorities);

        return userRepository.save(newUser);
    }

    @Override
    @Transactional(readOnly = true)
    @CustomTransactional
    public Optional<User> getCurrentUser() {
        return SecurityUtils.getCurrentUserLogin()
                .flatMap(userRepository::findOneByUsername);
    }

    @Override
    @Transactional(readOnly = true)
    @CustomTransactional
    public Optional<UserDTO> getUserWithAuthorities() {
        return SecurityUtils.getCurrentUserLogin()
                .flatMap(userRepository::findOneByUsername)
                .map(userMapper::userToUserDTO);
    }
}
