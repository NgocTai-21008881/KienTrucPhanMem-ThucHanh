package com.movie.ticket.userservice.controller;

import com.movie.ticket.userservice.common.ApiResponse;
import com.movie.ticket.userservice.dtos.LoginRequest;
import com.movie.ticket.userservice.dtos.LoginResponse;
import com.movie.ticket.userservice.dtos.RegisterRequest;
import com.movie.ticket.userservice.dtos.UserResponse;
import com.movie.ticket.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>> register(@Valid @RequestBody RegisterRequest request) {
        UserResponse response = userService.register(request);
        return ResponseEntity.ok(ApiResponse.success(response, "Đăng ký thành công"));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest request) {

        LoginResponse response = userService.login(request);

        return ResponseEntity.ok(ApiResponse.success(response, "Đăng nhập thành công"));
    }
}
