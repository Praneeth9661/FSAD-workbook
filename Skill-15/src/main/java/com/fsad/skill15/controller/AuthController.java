package com.fsad.skill15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.web.bind.annotation.*;
import com.fsad.skill15.entity.User;
import com.fsad.skill15.security.JwtUtil;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );

        return jwtUtil.generateToken(user.getUsername());
    }
}
