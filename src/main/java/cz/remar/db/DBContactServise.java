package cz.remar.db;

import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class DBContactServise {
    private static final String READ_ALL = "SELECT * FROM contact";
    private static final Logger logger = getLogger(DBContactServise.class);

    public List<Contact> readAll() {
        try(Connection connection = HikaryCPDataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(READ_ALL)) {

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
}

