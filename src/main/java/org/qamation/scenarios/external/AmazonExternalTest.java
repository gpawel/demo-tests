package org.qamation.scenarios.external;

import org.qamation.amazon.tests.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.*;

public class AmazonExternalTest extends BaseTest {//extends BaseExternalTests {
    public static Logger log = LoggerFactory.getLogger(AmazonExternalTest.class);


    @BeforeSuite
    private  void setDataFileParameters() {
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
                amazon.navigate(navigationString);
            }
            if (toUrl.length() > 0 ) driver.get(toUrl);
            amazon.userPause();
        }
        else throw new SkipException("Test "+comment+" skipped");



    }



/*
    @AfterSuite
    public void tearDawnSuite() {
        suiteTearDown();
    }
*/





}
