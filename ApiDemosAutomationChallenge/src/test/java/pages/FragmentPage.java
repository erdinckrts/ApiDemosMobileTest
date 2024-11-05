package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;
import util.LocatorFactory;

import java.time.Duration;

public class FragmentPage {
    AndroidDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;
    public By btn_ContextMenu=By.xpath("//android.widget.TextView[@content-desc=\"Context Menu\"]");
    public By btn_HideAndShow=By.xpath("//android.widget.TextView[@content-desc='Hide and Show']");
    private LocatorFactory locatorFactory;




    public FragmentPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
        this.locatorFactory = new LocatorFactory(driver);

    }

        public By getAlertDialogLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Alert_Dialog");
        }

        public By getArgumentsLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Arguments");
        }

        public By getContextMenuLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Context_Menu");
        }

        public By getCustomAnimationsLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Custom_Animations");
        }

        public By getDialogLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Dialog");
        }

        public By getDialogOrActivityLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Dialog_or_Activity");
        }

        public By getHideAndShowLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Hide_and_Show");
        }

        public By getLayoutLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Layout");
        }

        public By getListArrayLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_List_Array");
        }

        public By getMenuLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Menu");
        }

        public By getNestingTabsLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Nesting_Tabs");
        }

        public By getReceiveResultLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Receive_Result");
        }

        public By getRetainInstanceLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Retain_Instance");
        }

        public By getStackLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Stack");
        }

        public By getTabsLocator() {
            return locatorFactory.getLocator("fragmentPage", "btn_Tabs");
        }


}
