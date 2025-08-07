package com.connectly.userprofile.service;

import org.springframework.stereotype.Service;

import com.connectly.userprofile.model.User;
import com.connectly.userprofile.repository.UserRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserService {

	
	 private final UserRepository userRepository;

	    // Manual constructor instead of Lombok's @RequiredArgsConstructor
	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    // Simulate DB failure for testing
	    @CircuitBreaker(name = "userProfileCB", fallbackMethod = "getUserFromCache")
	    public User getUserById(String id) {

	        // Uncomment this line to simulate DB down
	        //if (true) throw new RuntimeException("DB DOWN");

	        User user = userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not found in DB"));

	        UserCache.cache.put(id, user); // update cache
	        return user;
	    }

	    public User getUserFromCache(String id, Throwable t) {
	        System.out.println("Fallback triggered: " + t.getMessage());

	        return UserCache.cache.getOrDefault(id,
	                new User("0", "Fallback User", "not.available@fallback.com"));
	    }
}
