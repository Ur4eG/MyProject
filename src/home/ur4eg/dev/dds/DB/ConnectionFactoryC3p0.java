package home.ur4eg.dev.dds.DB;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactoryC3p0 implements ConnectionFactory {
    private Properties p;
    private DataSource dataSource;

    @Override
    public DataSource getDataSource(Properties p)
    {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setUser(p.getProperty("user"));
        ds.setPassword(p.getProperty("pass"));
        ds.setJdbcUrl(p.getProperty("db"));
        System.out.println("ds initialized");
        System.out.println(ds.getJdbcUrl());
        return ds;
    }

    @Override
    public void setParams(Properties p) {
        this.p = p;
    }

    @Override
    public void initDataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setUser(p.getProperty("user"));
        ds.setPassword(p.getProperty("pass"));
        ds.setJdbcUrl(p.getProperty("db"));
        System.out.println("ds initialized");
        System.out.println(p.toString());
        dataSource = ds;
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
}
