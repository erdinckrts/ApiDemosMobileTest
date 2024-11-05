package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;
import util.LocatorFactory;

import java.time.Duration;

public class ViewsPage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    private LocatorFactory locatorFactory;


    public By btn_Tabs=By.xpath("//android.widget.TextView[@content-desc=\"Tabs\"]");


    public ViewsPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
        this.locatorFactory = new LocatorFactory(driver);

    }


    public By getBy_btn_Tabs() {
        return (btn_Tabs);
    }
}
