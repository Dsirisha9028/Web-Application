import java.sql.*;
public class DbConnection {
    public static Connection dbConnection() throws ClassNotFoundException,SQLException {
         String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/";
        String dbName = "antiragging";
        String dbUsername = "Sirisha";
        String dbPassword = "1234";
  
        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName,
                                                     dbUsername, 
                                                     dbPassword);
        return con;
    }
    
}
