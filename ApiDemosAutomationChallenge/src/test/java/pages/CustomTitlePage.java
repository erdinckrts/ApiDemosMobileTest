package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import util.LocatorFactory;

import java.io.IOException;

public class CustomTitlePage {
    private AndroidDriver driver;
    private LocatorFactory locatorFactory;

    public CustomTitlePage(AndroidDriver driver) {
        this.driver = driver;
        this.locatorFactory = new LocatorFactory(driver);
    }

    public By getNavigatorTextLeft() {
        return LocatorFactory.getLocator("customTitlePage", "navigatorText_Left");
    }

    public By getNavigatorTextRight() {
        return LocatorFactory.getLocator("customTitlePage", "navigatorText_Right");
    }

    public By getTextLeft() {
        return LocatorFactory.getLocator("customTitlePage", "text_Left");
    }

    public By getTextRight() {
        return LocatorFactory.getLocator("customTitlePage", "text_Right");
    }

    public By getBtnChangeLeft() {
        return LocatorFactory.getLocator("customTitlePage", "btn_Change_Left");
    }

    public By getBtnChangeRight() {
        return LocatorFactory.getLocator("customTitlePage", "btn_Change_Right");
    }
}
