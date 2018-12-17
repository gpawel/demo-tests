package org.qamation.scenarios.amazon.run;

import org.qamation.data.provider.DataProviderFactory;
import org.qamation.navigator.NavigationString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.util.Iterator;

public class AmazonExternalTest extends BasedExternalTests {
    public static final String DATA_PROVIDER_CLASS_NAME="org.qamation.data.provider.DataProviderExcelAdapter";

    public static Logger log = LoggerFactory.getLogger(AmazonExternalTest.class);

    private String fileName;
    private int fileTab;



    @Parameters({"file_name","file_tab"})
    public AmazonExternalTest(String fName, String tab) {
        fileName = fName;//"/home/pavel/workspace/qamation/documentation/Examples/WebNavigation/amazon.xlsx"; //fName;
        fileTab = Integer.parseInt(tab);
        //fileTab = Integer.parseInt("0");
    }



    @DataProvider (name = "external")
    public Iterator<Object[]> getData() {
        org.qamation.data.provider.DataProvider provider = DataProviderFactory.createDataProviderInstance(DATA_PROVIDER_CLASS_NAME,fileName,fileTab);
        return provider.getDataAsIterator();
    }

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

    @Test(dataProvider="external")
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
            //log.info("Locator: "+locator);
            //log.info("Expected: "+expected);
            log.info("Extract: "+extract);
            log.info("Script: "+script);
            log.info("Navigate: "+toUrl);
            log.info("=============================");
            if (navigationString.length() >0 ) {
                log.info("Navigation: "+navigationString);
                navigate(navigationString);
            }
            if (toUrl.length() > 0 ) driver.get(toUrl);
        }
        else throw new SkipException("Test "+comment+" skipped");


    }

    @AfterSuite
    public void tearDawnSuite() {
        quitWebDrvier();
    }






}
