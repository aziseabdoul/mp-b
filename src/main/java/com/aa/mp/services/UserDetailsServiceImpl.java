package com.aa.mp.services;

import com.aa.mp.model.User;
import com.aa.mp.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repo;

    public UserDetailsServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("no user found with username: " + username);
        }
        return toSpringUser(user);
    }

    private static org.springframework.security.core.userdetails.User toSpringUser(User user) {
        String password = user.getPassword();
        //boolean enabled = user.isEnabled();
        Set<GrantedAuthority> authorities = new HashSet<>();
        //GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getCode());
        //authorities.add(authority);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), password, authorities);
    }

}
