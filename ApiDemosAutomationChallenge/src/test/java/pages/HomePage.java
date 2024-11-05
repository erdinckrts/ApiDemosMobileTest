package pages;

import io.appium.java_client.android.AndroidDriver;
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
    public WebElement getAppButton() {
        return driver.findElement(LocatorFactory.getLocator("homePage", "btn_App"));
    }
}
