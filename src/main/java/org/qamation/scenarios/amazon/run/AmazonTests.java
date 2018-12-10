package org.qamation.scenarios.amazon.run;

import org.openqa.selenium.WebDriver;
import org.qamation.scenarios.amazon.AmazonLogin;
import org.qamation.utils.FileUtils;
import org.qamation.webdriver.utils.WebDriverFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;

public class AmazonTests {
    private final String TIME_OUT_PROPERTIES = "/home/pavel/workspace/qamation/documentation/Examples/TIME_OUT.properties";
    private final String SELENIUM_HOME = "/home/pavel/workspace/Selenium";

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        Properties timeOutprops = FileUtils.loadPropertiesFile(TIME_OUT_PROPERTIES);
        System.setProperties(timeOutprops);
        System.setProperty("webdriver.chrome.driver",SELENIUM_HOME+"/Chrome/chromedriver");

    }

    @Test
    public void loginToAmazon() {
        try {
            driver = WebDriverFactory.createChromeWebDriver();
            AmazonLogin login = new AmazonLogin(driver);
            login.run();
        }
        catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
