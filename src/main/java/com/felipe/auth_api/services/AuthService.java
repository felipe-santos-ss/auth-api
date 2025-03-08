package com.felipe.auth_api.services;

import com.felipe.auth_api.dtos.AuthDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    public String getToken(AuthDto authDto);

    public String validateToken(String token);


}
