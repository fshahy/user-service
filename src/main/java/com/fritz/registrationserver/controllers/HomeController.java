package com.fritz.registrationserver.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fritz.registrationserver.models.User;
import com.fritz.registrationserver.repositories.UserRepository;

@RestController
@RequestMapping
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@PostMapping("/register")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String notifyUser(@Valid @RequestBody User user) {
		userRepository.save(user);
		
		String message = String.format("New User Created, email=%s", user.getEmail());
		kafkaTemplate.send("user-registration", message);
		return message;
	}
	
}
