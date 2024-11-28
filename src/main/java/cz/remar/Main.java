package cz.remar;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String select = "SELECT * FROM contact";

        try (Connection conn = HikaryCPDataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(select);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phoneNumber = rs.getString("phone");
                System.out.println("id: " + id + ", name: " + name + ", email: " + email + ", phone number: " + phoneNumber);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}