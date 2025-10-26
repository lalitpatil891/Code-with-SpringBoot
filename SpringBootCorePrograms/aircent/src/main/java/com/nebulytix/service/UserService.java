package com.nebulytix.service;

import java.util.List;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.nebulytix.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	 public List<Task> createTasks(List<Task> tasks) {
	        return userRepository.save(tasks);
	    }
	
}
