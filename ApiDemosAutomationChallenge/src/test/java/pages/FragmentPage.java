package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

public class FragmentPage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    public By btn_ContextMenu=By.xpath("//android.widget.TextView[@content-desc=\"Context Menu\"]");
    public By btn_HideAndShow=By.xpath("//android.widget.TextView[@content-desc='Hide and Show']");



    public FragmentPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public WebElement get_btn_ContextMenu() {
        return driver.findElement(btn_ContextMenu);
    }
    public WebElement get_btn_HideAndShow() {
        return driver.findElement(btn_HideAndShow);
    }
}
