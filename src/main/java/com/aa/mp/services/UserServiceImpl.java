package com.aa.mp.services;

import com.aa.mp.dtos.UserDto;
import com.aa.mp.model.User;
import com.aa.mp.repositories.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /*@Override
    @Transactional
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
        //List<Role> roles = user.getRoles();
        //Set<GrantedAuthority> authorities = roles.stream()
                //.map(role -> new SimpleGrantedAuthority(role.getName()))
                //.collect(toSet());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public void verifyUser(UserDto dto) {
        User user = UserService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("bad credentials " + username);
        }
    }*/

    /*@Override
    public void verifyUser(UserDto dto) {
        UserDetails user = userDetailsService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("bad credentials " + username);
        }
    }*/

}
