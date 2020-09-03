package com.aa.mp.services;

import com.aa.mp.dtos.UserDto;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserService {

    //private final PasswordEncoder encoder;

    void registerUser(UserDto dto);

    /*@Override
    public void verifyUser(UserDto dto) {
        UserDetails user = UserDetailsService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("bad credentials " + username);
        }
    }*/
    /*static void loadUserByUsername(String username) {

    }*/

    //void verifyUser(UserDto dto);

    /*@Override
    public void verifyUser(UserDto dto) {
        UserDetails user = userDetailsService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("bad credentials " + username);
        }
    }*/

}
