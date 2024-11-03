package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    static AndroidDriver driver;
    static Properties properties;
    static DesiredCapabilities capabilities;

    public static AndroidDriver initialize_Driver(String browser) {
        properties = ConfigReader.getProperties();
        capabilities = new DesiredCapabilities();
        if (browser.equals("Android")) {
            capabilities.setCapability("appium:platformName", "Android");
            capabilities.setCapability("appium:udid", "emulator-5554");
            capabilities.setCapability("appium:automationName", "UIAutomator2");
            //capabilities.setCapability("appium:noReset", "true");
            capabilities.setCapability("appium:autoGrantPermissions", true);

            //capabilities.setCapability("app", "C:\\Users\\erdin\\Desktop\\ApiDemos.apk");
            capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/src/test/resources/ApiDemos.apk");
            capabilities.setCapability("appium:appPackage", "io.appium.android.apis");
            capabilities.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
        } else if (browser.equals("iOS")) {
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("udid", "");
            capabilities.setCapability("appPackage", "");
            capabilities.setCapability("appActivity", "");
        }
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        //driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
        return getDriver();
    }

    public static AndroidDriver getDriver() {
        return driver;
    }


}