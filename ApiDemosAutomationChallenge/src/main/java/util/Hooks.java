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

        //restartApp("io.appium.android.apis");
        //Runtime.getRuntime().exec("adb shell am force-stop io.appium.android.apis");
        //Runtime.getRuntime().exec("adb shell monkey -p io.appium.android.apis -c android.intent.category.LAUNCHER 1");

        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        properties = ConfigReader.initialize_Properties();
        driver = DriverFactory.initialize_Driver(browser);
    }


    @After
    public void after() {
        driver.close();
        driver.quit();
    }
    public void restartApp(String packageName) {
        try {
            // Uygulamayı kapat
            Runtime.getRuntime().exec("adb shell am force-stop " + packageName);
            // Uygulamayı başlat
            Runtime.getRuntime().exec("adb shell monkey -p " + packageName + " -c android.intent.category.LAUNCHER 1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}