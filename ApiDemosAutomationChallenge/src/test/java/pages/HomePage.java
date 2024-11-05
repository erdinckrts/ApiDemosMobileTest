package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.LocatorFactory;

import java.io.IOException;

public class HomePage {
    private AndroidDriver driver;
    private LocatorFactory locatorFactory;


    public HomePage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        this.locatorFactory = new LocatorFactory(driver);
    }
    public By getAppButton() {
        return locatorFactory.getLocator("homePage", "btn_App");
    }
    public By getViewButton() {
        return locatorFactory.getLocator("homePage", "btn_Views");
    }
}
