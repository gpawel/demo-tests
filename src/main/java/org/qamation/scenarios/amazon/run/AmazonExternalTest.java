package org.qamation.scenarios.amazon.run;

import org.qamation.data.provider.DataProviderFactory;
import org.qamation.scenarios.amazon.dataprovider.AmazonDataProviderClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.util.Iterator;

public class AmazonExternalTest {

    public static Logger logger = LoggerFactory.getLogger(AmazonExternalTest.class);

    private String fileName;
    private int fileTab;

    //@Parameters({"file_name","file_tab"})
    @BeforeTest
    public void dataProviderParameters() {//(String fName, String tab) {
        fileName = "/home/pavel/workspace/qamation/documentation/Examples/WebNavigation/amazon.xlsx"; //fName;
        //fileTab = Integer.parseInt(tab);
        fileTab = Integer.parseInt("0");
    }

    @DataProvider (name = "external")
    public Iterator<Object[]> getData() {
        org.qamation.data.provider.DataProvider provider = DataProviderFactory.createDataProviderInstance(AmazonDataProviderClass.DATA_PROVIDER_CLASS_NAME,fileName,fileTab);
        return provider.getDataAsIterator();
    }

    @Test(dataProvider="external")
    public void testLines(String run,
                          String comment,
                          String navigation,
                          String locator,
                          String expected,
                          String extract,
                          String script,
                          String navigate) {
        logger.info("Run: "+run);
        logger.info("Comment: "+comment);
        logger.info("Navigation: "+navigation);
        logger.info("Locator: "+locator);
        logger.info("Expected: "+expected);
        logger.info("Extract: "+extract);
        logger.info("Script: "+script);
        logger.info("Navigate: "+navigate);
        logger.info("=============================");

    }






}
