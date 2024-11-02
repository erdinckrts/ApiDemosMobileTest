package pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

public class HomePage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    public By btn_App=By.xpath("//android.widget.TextView[@content-desc='App']");
    public By btn_Views=By.id("00000000-0000-0bac-ffff-ffff00000014");


    public HomePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }
    public WebElement get_btn_App() {
        return driver.findElement(btn_App);
    }
    public WebElement get_btn_Views() {
        return driver.findElement(btn_Views);
    }
}
