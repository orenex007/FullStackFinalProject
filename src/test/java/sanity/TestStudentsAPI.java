package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

@Listeners(utilities.Listeners.class)
public class TestStudentsAPI extends CommonOps {

    @Test(description = "Test 01: Verify Get Students List From TestStudentsAPI")
    @Description("This Test Verify Students List Property")
    public void test01VerifyList(){
        Verifications.verifyText(ApiFlows.getStudentProperty("[0].firstName"), "Vernon");
    }

    @Test(description = "Test 02: Verify Add Student And Verify")
    @Description("This Test Adds a Student to TestStudentsAPI and Verify it")
    public void test02AddStudentAndVerify(){
        ApiFlows.postStudentProperty("Oren", "Abarbanel", "a16oren@gmail.com", "QA Automation");
        Verifications.verifyText(ApiFlows.getStudentProperty("[100].firstName"), "Oren");
    }
    @Test(description = "Test 03: Verify Update Student And Verify")
    @Description("This Test Update a Student in TestStudentsAPI and Verify it")
    public void test03UpdateStudentAndVerify(){
        String id = ApiFlows.getStudentProperty("[100].id");
        ApiFlows.putStudentProperty("Oren", "Berserk", "a16orenBerserk@gmail.com", "QA Automation", id);
        Verifications.verifyText(ApiFlows.getStudentProperty("[100].email"), "a16orenBerserk@gmail.com");
    }
    @Test(description = "Test 04: Verify Delete Student And Verify")
    @Description("This Test Deletes a Student in TestStudentsAPI and Verify it")
    public void test04DeleteStudentAndVerify(){
        String id = ApiFlows.getStudentProperty("[100].id");
        ApiFlows.deleteStudentProperty(id);
//        Verifications.verifyText(ApiFlows.getStudentProperty("[100].email"), "a16orenBerserk@gmail.com");
        Verifications.verifyNumber(response.statusCode(),204);
    }
}
