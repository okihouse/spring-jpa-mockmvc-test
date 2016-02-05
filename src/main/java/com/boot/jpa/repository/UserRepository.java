package com.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.jpa.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
