package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

public class AppPage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    public By btn_Activity=By.xpath("//android.widget.TextView[@text='Activity']");
    public By btn_AlertDialogs=By.xpath("//android.widget.TextView[@content-desc='Alert Dialogs']");

    public AppPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }
    public WebElement get_btn_Activity() {
        return driver.findElement(btn_Activity);
    }
    public WebElement get_btn_AlertDialogs() {
        return driver.findElement(btn_AlertDialogs);
    }
}
