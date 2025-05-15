package com.huy.spring_study.mapper;

import com.huy.spring_study.domain.User;
import com.huy.spring_study.dto.RegisterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Mapper for converting Registration DTO to User entity.
 */
@Mapper(componentModel = "spring", uses = {})
public abstract class RegisterMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "password", expression = "java(passwordEncoder.encode(registerDTO.getPassword()))")
    @Mapping(target = "username", expression = "java(registerDTO.getUsername().toLowerCase())")
    @Mapping(target = "email", expression = "java(registerDTO.getEmail().toLowerCase())")
    public abstract User toEntity(RegisterDTO registerDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "password", ignore = true)
    public abstract void updateUserFromDTO(RegisterDTO registerDTO, @MappingTarget User user);
} 