package org.qamation.scenarios.amazon.run;

import org.openqa.selenium.WebDriver;
import org.qamation.utils.FileUtils;
import org.qamation.webdriver.utils.WebDriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BasedTest {
    private static Logger log = LoggerFactory.getLogger(BasedTest.class);
    protected final String SELENIUM_HOME = System.getProperty("user.dir")+"/../Selenium";
    protected final String CHROME_DRIVER = SELENIUM_HOME+"/ChromeDriver/chromedriver.exe";
    protected final String TIME_OUT_PROPERTIES = System.getProperty("user.dir")+"/resources/TIME_OUT.properties";
    protected final String WEB_DRIVER_PROPERTY = "webdriver.chrome.driver";

    protected WebDriver driver;



    public void createWebDrvier() {
        log.info("BasedTest setUp()");
        System.setProperty(WEB_DRIVER_PROPERTY,CHROME_DRIVER);
        driver = WebDriverFactory.createChromeWebDriver();
        FileUtils.loadPropertiesFile(TIME_OUT_PROPERTIES);
    }

    public void quitWebDrvier() {
        driver.quit();
    }



}
