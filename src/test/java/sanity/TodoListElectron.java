package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test(description = "Test01 - Add And Verify New Task")
    @Description("This Test Adds A New Task And Verifies It In The List Of Tasks")
    public void test01AddAndVerifyNewTask(){
        ElectronFlows.addNewTask("Learn Java");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 1);
    }
    @Test(description = "Test01 - Add And Verify New Task")
    @Description("This Test Adds A New Task And Verifies It In The List Of Tasks")
    public void test02AddAndVerifyNewTasks(){
        ElectronFlows.addNewTask("Learn Java");
        ElectronFlows.addNewTask("Learn Python");
        ElectronFlows.addNewTask("Learn C#");
        Verifications.verifyNumber(ElectronFlows.getNumberOfTasks(), 3);
    }
}
