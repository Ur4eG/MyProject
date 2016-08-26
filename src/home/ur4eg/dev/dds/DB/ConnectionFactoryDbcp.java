package home.ur4eg.dev.dds.DB;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactoryDbcp implements ConnectionFactory {
    private Properties p;
    private DataSource dataSource;

    @Override
    public DataSource getDataSource(Properties p)
    {
        MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
        ds.setUser(p.getProperty("user"));
        ds.setPassword(p.getProperty("pass"));
        ds.setUrl(p.getProperty("db"));
        System.out.println("ds initialized");
        System.out.println(ds.getUrl());
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

    @Override
    public void initDataSource() {
        MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
        ds.setUser(p.getProperty("user"));
        ds.setPassword(p.getProperty("pass"));
        ds.setUrl(p.getProperty("db"));
        System.out.println("ds initialized");
        System.out.println(p.toString());
        dataSource = ds;
    }
}
