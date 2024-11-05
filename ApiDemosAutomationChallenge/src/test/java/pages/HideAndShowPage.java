package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;
import util.LocatorFactory;

import java.time.Duration;

public class HideAndShowPage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    private LocatorFactory locatorFactory;


    public HideAndShowPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
        this.locatorFactory = new LocatorFactory(driver);

    }
    public By getBtnHideFrag1() {
        return locatorFactory.getLocator("hideAndShowPage", "btn_Hide_Frag1");
    }

    // Hide Fragment 2 button elementini döner
    public By getBtnHideFrag2() {
        return locatorFactory.getLocator("hideAndShowPage", "btn_Hide_Frag2");
    }

    // Fragment 1 text elementini döner
    public By getTextFragment1() {
        return locatorFactory.getLocator("hideAndShowPage", "text_Fragment_1");
    }

    // Fragment 2 text elementini döner
    public By getTextFragment2() {
        return locatorFactory.getLocator("hideAndShowPage", "text_Fragment_2");
    }


}
