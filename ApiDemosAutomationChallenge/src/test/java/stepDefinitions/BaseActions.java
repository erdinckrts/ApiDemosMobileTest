package stepDefinitions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;


import java.time.Duration;
import java.util.Arrays;

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
            element.click();
        } catch (NoSuchElementException e) {
            System.out.println("Element bulunamadı: " + e.getMessage());
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
    // Listeden rastgele element bulma
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
    public void searchValueInAlertText(String buttonText, String[][] buttonDatas) {
        //buttonData = getAlertTextAndIndex(); // Dizi verilerini al

        boolean found = false;
        // İki boyutlu dizinin her bir elemanını kontrol et
        for (int i = 0; i < buttonDatas.length; i++) {
            if (buttonDatas[1][i].equalsIgnoreCase(buttonText)) { // İkinci elemanı kontrol et
                System.out.println("Bulundu: \"" + buttonText + "\" - Satır: " + i + ", Sütun: 1");
                found = true;
                break; // Bulunduğunda döngüden çık
            }
        }

        if (!found) {
            System.out.println("Değer bulunamadı: \"" + buttonText + "\"");
        }
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
