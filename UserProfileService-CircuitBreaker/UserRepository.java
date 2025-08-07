package com.connectly.userprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connectly.userprofile.model.User;

public interface UserRepository  extends JpaRepository<User, String>{

}
