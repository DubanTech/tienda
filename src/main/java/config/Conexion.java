package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection connection = null;
    
    private static final String URL = "jdbc:mariadb://localhost:3306/tienda?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "DubanPro123!";

    private Conexion() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver de MariaDB no encontrado", e);
            }
        }
        return connection;
    }
}