package org.qamation.scenarios.amazon.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestNGListener;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.reporters.DotTestListener;

import java.util.Iterator;

@Listeners({TestTestNGListener.class})
public class TestTestNGsequence  {
    private static Logger log = LoggerFactory.getLogger(TestTestNGsequence.class);
    public static final String DATA_PROVIDER_CLASS_NAME = "org.qamation.data.provider.DataProviderExcelAdapter";
    int sequence=0;
    String fileName;
    String fileTab;

    @Parameters ({"file_name","file_tab"})
    @BeforeSuite(alwaysRun=true)
    public void beforeSuite(@Optional("testing.xlsx")String fileName, @Optional("1") String fileTab) {
        this.fileName = fileName;
        this.fileTab = fileTab;
        log.info("File: "+ this.fileName +" Tab: "+ this.fileTab);
        log.info("beforeSuite: "+ sequence++);
    }

    @AfterSuite(alwaysRun=true)
    public void afterSuite() {
        log.info("afterSuite: "+ sequence++);
    }


    @BeforeClass(alwaysRun=true)
    public void beforeClass() {
        log.info("beforeClass: "+ sequence++);
    }

    @AfterClass(alwaysRun=true)
    public void afterClass() {
        log.info("afterClass: "+ sequence++);
    }

    @BeforeTest(alwaysRun=true)
    public void beforeTest() {
        log.info("beforeTest: "+ sequence++);
    }

    @AfterTest(alwaysRun=true)
    public void afterTest() {
        log.info("afterTest: "+ sequence++);
    }

    @BeforeMethod(alwaysRun=true)
    public void beforeMethod() {
        log.info("beforeMethod: "+ sequence++);
    }

    @AfterMethod(alwaysRun=true)
    public void afterMethod() {
        log.info("afterMethod: "+ sequence++);
    }

    @BeforeGroups(alwaysRun=true)
    public void beforeGroup() {
        log.info("beforeGroups: "+ sequence++);
    }

    @AfterGroups(alwaysRun=true)
    public void afterGroups() {
        log.info("afterGroups: "+ sequence++);
    }

    @DataProvider(name = "external")
    public Iterator<Object[]> getData() {
        org.qamation.data.provider.DataProvider provider = getDataProvider(fileName,fileTab);
        log.info("DataProvider: "+ sequence++);
        return provider.getDataAsIterator();
    }

    @DataProvider(name="test")
    public Object[][] getParameters() {
        log.info("Data Provider test: "+ sequence++);
        return new String[][] {{"1","2"},{"3","4"}};
    }

    @Test(dataProvider="external", groups="test_anatations")
    public void testLines(String run,
                          String comment,
                          String navigationString,
                          String locator,
                          String expected,
                          String extract,
                          String script,
                          String toUrl) {
        log.info("Test: "+ sequence++);
        if (run.equalsIgnoreCase("Y")) {
            log.info("Run: " + run);
            log.info("Comment: " + comment);
            log.info("Navigation: " + navigationString);
            log.info("Locator: " + locator);
            log.info("Expected: " + expected);
            log.info("Extract: " + extract);
            log.info("Script: " + script);
            log.info("Navigate: " + toUrl);
            log.info("=============================");
        }
        else throw new SkipException("Test "+comment+" skipped");
    }

    @Test(dataProvider="test", groups="test_anatations")
    public void testingMethod(String name, String value) {
        log.info("Test: "+ sequence++);
        log.info("name: "+name+" value: "+value);
    }






    private org.qamation.data.provider.DataProvider getDataProvider(String fileName, String fileTab) {
        int tab = Integer.parseInt(fileTab);
        org.qamation.data.provider.DataProvider provider
                = org.qamation.data.provider.DataProviderFactory.createDataProviderInstance(
                DATA_PROVIDER_CLASS_NAME,
                fileName,
                tab);
        return provider;
    }

}
