package com.movie.ticket.userservice.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String token;
    @Builder.Default
    private String type = "Bearer";
    private UserResponse user;
}
