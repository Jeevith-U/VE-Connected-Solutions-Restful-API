package com.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfullapi.entity.Users;

import java.util.Optional;

/**
 * This Interface will help to Create All the Needed CRUD Operation on User
 */
public interface UserRepository extends JpaRepository<Users, String> {

    Optional<Users> findByEmail(String email);
}
