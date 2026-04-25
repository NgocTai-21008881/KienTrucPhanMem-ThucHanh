package com.movie.ticket.userservice.service;

import com.movie.ticket.userservice.config.JwtUtils;
import com.movie.ticket.userservice.config.RabbitMQConfig;
import com.movie.ticket.userservice.dtos.*;
import com.movie.ticket.userservice.entity.User;
import com.movie.ticket.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService {
    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtUtils jwtUtils;
    @Autowired private RabbitTemplate rabbitTemplate;

    public UserResponse register(RegisterRequest request) {
        log.info("Xử lý đăng ký cho: {}", request.getUsername());

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);

        UserRegisteredEvent event = new UserRegisteredEvent(
                savedUser.getId(), savedUser.getUsername(), savedUser.getEmail()
        );
        try {
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, event);
            log.info("Đã phát event USER_REGISTERED cho user: {}", savedUser.getUsername());
        } catch (Exception e) {
            log.error("KHÔNG THỂ gửi event sang RabbitMQ: {}", e.getMessage());
        }
        return UserResponse.builder()
                .id(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .fullName(savedUser.getFullName())
                .build();
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Tài khoản không tồn tại"));


        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Mật khẩu không chính xác");
        }


        String token = jwtUtils.generateToken(user.getUsername());

        UserResponse userDto = UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .build();

        return LoginResponse.builder()
                .token(token)
                .user(userDto)
                .build();
    }
}
