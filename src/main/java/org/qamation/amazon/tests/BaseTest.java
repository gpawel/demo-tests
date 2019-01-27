package org.qamation.amazon.tests;

import org.openqa.selenium.WebDriver;
import org.qamation.navigator.NavigationString;
import org.qamation.navigator.WebPageNavigator;
import org.qamation.utils.FileUtils;
import org.qamation.web.page.GeneralPage;
import org.qamation.web.page.Page;
import org.qamation.webdriver.utils.WebDriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class BaseTest {
    private static Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected  final String DATA_PROVIDER_CLASS_NAME = "org.qamation.data.provider.DataProviderExcelAdapter";
    protected  final String SELENIUM_HOME = System.getProperty("user.dir")+"/../Selenium";
    protected  final String CHROME_DRIVER = SELENIUM_HOME+"/ChromeDriver/chromedriver.exe";
    protected  final String TIME_OUT_PROPERTIES = System.getProperty("user.dir")+"/resources/TIME_OUT.properties";
    protected  final String WEB_DRIVER_PROPERTY = "webdriver.chrome.driver";
    protected  final String NAVIGATION_DELIMITER = "\\|";

    protected WebDriver driver;
    protected WebPageNavigator webPageNavigator =null;
    protected Page page = null;

    protected String fileName;
    protected String fileTab;



    @DataProvider(name = "external")
    public Iterator<Object[]> getData() {
        org.qamation.data.provider.DataProvider provider = getDataProvider(fileName,fileTab);
        return provider.getDataAsIterator();
    }


    public void createWebPage() {
        log.info("BaseExternalTests setUp()");
        webPageNavigator = new WebPageNavigator(driver);
        page = new GeneralPage(driver);
    }



    public void navigate(String navigation) {
        NavigationString navigationString = new NavigationString(navigation,NAVIGATION_DELIMITER);
        String[] seq = navigationString.getNavigationSequence();
        webPageNavigator.processNavigationSequience(seq,page);
    }


    public  void createWebDrvier() {
        log.info("BaseTest setUp()");
        System.setProperty(WEB_DRIVER_PROPERTY,CHROME_DRIVER);
        FileUtils.loadPropertiesFile(TIME_OUT_PROPERTIES);
        driver = WebDriverFactory.createChromeWebDriver();
    }


    public void quitWebDrvier() {
        driver.quit();
    }

    public org.qamation.data.provider.DataProvider getDataProvider(String fileName, String fileTab) {
        int tab = Integer.parseInt(fileTab);
        org.qamation.data.provider.DataProvider provider
                = org.qamation.data.provider.DataProviderFactory.createDataProviderInstance(
                DATA_PROVIDER_CLASS_NAME,
                fileName,
                tab);
        return provider;
    }




}
