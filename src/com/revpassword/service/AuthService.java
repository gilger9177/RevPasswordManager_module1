package com.revpassword.service;
import com.revpassword.dao.UserDAO;
import com.revpassword.model.User;

public class AuthService {
	 private UserDAO userDAO;

	    public AuthService() {
	        this.userDAO = new UserDAO();
	    }

	    // Check if email exists
	    public User findUserByEmail(String email) {
	        return userDAO.getUserByEmail(email);
	    }

	    // Check password correctness
	    public boolean isPasswordCorrect(User user, String password){
	        return user.getPassword().equals(password);
	        }

	    /**
	     * Authenticate user using email and password
	     */
	    public User login(String email, String password) {

	        // Ask DAO to fetch user
	        User user = userDAO.getUserByEmail(email);

	        // User not found
	        if (user == null) {
	            return null;
	        }

	        // Password check (plain text as per project scope)
	        if (user.getPassword().equals(password)) {
	            return user; // login success
	        }

	        // Password mismatch
	        return null;
	    }

}
