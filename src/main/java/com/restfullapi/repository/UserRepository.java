package com.restfullapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restfullapi.entity.Users;

public interface UserRepository extends JpaRepository<Users, String>{

}
