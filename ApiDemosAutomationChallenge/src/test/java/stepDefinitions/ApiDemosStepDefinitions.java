package stepDefinitions;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import util.DriverFactory;
import util.ElementHelper;

import java.time.Duration;

public class ApiDemosStepDefinitions {
    AppiumDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public ApiDemosStepDefinitions(AppiumDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);

    }

    public ApiDemosStepDefinitions() {

    }


    @And("App > Activity > Custom Title menüsüne gidilir")
    public void menüsüneGidilir(String arg0) {
        System.out.println("OLDU");

        //HomePage.kategoriTiklama(HomePage.homePage_btn_App);

    }

    @And("App > Activity > Custom Title menusune gidilir")
    public void appActivityCustomTitleMenusuneGidilir() {
        System.out.println("OLDU");
        //WebElement homePage_btn_App =driver.findElement(By.xpath("//android.widget.TextView[@text='App']"));
        //homePage_btn_App.click();
        //HomePage.kategoriTiklama();

    }

    @Then("acilan aktivitede asagidaki metinlerin varsayilan degerleri kontrol edilir:")
    public void acilanAktivitedeAsagidakiMetinlerinVarsayilanDegerleriKontrolEdilir() {
    }

    @And("Sol textBox alanina {string} yazilir")
    public void solTextBoxAlaninaYazilir(String arg0) {
    }

    @And("sag textBox alanina {string} yazilir")
    public void sagTextBoxAlaninaYazilir(String arg0) {
    }

    @Then("asagidaki metinlerin guncellendigi kontrol edilir:")
    public void asagidakiMetinlerinGuncellendigiKontrolEdilir() {
    }
}
