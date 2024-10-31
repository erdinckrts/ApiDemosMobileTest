package stepDefinitions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;
import util.DriverFactory;
import util.ElementHelper;

import java.time.Duration;

public class ApiDemosStepDefinitions {
    AndroidDriver driver=DriverFactory.getDriver();
    WebDriverWait wait;
    ElementHelper elementHelper;
    private WebElement randomElement; // Sınıf düzeyinde tanımlandı
    HomePage homePage = new HomePage(driver);
    BaseActions baseActions = new BaseActions(driver);
    AppPage appPage =new AppPage(driver);
    ActivityPage activityPage =new ActivityPage(driver);
    CustomTitlePage customTitlePage =new CustomTitlePage(driver);
    AlertDialogPage alertDialogPage=new AlertDialogPage(driver);

    public ApiDemosStepDefinitions(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);

    }
    public ApiDemosStepDefinitions() {

    }
    @And("App > Activity > Custom Title menusune gidilir")
    public void appActivityCustomTitleMenusuneGidilir() {
        baseActions.clickElement(homePage.get_btn_App());
        baseActions.clickElement(appPage.get_btn_Activity());
        baseActions.clickElement(activityPage.get_btn_CustomTitle());
    }
    @Then("left_textBox metni ile left_navigationBar için {string} değeri geldiği görülür:")
    public void left_textboxMetniIleLeft_navigationBarIçinDeğeriGeldiğiGörülür(String expectedText) {
        Assert.assertEquals(customTitlePage.get_textBoxLeft().getText(), expectedText,"default left textBox degeri textBox icin hatali");
        Assert.assertEquals(customTitlePage.get_navigatorBarLeft().getText(), expectedText,"default left textBox degeri navigationBar icin hatali");
    }
    @Then("right_textBox metni ile right_navigationBar için {string} değeri geldiği görülür:")
    public void right_textboxMetniIleRight_navigationBarIçinDeğeriGeldiğiGörülür(String expectedText) {
        Assert.assertEquals(customTitlePage.get_textBoxRight().getText(), expectedText,"default left textBox değeri textBox için hatalı");
        Assert.assertEquals(customTitlePage.get_navigatorBarRight().getText(), expectedText,"default left textBox değeri navigationBar için hatalı");
    }
    @And("Sol textBox alanina {string} yazilir")
    public void solTextBoxAlaninaYazilir(String string) {
        baseActions.sendKeysToElement(customTitlePage.get_textBoxLeft(),string);
    }
    @And("sag textBox alanina {string} yazilir")
    public void sagTextBoxAlaninaYazilir(String string) {
        baseActions.sendKeysToElement(customTitlePage.get_textBoxRight(),string);
    }
    @Then("asagidaki metinlerin guncellendigi kontrol edilir:")
    public void asagidakiMetinlerinGuncellendigiKontrolEdilir() {
    }
    @And("Change Left butonuna tıklanır")
    public void changeLeftButonunaTıklanır() {
        baseActions.clickElement(customTitlePage.btn_changeLeft);
    }
    @And("Change Right butonuna tıklanır")
    public void changeRightButonunaTıklanır() {
        baseActions.clickElement(customTitlePage.btn_changeRight);
    }

    @Given("App > Alert Dialogs > List Dialog menüsüne gidilir")
    public void uygulamaAlertDialogsListDialogMenüsüneGidilir() {
        baseActions.clickElement(homePage.get_btn_App());
        baseActions.clickElement((appPage.get_btn_AlertDialogs()));
    }

    @When("List dialog'dan rastgele bir öğe seçilir")
    public void listDialogDanRastgeleBirÖğeSeçilir() {
        randomElement =baseActions.findRandomElement(alertDialogPage.getElementListInLinearLayout());
        for (WebElement button : alertDialogPage.getElementListInLinearLayout()) {
            System.out.println(button.getText());
        }
        baseActions.clickElement(randomElement);
    }

    @Then("Seçilen öğenin sırası ve adı alert mesajında kontrol edilir")
    public void seçilenÖğeninSırasıVeAdıAlertMesajındaKontrolEdilir() {
        System.out.println("index degeri:"+baseActions.getElementIndexFromList(alertDialogPage.getElementListInLinearLayout(),randomElement));
        //System.out.println(randomElement.getText());
    }
}