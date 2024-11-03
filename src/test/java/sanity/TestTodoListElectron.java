package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class TestTodoListElectron extends CommonOps {

    @Test(description = "Test01 - Add And Verify New Task")
    @Description("This Test Adds A New Task And Verifies It In The List Of Tasks")
    public void test01AddAndVerifyNewTask(){
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn C");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 2);
    }
    @Test(description = "Test02 - Add And Verify New Task A Few times")
    @Description("This Test Adds A New Task And Verifies It In The List Of Tasks A Few times")
    public void test02AddAndVerifyNewTasks(){
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn C");
        ElectronFlows.addNewTask("Learn Python");
        ElectronFlows.addNewTask("Learn C#");
        ElectronFlows.addNewTask("Learn C++");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 5);
    }
}
