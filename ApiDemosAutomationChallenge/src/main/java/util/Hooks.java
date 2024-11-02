package util;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.io.IOException;
import java.util.Properties;

public class Hooks {

    AppiumDriver driver;
    Properties properties;
    @Before
    public void before() throws IOException {

        //Runtime.getRuntime().exec("adb shell am force-stop io.appium.android.apis");
        //Runtime.getRuntime().exec("adb shell monkey -p io.appium.android.apis -c android.intent.category.LAUNCHER 1");

        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        properties = ConfigReader.initialize_Properties();
        driver = DriverFactory.initialize_Driver(browser);
    }


    @After
    public void after() {

        driver.quit();
    }
}