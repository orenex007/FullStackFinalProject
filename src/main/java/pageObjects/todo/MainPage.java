package pageObjects.todo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy(css = "input[placeholder='Create a task']")
    public WebElement txt_create;
    @FindBy(how = How.CLASS_NAME, using = "taskWrapper_2u8dN")
    public List<WebElement> list_tasks;
    @FindBy(className = "destroy_19w1q")
    public WebElement btn_X;
}
