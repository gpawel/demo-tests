package org.qamation.amazon.tests;

import org.openqa.selenium.WebDriver;
import org.qamation.amazon.Amazon;
import org.qamation.amazon.Config;
import org.qamation.webdriver.utils.WebDriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class BaseTest {
    private static Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected  final String DATA_PROVIDER_CLASS_NAME = "org.qamation.data.provider.DataProviderExcelAdapter";
    protected  final String WEB_DRIVER_PROPERTY = "webdriver.chrome.driver";


    protected String driverPath;

    protected WebDriver driver = null;

    protected String dataFileName;
    protected String dataFileTab;
    protected int howMany;

    protected String resourcesRoot;
    protected Config config;


    protected Amazon amazon;


    @BeforeSuite
    public void setUpSuite() {
        resourcesRoot = System.getProperty("ROOT");
        if (resourcesRoot == null) resourcesRoot = System.getProperty("user.dir")+"/resources";
        config = Config.getConfig(resourcesRoot +"/etc");
        driverPath = resourcesRoot +"/ChromeDriver/chromedriver.exe";
        driver = createWebDrvier(driverPath);
        String fileName= System.getProperty("DATA.FILE.NAME");
        String tabNumber=System.getProperty("DATA.FILE.TAB");
        setDataFileName(fileName);
        setDataFileTab(tabNumber);
        howMany=Integer.parseInt(System.getProperty("HOW.MANY.ITERATIONS"));
        long pauseTest = Long.parseLong(System.getProperty("PAUSE_IN_TEST","100"));
        amazon = new Amazon(driver,pauseTest);
    }

    @AfterSuite
    public void suiteTearDown() {
        boolean killDriver = Boolean.getBoolean("KILL.WEBDRIVER");
        if (killDriver && driver!=null)  driver.quit();
    }

    public  WebDriver createWebDrvier(String driverPath) {
        log.info("BaseTest setUp()");
        System.setProperty(WEB_DRIVER_PROPERTY,driverPath);
        return WebDriverFactory.createChromeWebDriver();
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

    protected void setDataFileName(String fileName) {
        if (fileName == null || fileName.isEmpty()) throw new TestException("File name is invalid");
        this.dataFileName = resourcesRoot +"/data/"+fileName;
    }

    protected String getDataFileName() {
        return this.dataFileName;
    }

    protected void setDataFileTab(String fileTab) {
        this.dataFileTab = fileTab;
    }

    protected String getDataFileTab() {
        return this.dataFileTab;
    }

    @DataProvider(name = "iterator")
    public Object[][] setIterations() {
        Object[][] iteration = new Object[howMany][1];
        for (int i=0; i<howMany; i++) {
            iteration[i] = new Object[] {new Integer(i)};
        }
        return iteration;
    }

    @DataProvider(name = "external")
    public Iterator<Object[]> getData() {
        if (getDataFileTab().isEmpty() || getDataFileName().isEmpty()) {
            throw new RuntimeException("External data parameters are not provided.");
        }

        org.qamation.data.provider.DataProvider externalDataProvider = getDataProvider(getDataFileName(),getDataFileTab());
        return externalDataProvider.getDataAsIterator();
    }




}
