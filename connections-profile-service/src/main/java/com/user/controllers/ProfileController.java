package com.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/rest")
@RestController
public class ProfileController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/secured/all")
    public String firstPage() {
        return "hawle";
    }
}
