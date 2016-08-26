package home.ur4eg.dev.dds.DB;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcC3p0 implements UserDao {

    public static final String conn_string = "jdbc:mysql://127.0.0.1:3306/test_db?useSSL=false";
    public static final String USER = "root";
    public static final String PWD = "Ebigusey9";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String SELECT_FROM_USER = "select login, password, mail from users";
    public static final String INSERT_TO_USERS = "insert into users values (?, ?, ?)";
    private final DataSource dataSource = DataSourceInit();
    private Connection connection;
    private int openCons = 0;
    /*{ //
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass(DRIVER);
            cpds.setJdbcUrl(conn_string);
            cpds.setUser(USER);
            cpds.setPassword(PWD);
            this.dataSource = cpds;
        } catch (PropertyVetoException e) {
            throw new RuntimeException("C3P0 connection error: ", e);
        }
    }*/

    private DataSource DataSourceInit(){
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass(DRIVER);
            cpds.setJdbcUrl(conn_string);
            cpds.setUser(USER);
            cpds.setPassword(PWD);
            cpds.setMaxStatements(100);
            cpds.setMaxStatementsPerConnection(10);
            cpds.setMinPoolSize(1);
            cpds.setAcquireIncrement(1);
            cpds.setMaxPoolSize(100);
            //cpds.setCheckoutTimeout();
            System.out.println("timeout=" + cpds.getCheckoutTimeout());
            return cpds;
        } catch (PropertyVetoException e) {
            throw new RuntimeException("C3P0 connection error: ", e);
        }
    }

    private Connection getConnection() throws DBSystemException {
        //System.out.println("conn..." + openCons++);
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new DBSystemException("can't connect using C3P0", e);
        }
    }

    @Override
    public List<User> selectAll() throws DBSystemException {
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
            //throw e;
        }finally {
            JdbcUtils.close(rs);
            JdbcUtils.close(statement);
            JdbcUtils.close(connection);
        }
    }

    @Override
    public void insert(User user) throws DBSystemException {

    }
}
