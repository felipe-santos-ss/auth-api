package com.felipe.auth_api.dtos;

import com.felipe.auth_api.enums.RoleEnum;

public record UserDto(
        String name,
        String login,
        String password,
        RoleEnum role
) {
}
