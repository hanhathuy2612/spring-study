package com.huy.spring_study.repository;

import com.huy.spring_study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the {@link User} entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByUsername(String username);
    Optional<User> findOneByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
