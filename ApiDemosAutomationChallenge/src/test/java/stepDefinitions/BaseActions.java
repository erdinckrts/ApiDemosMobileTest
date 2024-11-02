package stepDefinitions;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;


import java.util.*;


import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class BaseActions {
    protected AppiumDriver driver;
    protected WebDriverWait wait;



    public BaseActions(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Varsayılan 10 saniye bekleme süresi
    }
    public void clickElement(By ByElement) {
        try {
            driver.findElement(ByElement).click();
        } catch (NoSuchElementException e) {
            System.out.println("Element bulunamadı: " + e.getMessage());
        }
    }
    /**
     * Belirtilen elemente tıklar.
     * @param element WebElement - Tıklanacak element
     */
    public void clickElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (NoSuchElementException e) {
            System.out.println("Element bulunamadı: " + e.getMessage());
        }
    }
    //kaydır ve tıkla
    // Ekranı kaydırıp elemana tıklayan metod
    public void scrollToElementAndClick(By by) {
        try {
            // Elemanı UiScrollable ile kaydırarak görünür hale getirme
            WebElement element = (WebElement) driver.findElement(
                    new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
                            + ".scrollIntoView(new UiSelector().resourceId(\"" + by.toString() + "\"));"));

            // Elemana tıklama işlemi
            element.click();
        } catch (Exception e) {
            System.out.println("Elemente ulaşılamadı veya tıklanamadı: " + e.getMessage());
        }
    }

    // By.id ile tanımlı elementi bulana kadar kaydırma ve tıklama
    public void sscrollToElementAndClick(By by) {
        boolean isElementFound = false;
        int maxScrollAttempts = 10; // Maksimum kaydırma deneme sayısı
        int scrollAttempts = 0;

        while (!isElementFound && scrollAttempts > maxScrollAttempts) {
            try {
                // By.id ile elementi bulmayı dene
                WebElement element = driver.findElement(by);
                element.click(); // Element bulunduğunda tıkla
                isElementFound = true; // Element bulunduğunda döngüyü sonlandır
            } catch (NoSuchElementException e) {
                // Element yoksa aşağı kaydırma işlemi yap
                scrollAttempts--;
                //scrollDown();
            }
        }

        if (!isElementFound) {
            System.out.println("Element bulunamadı.");
        }
    }


    //bildirim izni
    public void allowtoAlert(){
        try {
            // Alert varsa geçiş yapıp kabul et
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("Alert mesajı kabul edildi.");
        } catch (NoAlertPresentException e) {
            // Alert yoksa devam et
            System.out.println("Alert mesajı bulunamadı, devam ediliyor.");
        }
    }

    /**
     * Belirtilen elemente yazı yazar.
     * @param   - Yazı yazılacak element
     * @param text String - Yazılacak metin
     */
    public void sendKeysToElement(WebElement Element, String text) {
        try {
            Element.clear();
            Element.sendKeys(text);
        } catch (NoSuchElementException e) {
            System.out.println("Element bulunamadı: " + e.getMessage());
        }
    }
    // Element listesinden rastgele element bulma
    public WebElement findRandomElement(List<WebElement> ElementList) {
        if (ElementList != null && !ElementList.isEmpty()) { // Liste boş değilse
            Random random = new Random();
            int randomIndex = random.nextInt(ElementList.size()); // Rastgele bir indeks al
            WebElement returnElement = ElementList.get(randomIndex); // Rastgele butonu al
            return returnElement; // Tıklanan butonu döndür
        } else {
            System.out.println("Hic element bulunamadi."); // Buton yoksa mesaj ver
            return null; // Buton yoksa null döndür
        }
    }
    //verilen elementin eleman listesindeki yerini bulma
    public int getElementIndexFromList(List<WebElement> ElementList, WebElement targetElement) {
        for (int i = 0; i < ElementList.size(); i++) {
            if (ElementList.get(i).equals(targetElement)) {
                return (i+1); //
            }
        }
        return -1; // Element bulunamazsa -1 döndür
    }

    // Belirli bir değeri 2 boyutlu dizide arama
    public int searchValueInAlertText(String buttonText, String[][] buttonDatas) {
        System.out.println("buton uzunlugu "+buttonDatas.length);
        //buttonData = getAlertTextAndIndex(); // Dizi verilerini al
        boolean found = false;
        // İki boyutlu dizinin her bir elemanını kontrol et
        for (int i = 0; i < buttonDatas.length; i++) {
            if (buttonDatas[i][1].equalsIgnoreCase(buttonText)) {
                System.out.println("Bulundu: \"" + buttonText + "\" - index: " + (i+1) );
                found = true;
                return (i+1);
            }
        }
        if (!found) {
            System.out.println("Değer bulunamadı: \"" + buttonText + "\"");
        }
        return 0;
    }

    /**
     * Ekranı yukarı kaydırır.
     */
    public void scrollUp() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        int startX = driver.manage().window().getSize().width / 2;
        int startY = (int) (driver.manage().window().getSize().height * 0.8);
        int endY = (int) (driver.manage().window().getSize().height * 0.2);

            Sequence swipe = new Sequence(finger, 0);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

            driver.perform(Arrays.asList(swipe));


    }

    /**
     * Ekranı aşağı kaydırır.
     */
    public void scrollDown() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        int startX = driver.manage().window().getSize().width / 2;
        int startY = (int) (driver.manage().window().getSize().height * 0.2);
        int endY = (int) (driver.manage().window().getSize().height * 0.8);

        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        driver.perform(Arrays.asList(swipe));
    }
    // Tab'ları sağdan sola sürükle
    public void swipeTabs(WebElement scrollBar, WebElement ellement, AndroidDriver driver) {
        int width = driver.manage().window().getSize().width; // Ekranın genişliği
        int height = driver.manage().window().getSize().height; // Ekranın yüksekliği

        int startX = (int) (width * 0.8); // Başlangıç X koordinatı (sağ)
        int endX = (int) (width * 0.2); // Bitiş X koordinatı (sol)
        int startY = scrollBar.getLocation().getY();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY)); // Başlangıç noktasına git
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg())); // Finger'i aşağı indir
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, startY)); // Sola kaydır
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())); // Finger'i kaldır

        driver.perform(Arrays.asList(swipe)); // Sürükleme işlemini gerçekleştir
    }
    //bulana kadar sağa kaydırma
    public void swipeTabsUntilVisible(WebElement scrollBar, By byelement, AndroidDriver driver) {
        WebElement  element1=driver.findElement(byelement);
        int width = driver.manage().window().getSize().width; // Ekranın genişliği
        int height = driver.manage().window().getSize().height; // Ekranın yüksekliği

        int startX = (int) (width * 0.8); // Başlangıç X koordinatı (sağ)
        int endX = (int) (width * 0.2); // Bitiş X koordinatı (sol)
        int startY = scrollBar.getLocation().getY(); // Kaydırma işlemi için Y koordinatı

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        while (!"TAB 30".equals(element1.getText())) { // Element görünene kadar döngü

            Sequence swipe = new Sequence(finger, 0);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY)); // Başlangıç noktasına git
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg())); // Finger'i aşağı indir
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, startY)); // Sola kaydır
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg())); // Finger'i kaldır

            driver.perform(Arrays.asList(swipe)); // Sürükleme işlemini gerçekleştir
            element1=driver.findElement(byelement) ;
            try {
                Thread.sleep(500); // Her kaydırma sonrası yarım saniye bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Elementin görünür olup olmadığını kontrol eder.
     * @param element WebElement - Görünürlüğü kontrol edilecek element
     * @return boolean - true: görünür, false: görünmez
     */
    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Element bulunamadı: " + e.getMessage());
            return false;
        }
    }
    //Uzun tıklama
    public void longPress(AndroidDriver driver, WebElement element){

        Point location=element.getLocation();
        Dimension size=element.getSize();
        //Point centerOfElement =getCenterOfElement(location,size);
        PointerInput finger1 =new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        Sequence sequence = new Sequence(finger1,1);

        sequence.addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), location.x, location.y));
        sequence.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(new Pause(finger1, Duration.ofSeconds(2)));
        sequence.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));

    }

    /**
     * Belirtilen element görünür hale gelene kadar bekler.
     * @param by By - Görünür hale gelmesi beklenen element
     */
    public void waitForElementVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Belirtilen element görünür olduğunda tıklar.
     * @param by By - Görünür olduğunda tıklanacak element
     */
    public void clickWhenVisible(By by) {
        waitForElementVisible(by);
        driver.findElement(by).click();
    }

    /**
     * Beklenen sonuç ile gerçek sonucu karşılaştırır.
     * @param actual String - Gerçek sonuç
     * @param expected String - Beklenen sonuç
     */
    public void verifyText(String actual, String expected) {
        if (actual.equals(expected)) {
            System.out.println("Doğrulama başarılı: Beklenen = " + expected + ", Gerçek = " + actual);
        } else {
            System.out.println("Doğrulama başarısız: Beklenen = " + expected + ", Gerçek = " + actual);
        }
    }

    /**
     * Bir text değeri ile element bulur ve döndürür.
     * @param text String - Text değeri
     * @return WebElement - Bulunan element
     */
    public WebElement findElementByText(String text) {
        return driver.findElement(By.xpath("//*[contains(@text,'" + text + "')]"));
    }
}
