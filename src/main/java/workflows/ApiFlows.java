package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: Get List Of Student Property")
    public static String getStudentProperty(String jPath){
        response = ApiActions.get("/student/list");
        return ApiActions.extractFromJSON(response, jPath);
    }
    @Step("Business Flow: Create New Student List in StudentsAPI")
    public static void postStudentProperty(String firstName, String lastName, String email, String programme){
        params.put("firstName", firstName);
        params.put("lastName",lastName);
        params.put("email", email);
        params.put("programme", programme);
        ApiActions.post(params, "/student");
    }
    @Step("Business Flow: Update Existing Student List in StudentsAPI")
    public static void putStudentProperty(String firstName, String lastName, String email, String programme, String id){
        params.put("firstName", firstName);
        params.put("lastName",lastName);
        params.put("email", email);
        params.put("programme", programme);
        ApiActions.put(params, "/student/" + id);
    }
    @Step("Business Flow: Delete Existing Student List in StudentsAPI")
    public static void deleteStudentProperty(String id){
        ApiActions.delete(id);
    }
}
