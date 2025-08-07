package com.connectly.userprofile.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.connectly.userprofile.model.User;

public class UserCache {

	
	 public static Map<String, User> cache = new ConcurrentHashMap<>();

	    static {
	        cache.put("u1", new User("u1", "Alice (Cached)", "alice@cached.com"));
	        cache.put("u2", new User("u2", "Bob (Cached)", "bob@cached.com"));
	    }
}
