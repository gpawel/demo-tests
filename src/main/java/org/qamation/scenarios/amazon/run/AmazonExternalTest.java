package org.qamation.scenarios.amazon.run;

import org.qamation.utils.FileUtils;
import org.qamation.webdriver.utils.WebDriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.*;

public class AmazonExternalTest extends BaseTest {//extends BaseExternalTests {
    public static Logger log = LoggerFactory.getLogger(AmazonExternalTest.class);
    public static final String DATA_PROVIDER_CLASS_NAME = "org.qamation.data.provider.DataProviderExcelAdapter";


    @Parameters({"file_name","file_tab"})
    @BeforeSuite
    private  void setDataFileParameters(@Optional("amazon.xlsx")String fileName, @Optional("0")String fileTab) {
    //private  void setDataFileParameters(String fileName,String fileTab) {
        this.fileName = fileName;
        this.fileTab = fileTab;
        createWebDrvier();
        createWebPage();
        driver.get("https://amazon.ca");
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
                //log.info("Navigation: "+navigationString);
                navigate(navigationString);
            }
            if (toUrl.length() > 0 ) driver.get(toUrl);
        }
        else throw new SkipException("Test "+comment+" skipped");


    }



/*
    @AfterSuite
    public void tearDawnSuite() {
        quitWebDrvier();
    }
*/





}
