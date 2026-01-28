package com.revpassword.main;

import java.util.Scanner;

import com.revpassword.controller.UserController;
import com.revpassword.model.User;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserController userController = new UserController();

        boolean exit = false;

        while (!exit) {

            System.out.println("\n===== RevPassword Manager =====");
            System.out.println("[1] Create a New Account");
            System.out.println("[2] Sign in to Your Account");
            System.out.println("[3] Exit Application");
            System.out.print("Choose one option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    // ---------- REGISTER ----------

                    String firstName;
                    while (true) {
                        System.out.print("Enter your first name: ");
                        firstName = scanner.nextLine();

                        if (isValidName(firstName)) {
                            break;
                        } else {
                            System.out.println(
                                "❌ Invalid characters in first name. Only alphabets allowed. Try again.");
                        }
                    }

                    String lastName;
                    while (true) {
                        System.out.print("Enter your last name: ");
                        lastName = scanner.nextLine();

                        if (isValidName(lastName)) {
                            break;
                        } else {
                            System.out.println(
                                "❌ Invalid characters in last name. Only alphabets allowed. Try again.");
                        }
                    }

                    String fullName = firstName + " " + lastName;

                    String email;
                    while (true) {
                        System.out.print("Enter your email: ");
                        email = scanner.nextLine();

                        if (isValidGmail(email)) {
                            break;
                        } else {
                            System.out.println("❌ Invalid email Try again.");
                        }
                    }

                    System.out.print("Create password: ");
                    String password = scanner.nextLine();

                    boolean registered =
                            userController.register(fullName, email, password);

                    if (registered) {
                        System.out.println("✅ Registration successful!");
                    } else {
                        System.out.println("❌ Registration failed (email may already exist).");
                    }
                    break;

                case 2:
                    int attempts = 0;
                    final int MAX_ATTEMPTS = 5;
                    boolean loggedIn = false;

                    while (attempts < MAX_ATTEMPTS && !loggedIn) {

                        // 🔹 Step 1: Ask email
                        System.out.print("Enter your email: ");
                        String loginEmail = scanner.nextLine();

                        User user = userController.findUserByEmail(loginEmail);

                        // ❌ Email not found
                        if (user == null) {
                            attempts++;
                            System.out.println("❌ Email does not exist. Try again.");
                            System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
                            continue; // ask email again
                        }

                        // 🔹 Step 2: Password attempts for SAME email
                        while (attempts < MAX_ATTEMPTS) {

                            System.out.print("Enter your password: ");
                            String loginPassword = scanner.nextLine();

                            // ❌ Wrong password
                            if (!user.getPassword().equals(loginPassword)) {
                                attempts++;
                                System.out.println("❌ Invalid password. Try again.");
                                System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
                            } else {
                                // ✅ SUCCESS
                                System.out.println("✅ Login successful!");
                                System.out.println("Welcome, " + user.getName());
                                loggedIn = true;
                                break;
                            }
                        }
                    }

                    // 🚫 Account block
                    if (!loggedIn && attempts == MAX_ATTEMPTS) {
                        System.out.println("\n🚫 Too many failed attempts!");
                        System.out.println("Your account has been temporarily blocked for 5 hours for security reasons.");
                    }

                    break;

                case 3:
                    exit = true;
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // ---------- VALIDATION METHODS ----------

    // Name should contain only alphabets (no digits, no special characters)
    private static boolean isValidName(String name) {
        return name != null && name.matches("[a-zA-Z]+");
    }

    // Email must end with @gmail.com
    private static boolean isValidGmail(String email) {
        return email != null && email.endsWith("@gmail.com");
    }
}
