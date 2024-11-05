package pages;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import util.LocatorFactory;

import java.io.IOException;

public class AppPage {
    private AndroidDriver driver;
    private LocatorFactory locatorFactory;

    // Constructor
    public AppPage(AndroidDriver driver) throws IOException {
        this.driver = driver;
        this.locatorFactory = new LocatorFactory(driver);
    }

    // Action Bar butonunu döndüren metot
    public By getActionBarButton() {
        return locatorFactory.getLocator("appPage", "btn_ActionBar");
    }

    // Activity butonunu döndüren metot
    public By getActivityButton() {
        return locatorFactory.getLocator("appPage", "btn_Activity");
    }

    // Alarm butonunu döndüren metot
    public By getAlarmButton() {
        return locatorFactory.getLocator("appPage", "btn_Alarm");
    }

    // Alert Dialogs butonunu döndüren metot
    public By getAlertDialogsButton() {
        return locatorFactory.getLocator("appPage", "btn_AlertDialogs");
    }

    // Device Admin butonunu döndüren metot
    public By getDeviceAdminButton() {
        return locatorFactory.getLocator("appPage", "btn_DeviceAdmin");
    }

    // Fragment butonunu döndüren metot
    public By getFragmentButton() {
        return locatorFactory.getLocator("appPage", "btn_Fragment");
    }

    // Launcher Shortcuts butonunu döndüren metot
    public By getLauncherShortcutsButton() {
        return locatorFactory.getLocator("appPage", "btn_LauncherShortcuts");
    }

    // Loader butonunu döndüren metot
    public By getLoaderButton() {
        return locatorFactory.getLocator("appPage", "btn_Loader");
    }

    // Menu butonunu döndüren metot
    public By getMenuButton() {
        return locatorFactory.getLocator("appPage", "btn_Menu");
    }

    // Notification butonunu döndüren metot
    public By getNotificationButton() {
        return locatorFactory.getLocator("appPage", "btn_Notification");
    }

    // Search butonunu döndüren metot
    public By getSearchButton() {
        return locatorFactory.getLocator("appPage", "btn_Search");
    }

    // Service butonunu döndüren metot
    public By getServiceButton() {
        return locatorFactory.getLocator("appPage", "btn_Service");
    }

    // Text-To-Speech butonunu döndüren metot
    public By getTextToSpeechButton() {
        return locatorFactory.getLocator("appPage", "btn_TextToSpeech");
    }

    // Voice Recognition butonunu döndüren metot
    public By getVoiceRecognitionButton() {
        return locatorFactory.getLocator("appPage", "btn_VoiceRecognition");
    }
}
