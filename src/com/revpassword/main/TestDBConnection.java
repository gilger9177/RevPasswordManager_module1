package com.revpassword.main;
import java.sql.Connection;
import com.revpassword.util.DBConnection;

public class TestDBConnection {
	 public static void main(String[] args) {

	        Connection con = null;

	        try {
	            con = DBConnection.getConnection();
	            System.out.println("✅ Oracle DB connected successfully!");
	        } catch (Exception e) {
	            System.out.println("❌ Database connection failed");
	            e.printStackTrace();
	        } finally {
	            try {
	                if (con != null) {
	                    con.close();
	                }
	            } catch (Exception e) {
	                // ignore
	            }
	        }
	    }

}
