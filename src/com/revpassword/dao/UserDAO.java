package com.revpassword.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revpassword.model.User;
import com.revpassword.util.DBConnection;

public class UserDAO {
	 // 1️⃣ Register new user
    public boolean registerUser(User user) {

        String sql =
            "INSERT INTO USERS (USER_ID, NAME, EMAIL, PASSWORD, CREATED_AT) " +
            "VALUES (USER_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                // ignore
            }
        }
    }

    // 2️⃣ Find user by email (used for login)
    public User getUserByEmail(String email) {

        String sql =
            "SELECT USER_ID, NAME, EMAIL, PASSWORD, CREATED_AT " +
            "FROM USERS WHERE EMAIL = ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);

            rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("USER_ID"));
                user.setName(rs.getString("NAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setCreatedAt(rs.getDate("CREATED_AT"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                // ignore
            }
        }

        return null; // user not found
    }
	

}
