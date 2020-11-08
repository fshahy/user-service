package com.fritz.registrationserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fritz.registrationserver.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
