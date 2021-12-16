package com.techiteasy.techiteasy.repository;

import com.techiteasy.techiteasy.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}