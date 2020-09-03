package com.aa.mp.services;

import com.aa.mp.dtos.UserDto;
import com.aa.mp.model.User;
import com.aa.mp.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void registerUser(UserDto dto) {
        //
        User user = new User();
        user.setUsername(dto.getUsername());
        //user.setPassword(dto.getPassword());
        String rawPassword = dto.getPassword();
        String encodedPassword = encoder.encode(rawPassword);
        user.setPassword(encodedPassword);
        repository.save(user);

    }

}
