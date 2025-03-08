package com.felipe.auth_api.controlles;

import com.felipe.auth_api.dtos.UserDto;
import com.felipe.auth_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    private UserDto save(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping("/admin")
    private String getAdmin() {
        return "Acesso como Administrador";
    }

    @GetMapping("/user")
    private String getUser() {
        return "Acesso como Usuário";
    }

}
