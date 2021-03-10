package com.example.ProductManager.service;

import com.example.ProductManager.controller.dto.UserRegistrationDto;
import com.example.ProductManager.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
