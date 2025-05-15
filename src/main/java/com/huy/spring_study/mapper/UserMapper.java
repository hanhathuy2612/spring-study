package com.huy.spring_study.mapper;


import com.huy.spring_study.domain.Authority;
import com.huy.spring_study.domain.Permission;
import com.huy.spring_study.domain.User;
import com.huy.spring_study.dto.UserDTO;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper for the entity {@link User} and its DTO called {@link UserDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserMapper {

    @Mapping(target = "roles", source = "authorities", qualifiedByName = "authoritiesToRoles")
    @Mapping(target = "permissions", source = "permissions", qualifiedByName = "permissionsToPermissionStrings")
    UserDTO userToUserDTO(User user);

    @Named("authoritiesToRoles")
    default Set<String> authoritiesToRoles(Set<Authority> authorities) {
        return authorities.stream()
                .map(Authority::getName)
                .collect(Collectors.toSet());
    }

    @Named("permissionsToPermissionStrings")
    default Set<String> permissionsToPermissionStrings(Set<Permission> permissions) {
        return permissions.stream().map(Permission::getName).collect(Collectors.toSet());
    }

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "permissions", ignore = true)
    User userDTOToUser(UserDTO userDTO);
} 