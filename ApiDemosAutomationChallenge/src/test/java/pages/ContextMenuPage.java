package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

public class ContextMenuPage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    public By btn_LongPressMe=By.xpath("//android.widget.Button[@content-desc=\"Long press me\"]");
    public By btn_A=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
    public By btn_B=By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");


    public ContextMenuPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }
    public WebElement get_btn_LongPressMe() {
        return driver.findElement(btn_LongPressMe);
    }

    public WebElement get_btn_A() {
        return driver.findElement(btn_A);
    }


    public WebElement get_btn_B() {
        return driver.findElement(btn_B);
    }

}
