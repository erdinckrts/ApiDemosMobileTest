package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;
import util.LocatorFactory;

import java.time.Duration;

public class ScrollablePage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    private LocatorFactory locatorFactory;



    public ScrollablePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
        this.locatorFactory = new LocatorFactory(driver);

    }

    public By getScrollBarTab() {
        return locatorFactory.getLocator("scrollablePage", "scrollBar_tab");
    }

    public By getTab30Button() {
        return locatorFactory.getLocator("scrollablePage", "btn_Tab_30");
    }

    public By getTab30TextView() {
        return locatorFactory.getLocator("scrollablePage", "btn_Tab_30_Content");
    }
}
