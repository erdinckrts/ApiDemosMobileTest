package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;
import util.LocatorFactory;

import java.time.Duration;

public class NotificationBarPage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    public By littleFrame_notification=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout[1]");
    public By littleFrameText_notification=By.xpath("//android.widget.TextView[@class='android.widget.TextView' and @package='com.android.systemui']");


    public  By page_NotificationDetails=By.id("android:id/action_bar_container");
    public  By text_Message=By.id("io.appium.android.apis:id/message");
    private LocatorFactory locatorFactory;




    public NotificationBarPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
        this.locatorFactory = new LocatorFactory(driver);

    }
    public WebElement get_littleFrame_notification() {
        return driver.findElement(littleFrame_notification);
    }

    public WebElement get_littleFrameText_notification() {
        return driver.findElement(littleFrameText_notification);
    }


    public WebElement get_page_NotificationDetails() {
        return driver.findElement(page_NotificationDetails);
    }
    public WebElement get_text_Message() {
        return driver.findElement(text_Message);
    }
}
