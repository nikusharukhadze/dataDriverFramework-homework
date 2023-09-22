package DataObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
    public static Connection getConnection() throws SQLException {
        Connection conn =  null;

            String url = "jdbc:sqlserver://PC\\\\MSSQLSERVER2019;databaseName=Student;portNumber=1433;encrypt=true;trustServerCertificate=true;";
            String user = "testAutomation";
            String password = "Testautomation123";

            conn = DriverManager.getConnection(url,user,password);

        return  conn;
    }




}
