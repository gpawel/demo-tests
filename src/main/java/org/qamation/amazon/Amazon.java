package org.qamation.amazon;

import org.openqa.selenium.WebDriver;
import org.qamation.navigator.NavigationString;
import org.qamation.navigator.WebPageNavigator;
import org.qamation.utils.FileUtils;
import org.qamation.web.page.GeneralPage;
import org.qamation.web.page.Page;
import org.qamation.webdriver.utils.WebDriverFactory;
import org.qamation.webdriver.utils.WebDriverUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Amazon {
    private static final Logger log = LoggerFactory.getLogger(Amazon.class);

    WebDriver driver;
    Page page;
    WebDriverUtils utils;
    WebPageNavigator webPageNavigator =null;
    Config config;
    long pauseInTests;

    public Amazon(Config config) {
        this.config = config;
        this.driver =
        page = new GeneralPage(driver);
        utils = new WebDriverUtils(driver);
        webPageNavigator = new WebPageNavigator(this.driver);
        pauseInTests =
    }

    public void navigate(String navigation) {
       webPageNavigator.processNavigationString(navigation);
    }

    public  void createWebDrvier() {
        log.info("BaseTest setUp()");
        System.setProperty(WEB_DRIVER_PROPERTY,CHROME_DRIVER);
        FileUtils.loadPropertiesFile(TIME_OUT_PROPERTIES);
        driver = WebDriverFactory.createChromeWebDriver();
    }
}
