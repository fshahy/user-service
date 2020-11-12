package com.delifery.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delifery.userservice.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
