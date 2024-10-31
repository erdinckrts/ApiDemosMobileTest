package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

public class NotificationPage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public By btn_IncomingMessage=By.id("000000000-0000-0bb4-ffff-ffff000000b0");


    public NotificationPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }


    public WebElement get_btn_IncomingMessage() {
        return driver.findElement(btn_IncomingMessage);
    }
}
