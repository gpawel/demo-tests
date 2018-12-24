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
    public static final String DATA_PROVIDER_CLASS_NAME = "org.qamation.data.provider.DataProviderExcelAdapter";
    protected static final String SELENIUM_HOME = System.getProperty("user.dir")+"/../Selenium";
    protected static final String CHROME_DRIVER = SELENIUM_HOME+"/ChromeDriver/chromedriver.exe";
    protected static final String TIME_OUT_PROPERTIES = System.getProperty("user.dir")+"/resources/TIME_OUT.properties";
    protected static final String WEB_DRIVER_PROPERTY = "webdriver.chrome.driver";





    protected static WebDriver driver;





    public void quitWebDrvier() {
        driver.quit();
    }

    protected org.qamation.data.provider.DataProvider getDataProvider(String fileName, String fileTab) {
        int tab = Integer.parseInt(fileTab);
        org.qamation.data.provider.DataProvider provider
                = org.qamation.data.provider.DataProviderFactory.createDataProviderInstance(
                DATA_PROVIDER_CLASS_NAME,
                fileName,
                tab);
        return provider;
    }



}
