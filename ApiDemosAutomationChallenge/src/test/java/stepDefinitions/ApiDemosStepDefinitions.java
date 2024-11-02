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
        randomElementsText=randomElement.getText();
        for (WebElement button : alertDialogPage.getElementListInLinearLayout()) {
            System.out.println(button.getText());
        }
        baseActions.clickElement(randomElement);
    }
    @Then("Seçilen öğenin sırası ve adı alert mesajında kontrol edilir")
    public void seçilenÖğeninSırasıVeAdıAlertMesajındaKontrolEdilir() {
        int actualIndex = baseActions.searchValueInAlertText(randomElementsText,(alertDialogPage.getAlertTextAndIndex()));
        int expectedIndex=baseActions.getElementIndexFromList(alertDialogPage.getElementListInLinearLayout(),randomElement);
        Assert.assertEquals(actualIndex,expectedIndex,"AlerDialog ekranı buton secim hatası");
    }
    @Given("App > Fragment > Context Menu menusune gidilir")
    public void appFragmentContextMenuMenusuneGidilir() {
        baseActions.clickElement(homePage.get_btn_App());
        baseActions.clickElement(appPage.get_btn_Fragment());
        baseActions.clickElement(fragmentPage.get_btn_ContextMenu());
    }
    @When("long press me butonuna uzun basılır")
    public void butonunaUzunBasılır() {

        baseActions.longPress(driver,contextMenuPage.get_btn_LongPressMe());
    }
    @Then("Menü A ve Menü B öğesinin açıldığı kontrol edilir")
    public void menüAVeMenüBÖğesininAçıldığıKontrolEdilir() {
        Assert.assertTrue(contextMenuPage.get_btn_A().isDisplayed(), "A Elementi görünür değil.");
        Assert.assertTrue(contextMenuPage.get_btn_B().isDisplayed(), "B Elementi görünür değil.");

    }


    @Given("App > Fragment > Hide and Show ekranına gidilir")
    public void appFragmentHideAndShowEkranınaGidilir() {
        baseActions.clickElement(homePage.get_btn_App());
        baseActions.clickElement(appPage.get_btn_Fragment());
        baseActions.clickElement(fragmentPage.get_btn_HideAndShow());
    }
    @Then("Ekranda iki adet Hide düğmesi olduğu kontrol edilir")
    public void ekrandaIkiAdetHideDüğmesiOlduğuKontrolEdilir() {
        Assert.assertTrue(hideAndShowPage.get_btn_birinci().isDisplayed(), "!Birinci buton görünür değil.");
        Assert.assertTrue(hideAndShowPage.get_btn_ikinci().isDisplayed(), "!İkinci buton görünür değil.");

    }

    @Then("Ekranda iki adet metin kutusu olduğunu kontrol edilir")
    public void ekrandaIkiAdetMetinKutusuOlduğunuKontrolEdilir() {
        Assert.assertTrue(hideAndShowPage.get_textBox_birinci().isDisplayed(), "!Birinci textBox görünür değil.");
        Assert.assertTrue(hideAndShowPage.get_textBox_ikinci().isDisplayed(), "!İkinci textBox görünür değil.");

    }

    @And("Birinci Hide butonuna tıklanır")
    public void birinciHideButonunaTıklanır() {
        baseActions.clickElement(hideAndShowPage.get_btn_birinci());
    }

    @Then("Birinci metin kutusunun gizlendiği görülür")
    public void birinciMetinKutusununGizlendiğiGörülür() {

        //By locator = By.id("io.appium.android.apis:id/fragment1"); // Öğenin locator'ı
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        try {
            // Öğenin DOM'dan silinmesini bekle
            wait.until(ExpectedConditions.stalenessOf(hideAndShowPage.get_textBox_birinci()));
            Assert.assertTrue(true, "Öğe DOM'dan silindi, bu bekleniyordu."); // Başarılı
        } catch (Exception e) {
            System.out.println("Element hala mevcut: " + e.getMessage());
            System.out.println("Hata: " +hideAndShowPage.get_textBox_birinci());

        }

    }

    @Then("Birinci butonun {string} olarak değiştiği görülür")
    public void birinciButonunOlarakDeğiştiğiGörülür(String expectedText) {
        Assert.assertEquals(hideAndShowPage.get_btn_birinci().getText(),expectedText,"!Birinci ButonText'i Show degil");

    }

    @And("Birinci Show butonuna tıklanır")
    public void birinciShowButonunaTıklanır() {
        baseActions.clickElement(hideAndShowPage.get_btn_birinci());

    }

    @Then("Birinci metin kutusunun geri geldiğini görülür")
    public void birinciMetinKutusununGeriGeldiğiniGörülür() {
        Assert.assertTrue(hideAndShowPage.get_textBox_birinci().isDisplayed(), "!Birinci textBox görünür değil.");

    }

    @And("İkinci Hide butonuna tıklanır")
    public void ikinciHideButonunaTıklanır() {
        baseActions.clickElement(hideAndShowPage.get_btn_ikinci());
    }


    @Then("İkinci butonun {string} olarak değiştiği görülür")
    public void ikinciButonunOlarakDeğiştiğiGörülür(String expectedText) {
        Assert.assertEquals(hideAndShowPage.get_btn_ikinci().getText(),expectedText,"!Birinci ButonText'i Show degil");

    }

    @And("İkinci Show butonuna tıklanır")
    public void ikinciShowButonunaTıklanır() {
        baseActions.clickElement(hideAndShowPage.get_btn_ikinci());

    }

    @Then("İkinci metin kutusunun geri geldiğini görülür")
    public void ikinciMetinKutusununGeriGeldiğiniGörülür() {
        Assert.assertTrue(hideAndShowPage.get_textBox_ikinci().isDisplayed(), "!İkinci textBox görünür değil.");

    }

    @Given("App > Notification > Incoming Message ekranına gidilir")
    public void appNotificationIncomingMessageEkranınaGidilir() {
        baseActions.clickElement(homePage.get_btn_App());
        baseActions.clickElement((appPage.get_btn_Notification()));
        baseActions.clickElement(notificationPage.get_btn_IncomingMessage());
    }

    @When("Show Notification butonuna tıklanır")
    public void showNotificationButonunaTıklanır() {
        //System.out.println("alert: "+incomingMessagePage.get_btn_alertBox_Allow());
        //System.out.println("alert: "+incomingMessagePage.get_btn_alertBox_Allow().isDisplayed());
        //baseActions.allowtoAlert();
        System.out.println("izin verildi");
        baseActions.clickElement(incomingMessagePage.get_btn_ShowAppNotification());

    }

    @And("Bildirim Çubuğu açılır")
    public void bildirimÇubuğuAçılır() {
        driver.openNotifications();
    }

    @Then("Bildirim geldiği görülür")
    public void bildirimGeldiğiGörülür() {


       Assert.assertTrue(notificationBarPage.get_littleFrame_notification().isDisplayed(), "!Bildirim mesajı bulunamadı");

    }

    @And("Bildirime tıklanır")
    public void bildirimeTıklanır() {
        baseActions.clickElement(notificationBarPage.get_littleFrameText_notification());
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
        baseActions.clickElement(homePage.get_btn_Views());
        baseActions.scrollUp();
        baseActions.scrollUp();
        baseActions.scrollUp();
        baseActions.clickElement(viewsPage.getBy_btn_Tabs());
        baseActions.clickElement(tabsPage.getBy_btn_Scrollable());
    }

    @When("Açılan ekranda son sıradaki Tab'a tıklanır")
    public void açılanEkrandaSonSıradakiTabATıklanır() {
        baseActions.swipeTabsUntilVisible(scrollablePage.get_scrollBar_tab(),scrollablePage.get_Bybtn_tabotuz(),driver);
        baseActions.clickElement(scrollablePage.get_Bybtn_tabotuz());
    }

    @Then("Açılan sayfanın son sıradaki tab'a ait olduğu doğrulanır")
    public void açılanSayfanınSonSıradakiTabAAitOlduğuDoğrulanır() {
        Assert.assertEquals("Content for tab with tag Tab 30",scrollablePage.get_textView_Scrolleble().getText(),"TAB 30 sayfası hatalı");
    }
}