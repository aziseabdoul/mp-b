package com.aa.mp.controllers;

import com.aa.mp.dtos.UserDto;
import com.aa.mp.services.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    //@GetMapping("/api/login")
    //public void login() {

    //}

    @RequestMapping("/login")
    public void login(@RequestBody UserDto user) {
        //userService.verifyUser(user.getUsername(), user.getPassword());
        service.verifyUser(user.getUsername(), user.getPassword());
    }

}
