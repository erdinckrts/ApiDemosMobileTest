package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;
import util.LocatorFactory;

import java.time.Duration;

public class IncomingMessagePage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    public By btn_alertBox_Allow=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[1]");
    public By btn_ShowAppNotification=By.xpath("//android.widget.Button[@content-desc='Show App Notification']");
    private LocatorFactory locatorFactory;



    public IncomingMessagePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
        this.locatorFactory = new LocatorFactory(driver);

    }
    public WebElement get_btn_alertBox_Allow() {
        return driver.findElement(btn_alertBox_Allow);
    }
    public WebElement get_btn_ShowAppNotification() {
        return driver.findElement(btn_ShowAppNotification);
    }

}
