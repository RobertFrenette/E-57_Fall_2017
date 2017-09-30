package edu.hes.e57.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UserManager {
	private static Logger logger = LoggerFactory.getLogger(UserManager.class);
	private List<User> list = new ArrayList<User>();

	public User getUserById(Integer userId) {
		logger.info("Method getUserById() called");
		return list.get(userId - 1);
	}

	public void addUser(User user) {
		logger.info("Method addUser() called");
		list.add(user);
	}

	public List<User> getAllUser() {
		logger.info("Method getAllUsers() called");
		return list;
	}
}
