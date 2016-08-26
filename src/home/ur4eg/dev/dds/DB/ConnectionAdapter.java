package home.ur4eg.dev.dds.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionAdapter {
    public static final String DATABASE = "jdbc:mysql://127.0.0.1:3306/test_db";
    public static final String USER = "root";
    public static final String PASS = "Ebigusey9";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static final String SELECT_FROM_USER = "select login, password, mail from users";
    public static final String INSERT_TO_USERS = "insert into users values (?, ?, ?)";
    public Connection connection;

    public static Connection getConnection(ConnectionFactory adapter) throws DBSystemException, SQLException {
        Properties p = new Properties();
        p.setProperty("user", USER);
        p.setProperty("pass", PASS);
        p.setProperty("db", DATABASE);
        adapter.setParams(p);
        adapter.initDataSource();
        return adapter.getConnection();
    }

    public ConnectionAdapter(ConnectionFactory type) throws DBSystemException {
        Properties p = new Properties();
        p.setProperty("user", USER);
        p.setProperty("pass", PASS);
        p.setProperty("db", DATABASE);
        type.setParams(p);
    }


}
