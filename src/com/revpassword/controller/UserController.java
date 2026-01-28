package com.revpassword.controller;
import com.revpassword.model.User;
import com.revpassword.service.AuthService;
import com.revpassword.service.UserService;

public class UserController {
	private AuthService authService;
    private UserService userService;

    public UserController() {
        this.authService = new AuthService();
        this.userService = new UserService();
    }

    /**
     * Register a new user
     */
    public boolean register(String name, String email, String password) {
        return userService.registerUser(name, email, password);
    }

    /**
     * Login user
     */
    public User login(String email, String password) {
        return authService.login(email, password);
    }
    public User findUserByEmail(String email) {
        return authService.findUserByEmail(email);
    }
	

}
