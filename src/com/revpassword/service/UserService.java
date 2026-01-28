package com.revpassword.service;
import com.revpassword.dao.UserDAO;
import com.revpassword.model.User;

public class UserService {
	 private UserDAO userDAO;

	    public UserService() {
	        this.userDAO = new UserDAO();
	    }

	    /**
	     * Register a new user
	     */
	    public boolean registerUser(String name, String email, String password) {

	        // Basic validation
	        if (name == null || email == null || password == null) {
	            return false;
	        }

	        // Check if user already exists
	        User existingUser = userDAO.getUserByEmail(email);
	        if (existingUser != null) {
	            return false; // email already registered
	        }

	        // Create User model
	        User user = new User();
	        user.setName(name);
	        user.setEmail(email);
	        user.setPassword(password);

	        // Save user using DAO
	        return userDAO.registerUser(user);
	    }
}
