package RestMan.Controller.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

// Kết nối tới DataBase của hệ thống
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() {

    }
    // Thực hiện kết nối tới Database
    public void connectToDatabase() throws SQLException {
        try {
            // Đăng ký driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy driver MySQL", e);
        }

        final String url = "jdbc:mysql://localhost:3306/qlnhahang2";
        final String username = "root";
        final String password = "";
        connection = DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}