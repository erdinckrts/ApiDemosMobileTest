package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.LocatorFactory;

import java.io.IOException;

public class ActivityPage {
    private AndroidDriver driver;
    private LocatorFactory locatorFactory;

    public ActivityPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        this.locatorFactory = new LocatorFactory(driver);
    }

    public By getCustomTitleButton() {
        return locatorFactory.getLocator("activityPage", "btn_CustomTitle");
    }
}
