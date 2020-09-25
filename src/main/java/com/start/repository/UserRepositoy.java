package com.start.repository;

import org.springframework.data.repository.CrudRepository;

import com.start.model.User;

public interface UserRepositoy extends CrudRepository<User, Integer> {

	
}
