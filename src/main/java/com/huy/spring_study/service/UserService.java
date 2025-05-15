package com.huy.spring_study.service;

import com.huy.spring_study.domain.User;
import com.huy.spring_study.dto.RegisterDTO;
import com.huy.spring_study.dto.UserDTO;

import java.util.Optional;

public interface UserService {
    User registerUser(RegisterDTO registerDTO);

    Optional<User> getCurrentUser();

    Optional<UserDTO> getUserWithAuthorities();
}
