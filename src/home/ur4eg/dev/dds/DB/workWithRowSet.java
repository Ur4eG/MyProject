package home.ur4eg.dev.dds.DB;


import com.sun.rowset.WebRowSetImpl;

import javax.sql.rowset.WebRowSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

public class workWithRowSet {
    public static final String SELECT_FROM_USER = "select login, password, mail from users";
    public static final String DATABASE = "jdbc:mysql://127.0.0.1:3306/test_db";
    public static final String USER = "root";
    public static final String PASS = "Ebigusey9";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    public static void main(String[] args) throws SQLException, IOException {
        WebRowSet rowSet = new WebRowSetImpl();
        rowSet.setUrl(DATABASE);
        rowSet.setUsername(USER);
        rowSet.setPassword(PASS);
        rowSet.setCommand(SELECT_FROM_USER);
        rowSet.execute();

        rowSet.writeXml(new FileOutputStream(new File("d:\\mssql.data")));
    }
}
