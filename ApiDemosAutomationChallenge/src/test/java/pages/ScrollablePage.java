package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

public class ScrollablePage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public By scrollBar_tab=By.id("android:id/tabs");
    public By btn_tabotuz=By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.TabHost/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.TabWidget/android.widget.LinearLayout[5]/android.widget.TextView");
    public By textView_Scrolleble=By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.TabHost/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");



    public ScrollablePage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }


    public WebElement get_scrollBar_tab() {
        return driver.findElement(scrollBar_tab);
    }
    public By get_Bybtn_tabotuz() {
        return (btn_tabotuz);
    }
    public WebElement get_textView_Scrolleble() {
        return driver.findElement(textView_Scrolleble);
    }
}
