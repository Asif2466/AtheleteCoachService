package com.ust.AtheleteCoachService.dto;

import com.ust.AtheleteCoachService.model.UserRole;

public record RegisterDTO
        (
    String username,
    String password,
    String confirmPassword,
    UserRole role
        ){

}
