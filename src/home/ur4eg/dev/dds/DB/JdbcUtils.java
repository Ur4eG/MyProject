package home.ur4eg.dev.dds.DB;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
    static public void close(Connection connection){
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            // NOP
        }
    }
    static public void close(Statement statement){
        try {
            if(statement != null)
                statement.close();
        } catch (SQLException e) {
            //
        }
    }
    static public void close(PreparedStatement ps){
        try {
            if(ps != null)
                ps.close();
        } catch (SQLException e) {
            //
        }
    }
    static public void close(ResultSet rs){
        try {
            if(rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static public void rollBack(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
