package org.qamation.scenarios.amazon.run;

import org.openqa.selenium.WebDriver;
import org.qamation.scenarios.amazon.AmazonLogin;
import org.qamation.scenarios.amazon.AmazonOpen;
import org.qamation.webdriver.utils.WebDriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;

public class AmazonTests {
    private static Logger log = LoggerFactory.getLogger(AmazonTests.class);
    private final String TIME_OUT_PROPERTIES;

    {
        TIME_OUT_PROPERTIES = "/home/pavel/workspace/qamation/documentation/Examples/TIME_OUT.properties";
    }

    private final String SELENIUM_HOME = System.getProperty("user.dir")+"/../Selenium";

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",SELENIUM_HOME+"/ChromeDriver/chromedriver.exe");
        driver = WebDriverFactory.createChromeWebDriver();
        AmazonOpen open = new AmazonOpen(driver);
        open.run();

    }

    @Test
    public void loginToAmazon() {
        try {
            AmazonLogin login = new AmazonLogin(driver);
            login.run();
        }
        catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }
}
