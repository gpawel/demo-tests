package org.qamation.scenarios.amazon.run;

import org.qamation.data.provider.DataProviderFactory;
import org.qamation.navigator.NavigationString;
import org.qamation.utils.FileUtils;
import org.qamation.webdriver.utils.WebDriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.util.Iterator;

public class AmazonExternalTest extends BasedExternalTests  {//extends BasedExternalTests {
    public static Logger log = LoggerFactory.getLogger(AmazonExternalTest.class);
    public static final String DATA_PROVIDER_CLASS_NAME = "org.qamation.data.provider.DataProviderExcelAdapter";

/*
    @BeforeSuite
    public void beforeSuite() {
        log.info("calling beforeSuite");
        createWebDrvier();
    }

    @BeforeClass
    public void beforeClass() {
        log.info("calling before Class");
        createWebPage();
        driver.get("https://amazon.ca");
    }

*/
    @BeforeSuite
    public void beforeSuite() {
        log.info("calling beforeSuite");

    }

    @BeforeClass
    public void beforeClass() {
        createWebDrvier();
        log.info("calling before Class");

    }


    @Parameters({"file_name","file_tab"})
    @BeforeTest
    private  void setDataFileParameters(@Optional("./testing.xlsx")String fileName, @Optional("1")String fileTab) {
    //private  void setDataFileParameters(String fileName,String fileTab) {
        this.fileName = fileName;
        this.fileTab = fileTab;
    }

    @Test(dataProvider="external" )
    public void testLines(String run,
                          String comment,
                          String navigationString,
                          String locator,
                          String expected,
                          String extract,
                          String script,
                          String toUrl) {

        if (run.equalsIgnoreCase("Y")) {
            log.info("Run: "+run);
            log.info("Comment: "+comment);
            log.info("Navigation: "+navigationString);
            log.info("Locator: "+locator);
            log.info("Expected: "+expected);
            log.info("Extract: "+extract);
            log.info("Script: "+script);
            log.info("Navigate: "+toUrl);
            log.info("=============================");
            if (navigationString.length() >0 ) {
                log.info("Navigation: "+navigationString);
                //navigate(navigationString);
            }
            //if (toUrl.length() > 0 ) driver.get(toUrl);
        }
        else throw new SkipException("Test "+comment+" skipped");


    }

    public static void createWebDrvier() {

        log.info("BasedTest setUp()");
        //System.setProperty(WEB_DRIVER_PROPERTY,CHROME_DRIVER);
        //driver = WebDriverFactory.createChromeWebDriver();
        FileUtils.loadPropertiesFile(TIME_OUT_PROPERTIES);
    }

/*
    @AfterSuite
    public void tearDawnSuite() {
        quitWebDrvier();
    }
*/





}
