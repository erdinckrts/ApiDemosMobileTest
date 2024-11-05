package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import util.LocatorFactory;

import java.io.IOException;

public class ContextMenuPage {
    private AndroidDriver driver;
    private LocatorFactory locatorFactory;

    public ContextMenuPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        this.locatorFactory = new LocatorFactory(driver);
    }

    public By getLongPressButton() {
        return locatorFactory.getLocator("contexMenuPage", "btn_Long_Press_Me");
    }

    public By getMenuAButton() {
        return locatorFactory.getLocator("contexMenuPage", "btn_Menu_A");
    }

    public By getMenuBButton() {
        return locatorFactory.getLocator("contexMenuPage", "btn_Menu_B");
    }
}
