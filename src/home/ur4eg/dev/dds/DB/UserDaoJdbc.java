package home.ur4eg.dev.dds.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDaoJdbc implements UserDao {
    public static final String conn_string = "jdbc:mysql://127.0.0.1:3306/test_db?useSSL=false";
    public static final String USER = "root";
    public static final String PWD = "Ebigusey9";
    public static final String SELECT_FROM_USER = "select login, password, mail from users";
    public static final String INSERT_TO_USERS = "insert into users values (?, ?, ?)";
    private Connection connection;

    @Override
    public List<User> selectAll() throws DBSystemException{
        connection = getConnection();
        Statement statement = null;
        ResultSet rs = null;
        try{
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            rs = statement.executeQuery(SELECT_FROM_USER);
            List<User> result = new ArrayList<>();
            while(rs.next()){
                User user = new User();
                user.name = rs.getString("login");
                user.password = rs.getString("password");
                user.host = rs.getString("mail");
                result.add(user);
            }
            connection.commit();
            return result;
        } catch (SQLException e) {
            JdbcUtils.rollBack(connection);
            throw new DBSystemException("can't create SQL", e);
        }finally {
            JdbcUtils.close(rs);
            JdbcUtils.close(statement);
            JdbcUtils.close(connection);
        }
    }

    @Override
    public void insert(User u) throws DBSystemException {
        connection = getConnection(new Properties());
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(INSERT_TO_USERS);
            ps.setString(1, u.name);
            ps.setString(2, u.password);
            ps.setString(3, u.host);
            ps.addBatch();
            ps.clearParameters();

            ps.setString(1, "a");
            ps.setString(2, "a");
            ps.setString(3, "a");
            ps.addBatch();
            ps.clearParameters();

            int[] results = ps.executeBatch();
            //ps.executeUpdate();
            connection.commit();
            // return selectAll();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                throw new DBSystemException("can't make INSERT", e1);
            }
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new DBSystemException("can't close PS", e);
            }
        }

    }

    private Connection getConnection(Properties p) throws DBSystemException{
        Driver d;
        p.put("user",USER);
        p.put("password",PWD);
        try {
            d = new com.mysql.jdbc.Driver();
            return d.connect(conn_string, p);
        } catch (SQLException e) {
            throw new DBSystemException("can't connect with driver", e);
        }
    }

    private Connection getConnection() throws DBSystemException {
        //System.out.println("Connecting to " + conn_string + " ...");
        try {
            return DriverManager.getConnection(conn_string, USER, PWD);
        } catch (SQLException ex) {
            throw new DBSystemException("can't connect using DM", ex);
        }
    }
}
