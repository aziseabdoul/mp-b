package com.aa.mp.controllers;

import com.aa.mp.dtos.UserDto;
import com.aa.mp.services.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {

    //@Autowired
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserDto dto) {
        //userService.registerUser(user.getUsername(), user.getPassword());
        service.registerUser(dto);
    }

    /*@GetMapping("/login")
    public void login(@RequestBody UserDto dto) {
        service.verifyUser(dto);
    }*/

}
