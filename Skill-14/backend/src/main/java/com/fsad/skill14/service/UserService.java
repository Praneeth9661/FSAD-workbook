package com.fsad.skill14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fsad.skill14.model.User;
import com.fsad.skill14.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }

    public User login(String username, String password) {
        User user = repo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User getUser(Long id) {
        return repo.findById(id).orElse(null);
    }
}
