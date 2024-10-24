package Helper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TemporaryAPI {
    RequestSpecification httpRequest;
    Response response;
    JsonPath jp;

    final String BASE_URL = "http://localhost:9000";
//    String url = "http://localhost:3000/";

    @Test
    public void testingAPI() {
        RestAssured.baseURI = BASE_URL;
        httpRequest = RestAssured.given();

//        httpRequest = RestAssured.given().auth().preemptive().basic("standard_user", "secret_sauce");

        //Get Request
//        response = httpRequest.get("/student/list/");
//        jp = response.jsonPath();
//        List<String> firstNames = jp.getList("firstName");
//        List<String> lastNames = jp.getList("lastName");
//        List<String> emails = jp.getList("email");
//        List<String> programmes = jp.getList("programmes");
////        List<String> courses = jp.getList("courses"); // Ask Sade
//        for (int i = 0; i < firstNames.size(); i++) {
////            System.out.println("FirstName: " + firstNames.get(i) + " Last Name: " + lastNames.get(i));
//            System.out.println("[" + i + "]= First Name: " + firstNames.get(i) + ", Last Name: " + lastNames.get(i) +
//                    ", Email: " + emails.get(i) +
//                    ", Programmes: " + programmes.get(i));
////                    ", Courses: " + courses.get(i)); // Ask Sade
//        }
//        response.prettyPrint();
//        Assert.assertEquals(response.statusCode(), 200); //GET


    //Post + Put Request
//        JSONObject params = new JSONObject();
//        params.put("firstName", "AAATeam");
//        params.put("lastName","AAALastTeam");
//        params.put("email", "AAATeam@gmail.com");
//        params.put("programme","QA Automation");
//        params.put("courses", Arrays.asList("Java","Python","C", "C++", "C#"));
//
//        httpRequest.header("Content-Type", "application/json");
//
//        httpRequest.body(params.toJSONString());
//        response = httpRequest.post("/student");

//        response = httpRequest.put("/student/101");

        //Delete Request
//        response = httpRequest.delete("/student/101");

//        System.out.println(response.getBody().asString());

//        response.prettyPrint();
//        Assert.assertEquals(response.statusCode(),201); //POST
//        Assert.assertEquals(response.statusCode(),200); //PUT
//        Assert.assertEquals(response.statusCode(),204); //DELETE
    }
}

