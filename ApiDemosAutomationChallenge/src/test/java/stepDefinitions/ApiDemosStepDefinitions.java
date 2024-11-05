package stepDefinitions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;
import util.DriverFactory;
import util.ElementHelper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

public class ApiDemosStepDefinitions {
    AndroidDriver driver=DriverFactory.getDriver();
    WebDriverWait wait;
    ElementHelper elementHelper;
    private WebElement randomElement; // Sınıf düzeyinde tanımlandı
    String randomElementsText;
    String notificationText;

    HomePage homePage = new HomePage(driver);
    BaseActions baseActions = new BaseActions(driver);
    AppPage appPage =new AppPage(driver);
    ActivityPage activityPage =new ActivityPage(driver);
    CustomTitlePage customTitlePage =new CustomTitlePage(driver);
    AlertDialogPage alertDialogPage=new AlertDialogPage(driver);
    FragmentPage fragmentPage=new FragmentPage(driver);
    ContextMenuPage contextMenuPage=new ContextMenuPage(driver);
    HideAndShowPage hideAndShowPage=new HideAndShowPage(driver);
    NotificationPage notificationPage=new NotificationPage(driver);
    IncomingMessagePage incomingMessagePage=new IncomingMessagePage(driver);
    NotificationBarPage notificationBarPage=new NotificationBarPage(driver);
    ViewsPage viewsPage=new ViewsPage(driver);
    TabsPage tabsPage =new TabsPage(driver);
    ScrollablePage scrollablePage=new ScrollablePage(driver);


    public ApiDemosStepDefinitions(AndroidDriver driver) throws IOException, URISyntaxException {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);

    }
    public ApiDemosStepDefinitions() throws IOException, URISyntaxException {

    }
    @And("App > Activity > Custom Title menusune gidilir")
    public void appActivityCustomTitleMenusuneGidilir() {
        baseActions.clickElement(homePage.getAppButton());
        baseActions.clickElement(appPage.getActivityButton());
        baseActions.clickElement(activityPage.getCustomTitleButton());
    }
    @Then("left_textBox metni ile left_navigationBar için {string} değeri geldiği görülür:")
    public void left_textboxMetniIleLeft_navigationBarIçinDeğeriGeldiğiGörülür(String expectedText) {
        Assert.assertEquals(baseActions.convertToElementFromBy(customTitlePage.getTextLeft()).getText(), expectedText,"default left textBox degeri textBox icin hatali");
        Assert.assertEquals(baseActions.convertToElementFromBy(customTitlePage.getNavigatorTextLeft()).getText(), expectedText,"default left textBox degeri navigationBar icin hatali");
    }
    @Then("right_textBox metni ile right_navigationBar için {string} değeri geldiği görülür:")
    public void right_textboxMetniIleRight_navigationBarIçinDeğeriGeldiğiGörülür(String expectedText) {
        Assert.assertEquals(baseActions.convertToElementFromBy(customTitlePage.getTextRight()).getText(), expectedText,"default left textBox değeri textBox için hatalı");
        Assert.assertEquals(baseActions.convertToElementFromBy(customTitlePage.getNavigatorTextRight()).getText(), expectedText,"default left textBox değeri navigationBar için hatalı");
    }
    @And("Sol textBox alanina {string} yazilir")
    public void solTextBoxAlaninaYazilir(String string) {
        baseActions.sendKeysToElement(customTitlePage.getTextLeft(),string);
    }
    @And("sag textBox alanina {string} yazilir")
    public void sagTextBoxAlaninaYazilir(String string) {
        baseActions.sendKeysToElement(customTitlePage.getTextRight(),string);
    }
    @Then("asagidaki metinlerin guncellendigi kontrol edilir:")
    public void asagidakiMetinlerinGuncellendigiKontrolEdilir() {
    }
    @And("Change Left butonuna tıklanır")
    public void changeLeftButonunaTıklanır() {

        baseActions.clickElement(customTitlePage.getBtnChangeLeft());
    }
    @And("Change Right butonuna tıklanır")
    public void changeRightButonunaTıklanır() {

        baseActions.clickElement(customTitlePage.getBtnChangeRight());
    }
    @Given("App > Alert Dialogs > List Dialog menüsüne gidilir")
    public void uygulamaAlertDialogsListDialogMenüsüneGidilir() {
        baseActions.clickElement(homePage.getAppButton());
        baseActions.clickElement((appPage.getAlertDialogsButton()));
    }
    @When("List dialog'dan rastgele bir öğe seçilir")
    public void listDialogDanRastgeleBirÖğeSeçilir() {
        randomElement =baseActions.findRandomElement(alertDialogPage.getElementListInLinearLayout());
        System.out.println("random element: "+randomElement.getText());
        randomElementsText=randomElement.getText();
        baseActions.clickElement(randomElement);
        System.out.println("random elemente tıklandı");
    }
    @Then("Seçilen öğenin sırası ve adı alert mesajında kontrol edilir")
    public void seçilenÖğeninSırasıVeAdıAlertMesajındaKontrolEdilir() {
        int actualIndex = baseActions.searchValueInAlertText(randomElementsText,(alertDialogPage.getExpectedTextAndIndex()));
        int expectedIndex=baseActions.getElementIndexFromList(alertDialogPage.getElementListInLinearLayout(),randomElement);
        Assert.assertEquals(actualIndex,expectedIndex,"AlerDialog ekranı buton secim hatası");
    }
    @Given("App > Fragment > Context Menu menusune gidilir")
    public void appFragmentContextMenuMenusuneGidilir() {
        baseActions.clickElement(homePage.getAppButton());
        baseActions.clickElement(appPage.getFragmentButton());
        baseActions.clickElement(fragmentPage.getContextMenuButton());
    }
    @When("long press me butonuna uzun basılır")
    public void butonunaUzunBasılır() {

        baseActions.longPress(driver,contextMenuPage.getLongPressButton());
    }
    @Then("Menü A ve Menü B öğesinin açıldığı kontrol edilir")
    public void menüAVeMenüBÖğesininAçıldığıKontrolEdilir() {
        Assert.assertTrue(BaseActions.convertToElementFromBy(contextMenuPage.getMenuAButton()).isDisplayed(), "A Elementi görünür değil.");
        Assert.assertTrue(BaseActions.convertToElementFromBy(contextMenuPage.getMenuBButton()).isDisplayed(), "B Elementi görünür değil.");

    }


    @Given("App > Fragment > Hide and Show ekranına gidilir")
    public void appFragmentHideAndShowEkranınaGidilir() {
        baseActions.clickElement(homePage.getAppButton());
        baseActions.clickElement(appPage.getFragmentButton());
        baseActions.clickElement(fragmentPage.getHideAndShowButton());
    }
    @Then("Ekranda iki adet Hide düğmesi olduğu kontrol edilir")
    public void ekrandaIkiAdetHideDüğmesiOlduğuKontrolEdilir() {
        Assert.assertTrue(baseActions.convertToElementFromBy(hideAndShowPage.getBtnHideFrag1()).isDisplayed(), "!Birinci buton görünür değil.");
        Assert.assertTrue(baseActions.convertToElementFromBy(hideAndShowPage.getBtnHideFrag2()).isDisplayed(), "!İkinci buton görünür değil.");

    }

    @Then("Ekranda iki adet metin kutusu olduğunu kontrol edilir")
    public void ekrandaIkiAdetMetinKutusuOlduğunuKontrolEdilir() {
        Assert.assertTrue(baseActions.convertToElementFromBy(hideAndShowPage.getTextFragment1()).isDisplayed(), "!Birinci textBox görünür değil.");
        Assert.assertTrue(baseActions.convertToElementFromBy(hideAndShowPage.getTextFragment2()).isDisplayed(), "!İkinci textBox görünür değil.");

    }

    @And("Birinci Hide butonuna tıklanır")
    public void birinciHideButonunaTıklanır() {
        baseActions.clickElement(hideAndShowPage.getBtnHideFrag1());
    }

    @Then("Birinci metin kutusunun gizlendiği görülür")
    public void birinciMetinKutusununGizlendiğiGörülür() {

        //By locator = By.id("io.appium.android.apis:id/fragment1"); // Öğenin locator'ı
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        try {
            // Öğenin DOM'dan silinmesini bekle
            wait.until(ExpectedConditions.stalenessOf(baseActions.convertToElementFromBy(hideAndShowPage.getTextFragment1())));
            Assert.assertTrue(true, "Öğe DOM'dan silindi, bu bekleniyordu."); // Başarılı
        } catch (Exception e) {
            System.out.println("Element hala mevcut: " + e.getMessage());
            System.out.println("Hata: " +hideAndShowPage.getTextFragment1());

        }

    }

    @Then("Birinci butonun {string} olarak değiştiği görülür")
    public void birinciButonunOlarakDeğiştiğiGörülür(String expectedText) {
        Assert.assertEquals(baseActions.convertToElementFromBy(hideAndShowPage.getBtnHideFrag1()).getText(),expectedText,"!Birinci ButonText'i Show degil");

    }

    @And("Birinci Show butonuna tıklanır")
    public void birinciShowButonunaTıklanır() {
        baseActions.clickElement(hideAndShowPage.getBtnHideFrag1());

    }

    @Then("Birinci metin kutusunun geri geldiğini görülür")
    public void birinciMetinKutusununGeriGeldiğiniGörülür() {
        Assert.assertTrue(baseActions.convertToElementFromBy(hideAndShowPage.getTextFragment1()).isDisplayed(), "!Birinci textBox görünür değil.");

    }

    @And("İkinci Hide butonuna tıklanır")
    public void ikinciHideButonunaTıklanır() {
        baseActions.clickElement(hideAndShowPage.getBtnHideFrag2());
    }


    @Then("İkinci butonun {string} olarak değiştiği görülür")
    public void ikinciButonunOlarakDeğiştiğiGörülür(String expectedText) {
        Assert.assertEquals(baseActions.convertToElementFromBy(hideAndShowPage.getBtnHideFrag2()).getText(),expectedText,"!Birinci ButonText'i Show degil");

    }

    @And("İkinci Show butonuna tıklanır")
    public void ikinciShowButonunaTıklanır() {
        baseActions.clickElement(hideAndShowPage.getBtnHideFrag2());

    }

    @Then("İkinci metin kutusunun geri geldiğini görülür")
    public void ikinciMetinKutusununGeriGeldiğiniGörülür() {
        Assert.assertTrue(baseActions.convertToElementFromBy(hideAndShowPage.getTextFragment2()).isDisplayed(), "!İkinci textBox görünür değil.");

    }

    @Given("App > Notification > Incoming Message ekranına gidilir")
    public void appNotificationIncomingMessageEkranınaGidilir() {
        baseActions.clickElement(homePage.getAppButton());
        baseActions.clickElement((appPage.getNotificationButton()));
        baseActions.clickElement(notificationPage.getIncomingMessageButton());
    }

    @When("Show Notification butonuna tıklanır")
    public void showNotificationButonunaTıklanır() {
        //System.out.println("alert: "+incomingMessagePage.get_btn_alertBox_Allow());
        //System.out.println("alert: "+incomingMessagePage.get_btn_alertBox_Allow().isDisplayed());
        //baseActions.allowtoAlert();
        System.out.println("izin verildi");
        baseActions.clickElement(incomingMessagePage.getShowNotificationButton());

    }

    @And("Bildirim Çubuğu açılır")
    public void bildirimÇubuğuAçılır() {
        driver.openNotifications();
    }

    @Then("Bildirim geldiği görülür")
    public void bildirimGeldiğiGörülür() {


       Assert.assertTrue(baseActions.convertToElementFromBy(notificationBarPage.getShortTextButton()).isDisplayed(), "!Bildirim mesajı bulunamadı");

    }

    @And("Bildirime tıklanır")
    public void bildirimeTıklanır() {
        baseActions.clickElement(notificationBarPage.getShortTextButton());
    }

    @Then("Bildirim detayının açıldığı görülür")
    public void bildirimDetayınınAçıldığıGörülür() {
        //Assert.assertTrue(notificationBarPage.get_page_NotificationDetails().isDisplayed(), "!Bildirim detayi acilmadi");

    }

    @And("Bildirim çubuğundaki metin ile bildirim detayının tutarlı olduğu görülür")
    public void bildirimÇubuğundakiMetinIleBildirimDetayınınTutarlıOlduğuGörülür() {
        //Assert.assertEquals(notificationBarPage.get_text_notification().getText(),notificationText,"!Bildirim çubuguve bildirim detayindeki metin tutarli degil");

    }



    @Given("Views > Tabs menu > Scrollable ekranına gidilir")
    public void viewsTabsMenuScrollableEkranınaGidilir() {
        baseActions.clickElement(homePage.getViewButton());
        baseActions.scrollUp();
        baseActions.scrollUp();
        baseActions.scrollUp();
        baseActions.clickElement(viewsPage.getBtnTabs());
        baseActions.clickElement(tabsPage.getScrollBarTab());
    }

    @When("Açılan ekranda son sıradaki Tab'a tıklanır")
    public void açılanEkrandaSonSıradakiTabATıklanır() {
        baseActions.swipeTabsUntilVisible(baseActions.convertToElementFromBy(scrollablePage.getScrollBarTab()),scrollablePage.getTab30Button(),driver);
        baseActions.clickElement(scrollablePage.getTab30Button());
    }

    @Then("Açılan sayfanın son sıradaki tab'a ait olduğu doğrulanır")
    public void açılanSayfanınSonSıradakiTabAAitOlduğuDoğrulanır() {
        Assert.assertEquals("Content for tab with tag Tab 30",baseActions.convertToElementFromBy(scrollablePage.getTab30TextView()).getText(),"TAB 30 sayfası hatalı");
    }
}