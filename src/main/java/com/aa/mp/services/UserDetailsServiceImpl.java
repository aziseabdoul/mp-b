/*
package com.aa.mp.services;

import com.aa.mp.dtos.UserDto;
import com.aa.mp.model.User;
import com.aa.mp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//import org.springframework.security.core.userdetails.User;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
        //List<Role> roles = user.getRoles();
        //Set<GrantedAuthority> authorities = roles.stream()
                //.map(role -> new SimpleGrantedAuthority(role.getName()))
                //.collect(toSet());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword());
    }

    @Override
    public void verifyUser(UserDto dto) {
        UserDetails user = UserDetailsService.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("bad credentials " + username);
        }
    }

}
*/

package com.aa.mp.services;

import com.aa.mp.model.User;
import com.aa.mp.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        //Set<GrantedAuthority> authorities = new HashSet<>();
        //GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getCode());
        //authorities.add(authority);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), password, null);
    }

}
