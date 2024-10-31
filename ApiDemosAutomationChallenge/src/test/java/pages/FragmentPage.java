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
    public By btn_ContextMenu=By.id("00000000-0000-0baf-ffff-ffff0000004c");
    public By btn_HideAndShow=By.id("00000000-0000-0bb2-ffff-ffff0000008d");



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
