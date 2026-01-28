RevPassword Manager

Project Description
RevPassword Manager is a console-based Java application that allows users
to securely manage their account credentials. The application supports
user registration, login, password validation, and controlled access
to user-specific password vaults.

The project is built using core Java concepts with a layered architecture
and uses Oracle Database via JDBC for data persistence.


Features Implemented
1. User Registration
   - First name and last name input
   - Name validation (no special characters)
   - Email validation (only @gmail.com allowed)
   - Duplicate email prevention

2. User Login
   - Email existence validation
   - Password validation
   - Retry mechanism (maximum 5 attempts)
   - Account lock simulation after repeated failures
   - Improved UX (retries password without re-entering email)

3. Secure Architecture
   - Layered design (Controller, Service, DAO, Model)
   - JDBC with PreparedStatement
   - Oracle database integration


Technology Stack
- Java (JDK 1.7)
- Oracle Database 10g (XE)
- JDBC (ojdbc6.jar)
- Eclipse IDE
- Git & GitHub



Project Structure
src/
 └── com.revpassword
     ├── main        -> MainApp (UI & flow)
     ├── controller  -> UserController
     ├── service     -> AuthService, UserService
     ├── dao         -> UserDAO
     ├── model       -> User, PasswordEntry, SecurityQuestion
     └── util        -> DBConnection

lib/
 └── ojdbc6.jar


How to Run
1. Import project into Eclipse
2. Add ojdbc6.jar to Build Path
3. Configure DB credentials in DBConnection.java
4. Run MainApp.java as Java Application


Future Enhancements
- Password Vault (Add/View/Delete passwords)
- Database-level account lock (timestamp based)
- Forgot password using security questions
- Encryption for stored passwords
- Logging using Log4J
- Unit testing using JUnit

