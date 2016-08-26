package home.ur4eg.dev.dds;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;
import java.util.Scanner;


public class MSSQL_connection {

    public static String srv = "127.0.0.1";
    public static String db = "aquatestR";
    public static String port = "1433";
    public static String driver = "com.sqlserver.jdbc.SQLServerDriver";
//net.sourceforge.jtds.jdbc.Driver()
    public static void main(String[] args) {
        Connection connection = null;
        /*try {
            Class.forName(driver).newInstance();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }*/
        /*try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //DriverManager.getDriver();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/



        System.out.println("Driver " + driver + "loaded.");
        String conn_string = "jdbc:microsoft:sqlserver://";
        Properties p = new Properties();
            p.put("user", "USB\\ext-CarltonM");
            p.put("password", "!Unicredit!9");
        Scanner in = new Scanner(System.in);
        System.out.print("Enter MS SQL Server host name: ");
        srv = in.nextLine();
        if(srv.equals("")){
            srv = "localhost";
            System.out.println("Host is '" + srv + "'");
        }
        System.out.print("Enter host port: ");
        port = in.nextLine();
        if(port.equals("")){
            port = "1433";
            System.out.println("Port is '" + port +"'");
        }
        System.out.println("Enter DB name: ");
        db = in.nextLine();
        if(db.equals("")){
            db = "aquatestR";
            System.out.println("DB is '" + db + "'");
        }
        conn_string += srv + ":" + port +";databaseName=" +db + ";integratedSecurity=true;";
        System.out.println("Connecting to " + conn_string + "...");
        try{
            connection = DriverManager.getConnection(conn_string, p);
            System.out.println("connection established.");
        } catch (SQLException ex) {
            // handle any errors
            ex.printStackTrace();
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException ignore)  {
                    //NOP}
                }
            }
        }
    }
}
