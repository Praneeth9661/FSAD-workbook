package com.fsad.skill15.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fsad.skill15.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
