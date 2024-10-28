package pages;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

public class HomePage {
    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    By homePage_btn_App=By.xpath("//android.widget.TextView[@text='App']");
    //By homePage_btn_App = By.AndroidUIAutomator("new UiSelector().text(\"Giriş yap\")");
    //WebElement homePage_btn_App =driver.findElement(By.xpath("//android.widget.TextView[@text='App']"));

    public HomePage(AppiumDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public void kategoriTiklama() {
        driver.findElement(homePage_btn_App).click();
        //homePage_btn_App.click();
        //WebElement el1 = (WebElement) driver.findElementByAccessibilityId("App");
        //el1.click();
    }


}
