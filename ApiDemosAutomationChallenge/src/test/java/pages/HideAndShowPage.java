package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

public class HideAndShowPage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public By btn_birinci=By.id("io.appium.android.apis:id/frag1hide");
    public By btn_ikinci=By.id("io.appium.android.apis:id/frag2hide");
    public By textBox_birinci=By.id("io.appium.android.apis:id/fragment1");
    public By textBox_ikinci=By.xpath("(//android.widget.EditText[@content-desc=\"Initial text.\"])[2]");




    public HideAndShowPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }


    public WebElement get_btn_birinci() {
        return driver.findElement(btn_birinci);
    }
    public WebElement get_btn_ikinci() {

        return driver.findElement(btn_ikinci);
    }
    public WebElement get_textBox_birinci() {
       WebElement element;
        /*try {
            element = driver.findElement(By.id("io.appium.android.apis:id/fragment1"));
            // Burada öğe ile bir işlem yapın
            return element;
        } catch (StaleElementReferenceException e) {
            // Hata durumunda öğeyi yeniden bul
            element = driver.findElement(By.id("io.appium.android.apis:id/fragment1"));
            return element;
        }*/
        return driver.findElement((textBox_birinci));
    }
    public WebElement get_textBox_ikinci() {
        return driver.findElement(textBox_ikinci);
    }


}
