package home.ur4eg.dev.dds.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyDao {
    public static final String SELECT_FROM_USER = "select login, password, mail from users";

    public List<User> selectAll(Connection connection) throws DBSystemException{
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
           // JdbcUtils.close(connection);
        }
    }
}
