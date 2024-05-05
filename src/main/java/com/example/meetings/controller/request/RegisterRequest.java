package com.example.meetings.controller.request;

import com.example.meetings.model.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String email;
    private String password;
    private String username;
    private Roles role;
}
