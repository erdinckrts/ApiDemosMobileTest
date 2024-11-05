package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.LocatorFactory;

import java.io.IOException;
import java.time.Duration;


public class BasePage {
    private AndroidDriver driver;
    private LocatorFactory locatorFactory;
    WebDriverWait wait;


    public BasePage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        this.locatorFactory = new LocatorFactory(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
}
