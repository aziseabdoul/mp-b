package com.aa.mp.repositories;

import com.aa.mp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    //User findById(String username);
    //User findByUsername(String username);
    //User loadUserByUsername(String username);
    User findByUsername(String username);

}
