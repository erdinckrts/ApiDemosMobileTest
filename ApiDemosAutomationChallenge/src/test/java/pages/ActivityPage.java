package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

public class ActivityPage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    public By btn_CustomTitle=By.xpath("//android.widget.TextView[@text='Custom Title']");

    public ActivityPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }
    public WebElement get_btn_CustomTitle() {
        return driver.findElement(btn_CustomTitle);
    }
}
