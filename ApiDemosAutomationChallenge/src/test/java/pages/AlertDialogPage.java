package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;
import java.util.List;

public class AlertDialogPage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    private String[][] buttonData;
    public By btn_List = By.className("android.widget.Button");




    public AlertDialogPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }
    public List<WebElement> getElementListInLinearLayout() {
        return driver.findElements(btn_List);
    }
    public String[][] getAlertTextAndIndex() {
        buttonData = new String[][] {
                {"1", "OK Cancel dialog with a message"},
                {"2", "OK Cancel dialog with a long message"},
                {"3", "OK Cancel dialog with ultra long message"},
                {"4", "List dialog"},
                {"5", "Progress dialog"},
                {"6", "Single choice list"},
                {"7", "Repeat alarm"},
                {"8", "Send Call to VoiceMail"},
                {"9", "Text Entry dialog"},
                {"10", "OK Cancel dialog with traditional theme"},
                {"11", "OK Cancel dialog with Holo Light theme"},
        };
        return buttonData;
    }
}
