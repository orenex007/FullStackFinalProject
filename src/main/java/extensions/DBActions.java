package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step("Get Credentials From Database For Employees")
    public static List<String> getCredentials(String query){
        List<String> credentials = new ArrayList<String>();
        try {
            rs = stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println("Error Occurred While Printing Table Data, See Details: " + e);
        }
        return credentials;
    }

    @Step("Get Credentials From Database For Clients")
    public static List<String> getCredentialsTwo(String query){
        List<String> credentials = new ArrayList<String>();
        try {
            rs = stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
            credentials.add(rs.getString(3));
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println("Error Occurred While Printing Table Data, See Details: " + e);
        }
        return credentials;
    }
}
