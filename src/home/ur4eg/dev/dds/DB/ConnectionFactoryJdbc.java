package home.ur4eg.dev.dds.DB;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactoryJdbc implements ConnectionFactory {
    public static final String DATABASE = "jdbc:mysql://127.0.0.1:3306/test_db";
    public static final String USER = "root";
    public static final String PASS = "Ebigusey9";
    private Properties p;
    private DataSource dataSource ;

    @Override
    public void initDataSource(){
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUser(p.getProperty("user"));
        ds.setPassword(p.getProperty("pass"));
        ds.setUrl(p.getProperty("db"));
        System.out.println("ds initialized");
        System.out.println(p.toString());
        dataSource = ds;
    }

    @Override
    public DataSource getDataSource(Properties p)
    {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setUser(p.getProperty("user"));
        ds.setPassword(p.getProperty("pass"));
        ds.setUrl(p.getProperty("db"));
        System.out.println("ds initialized");
        System.out.println(p.toString());
        return ds;
    }

    @Override
    public Connection getConnection() throws DBSystemException {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new DBSystemException("Can't connect");
        }
    }

    @Override
    public void close(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public void setParams(Properties p) {
        this.p = p;
    }

}
