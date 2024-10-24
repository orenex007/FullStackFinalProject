package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution) {
        System.out.println("---------------------- Starting Execution ------------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("---------------------- Ending Execution ------------------");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("---------------------- Starting Test: " + test.getName() + " Started ------------------");
//        try {
//            MonteScreenRecorder.startRecord(test.getName());
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("---------------------- Test: " + test.getName() + " Passed ------------------");
        if (!platform.equalsIgnoreCase("api")){
            // Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            // Delete Recorded File
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if(file.delete()) {
                System.out.println("Recorded Screen Cast File Deleted Successfully");
            }
            else {
                System.out.println("Failed to Delete the Recorded Screen Cast File");
            }
        }
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("---------------------- Test "  + test.getName() + " Failed ------------------");
        if (!platform.equalsIgnoreCase("api")){
            // Stop Recording
            try {
                MonteScreenRecorder.stopRecord();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot();
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println("---------------------- Skipping Test: " + test.getName() + " ------------------");
    }
    @Attachment(value = "Page Screenshot",type = "image/png")
    public byte[] saveScreenshot() {
        if (!platform.equalsIgnoreCase("mobile")) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        else {
            return ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES);
        }
    }
}
