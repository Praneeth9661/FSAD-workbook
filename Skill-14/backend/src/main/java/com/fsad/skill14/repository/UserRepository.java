package com.fsad.skill14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fsad.skill14.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
