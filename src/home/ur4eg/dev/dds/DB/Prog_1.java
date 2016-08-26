package home.ur4eg.dev.dds.DB;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Prog_1 {
    private static final int COUNT = 50;
    static Connection conn ;
    static MyDao dao ;

    public static void main(String[] args) throws DBSystemException, SQLException {
        dao = new MyDao();
        System.out.println("count="+COUNT);
        System.out.println("DBCP");
        conn = ConnectionAdapter.getConnection(new ConnectionFactoryDbcp());
        a();
        JdbcUtils.close(conn);
        System.out.println("JDBC");
        conn = ConnectionAdapter.getConnection(new ConnectionFactoryJdbc());
        a();
        JdbcUtils.close(conn);
        System.out.println("C3P0");
        conn = ConnectionAdapter.getConnection(new ConnectionFactoryC3p0());
        a();
        JdbcUtils.close(conn);
    }

    public static void a() throws DBSystemException {
        List<Long> time = new ArrayList<>();
        dao.selectAll(conn);
        for(int i=0; i<COUNT; i++){
            long in = System.nanoTime();
            dao.selectAll(conn);
            long out = System.nanoTime();
            long delta = (out - in)/1000;
            time.add(delta);
        }
        int avg = 0;
        for(Long i:time){avg += i;
        }
        System.out.println("avg = " + avg / time.size());
    }
}