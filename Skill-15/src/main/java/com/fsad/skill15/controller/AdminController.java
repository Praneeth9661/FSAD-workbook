package com.fsad.skill15.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/add")
    public String add() {
        return "Admin Add Access";
    }

    @GetMapping("/delete")
    public String delete() {
        return "Admin Delete Access";
    }
}
