package com.felipe.auth_api.services.implement;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.felipe.auth_api.dtos.AuthDto;
import com.felipe.auth_api.models.User;
import com.felipe.auth_api.repositories.UserRepository;
import com.felipe.auth_api.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AuthServiceImplement implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }

    @Override
    public String getToken(AuthDto authDto) {
        User user = userRepository.findByLogin(authDto.login());
        return generateToken(user);
    }

    public String generateToken(User user) {

        try {
            Algorithm augorithm = Algorithm.HMAC256("my-secret");
            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getLogin())
                    .withExpiresAt(generateExpirationDate())
                    .sign(augorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token " + exception.getMessage());
        }
    }

    public String validateToken(String token) {
        try {

            Algorithm augorithm = Algorithm.HMAC256("my-secret");

            return JWT.require(augorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
    }
}
