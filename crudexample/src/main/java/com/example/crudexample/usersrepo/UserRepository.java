package com.example.crudexample.usersrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.crudexample.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername(String username);
}
