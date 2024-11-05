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
    private LocatorFactory locatorFactory;


    public FragmentPage(AndroidDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
        this.locatorFactory = new LocatorFactory(driver);

    }

        public By getAlertDialogButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Alert_Dialog");
        }

        public By getArgumentsButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Arguments");
        }

        public By getContextMenuButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Context_Menu");
        }

        public By getCustomAnimationsButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Custom_Animations");
        }

        public By getDialogButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Dialog");
        }

        public By getDialogOrActivityButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Dialog_or_Activity");
        }

        public By getHideAndShowButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Hide_and_Show");
        }

        public By getLayoutButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Layout");
        }

        public By getListArrayButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_List_Array");
        }

        public By getMenuButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Menu");
        }

        public By getNestingTabsButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Nesting_Tabs");
        }

        public By getReceiveResultButtonr() {
            return locatorFactory.getLocator("fragmentPage", "btn_Receive_Result");
        }

        public By getRetainInstanceButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Retain_Instance");
        }

        public By getStackButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Stack");
        }

        public By getTabsButton() {
            return locatorFactory.getLocator("fragmentPage", "btn_Tabs");
        }


}
