package utilities;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ManageDB extends CommonOps{

//    public static String fullDBPATH = "Configuration/DataConfig.db" ;
//    public static String fullDBUrl = "jdbc:sqlite:" + fullDBPATH ;
    public static void openConnection(String fullDBURL, String fullDBPath){
//        dbUrl = fullDBUrl;
//        dbPath = fullDBPATH;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(fullDBURL + fullDBPath);
//            public static String dbUrl = "jdbc:sqlite:" + dbPath;
            stmt = con.createStatement();
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println("Error Occurred While Connecting To DB, See Details: " + e);
        }
    }

    public static void closeConnection(){
        try {
            con.close();
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println("Error Occurred While Closing DB, See Details: " + e);
        }
    }

    public static ResultSet getTableData() throws SQLException {
//        String query = "SELECT * FROM DEMO WHERE id = 3";
        String query = "SELECT name, password FROM Employees WHERE id = 3";
        rs = stmt.executeQuery(query);
        return rs;
    }
    public static ResultSet getTableData2() throws SQLException {
//        String query = "SELECT * FROM DEMO WHERE id = 3";
        String query = "SELECT firstName, lastName, zip FROM Clients WHERE id='4'";
        rs = stmt.executeQuery(query);
        return rs;
    }
}
