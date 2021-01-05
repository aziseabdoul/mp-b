package com.aa.mp.services;

import com.aa.mp.dtos.UserDto;

public interface UserService {

    void registerUser(UserDto dto);

    void verifyUser(String username, String password);

}
