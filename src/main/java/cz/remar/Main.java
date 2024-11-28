package cz.remar;

import cz.remar.db.DBContactServise;
import cz.remar.db.HikaryCPDataSource;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DBContactServise service = new DBContactServise();
        service.readAll().forEach(System.out::println);

    }
}