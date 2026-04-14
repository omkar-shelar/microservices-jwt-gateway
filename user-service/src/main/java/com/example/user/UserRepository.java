package com.example.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
