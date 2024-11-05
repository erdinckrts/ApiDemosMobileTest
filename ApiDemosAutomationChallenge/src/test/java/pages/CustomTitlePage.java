package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.ElementHelper;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import util.LocatorFactory;

import java.time.Duration;

public class CustomTitlePage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    public By textBoxLeft=By.id("io.appium.android.apis:id/left_text_edit");
    public By textBoxRight=By.id("io.appium.android.apis:id/right_text_edit");
    public By navigatorBarLeft=By.id("io.appium.android.apis:id/left_text");
    public By navigatorBarRight=By.id("io.appium.android.apis:id/right_text");
    public By btn_changeLeft=By.id("io.appium.android.apis:id/left_text_button");
    public By btn_changeRight=By.id("io.appium.android.apis:id/right_text_button");
    private LocatorFactory locatorFactory;


    public CustomTitlePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
        this.locatorFactory = new LocatorFactory(driver);

    }

    public WebElement get_textBoxLeft() {
        return driver.findElement(textBoxLeft);
    }
    public WebElement get_textBoxRight() {
        return driver.findElement(textBoxRight);
    }
    public WebElement get_navigatorBarLeft() {
        return driver.findElement(navigatorBarLeft);
    }
    public WebElement get_navigatorBarRight() {
        return driver.findElement(navigatorBarRight);
    }
}
