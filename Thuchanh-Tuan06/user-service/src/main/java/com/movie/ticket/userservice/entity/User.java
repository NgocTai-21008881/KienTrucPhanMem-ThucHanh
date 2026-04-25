package com.movie.ticket.userservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username không được để trống")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Password không được để trống")
    private String password;

    private String fullName;
    private String email;
}
