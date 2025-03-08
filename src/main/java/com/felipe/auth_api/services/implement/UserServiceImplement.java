package com.felipe.auth_api.services.implement;

import com.felipe.auth_api.dtos.UserDto;
import com.felipe.auth_api.models.User;
import com.felipe.auth_api.repositories.UserRepository;
import com.felipe.auth_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto save(UserDto userDto) {

        User userAlreadyExists = userRepository.findByLogin(userDto.login());

        if (userAlreadyExists != null) {
            throw new RuntimeException("Usuário já existe!");
        }

        var passwordHash = passwordEncoder.encode(userDto.password());

        User entity = new User(userDto.name(), userDto.login(), passwordHash, userDto.role());
        User newUser = userRepository.save(entity);
        return new UserDto(newUser.getName(), newUser.getLogin(), newUser.getPassword(), newUser.getRole());
    }
}
