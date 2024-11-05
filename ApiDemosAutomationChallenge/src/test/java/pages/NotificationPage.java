package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;
import util.LocatorFactory;

import java.time.Duration;

public class NotificationPage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    private LocatorFactory locatorFactory;

    public NotificationPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
        this.locatorFactory = new LocatorFactory(driver);
    }

    public By getIncomingMessageButton() {
        return locatorFactory.getLocator("notificationPage","btn_IncomingMessage");
    }

    public By getNotifyingServiceControllerButton() {
        return locatorFactory.getLocator("notificationPage","btn_NotifyingServiceController");
    }

    public By getNotifyWithTextButton() {
        return locatorFactory.getLocator("notificationPage","btn_NotifyWithText");
    }

    public By getStatusBarButton() {
        return locatorFactory.getLocator("notificationPage","btn_StatusBar");
    }
}
