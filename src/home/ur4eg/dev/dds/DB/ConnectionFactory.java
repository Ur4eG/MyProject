package home.ur4eg.dev.dds.DB;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public interface ConnectionFactory {
    Connection getConnection() throws SQLException, DBSystemException;
    void close(Connection connection) throws SQLException;
    DataSource getDataSource(Properties p);
    void setParams(Properties p);
    void initDataSource();
}
