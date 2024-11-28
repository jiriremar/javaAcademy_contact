package cz.remar.db;

import org.slf4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class DBContactService {

    private static final String READ_ALL = "SELECT * FROM contact";
    private static final String CREATE = "INSERT INTO contact (name, email, phone) VALUES (?, ?, ?)";
    private static final String DELETE = "DELETE FROM contact WHERE id = ?";

    private static final Logger logger = getLogger(DBContactService.class);


    public List<Contact> readAll() {
        try (
                Connection connection = HikaryCPDataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(READ_ALL)
        ) {

            ResultSet resultSet = statement.executeQuery();
            List<Contact> contacts = new ArrayList<>();
            while (resultSet.next()) {
                contacts.add(new Contact(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("phone")
                ));
            }
            return contacts;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }


    public int create(String name, String email, String phone) {
        try (
                Connection connection = HikaryCPDataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(CREATE)
        ) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phone);

            return statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Contact already exists");
            return 0;
        } catch (SQLException e) {
            logger.error("ERROR: " + e.getMessage());
            return 0;
        }
    }

    public int delete(int id) {
        try (
                Connection connection = HikaryCPDataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE)
        ) {
                statement.setInt(1, id);
                return statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("ERROR: " + e.getMessage());
            return  0;
        }
    }
}

