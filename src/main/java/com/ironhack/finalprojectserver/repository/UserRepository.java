package com.ironhack.finalprojectserver.repository;


import com.ironhack.finalprojectserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
