package org.qamation.scenarios.amazon.run;

import org.qamation.navigator.NavigationString;
import org.qamation.navigator.WebPageNavigator;
import org.qamation.web.page.GeneralPage;
import org.qamation.web.page.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.util.Iterator;

public class BasedExternalTests extends BasedTest {
    protected static final Logger log = LoggerFactory.getLogger(BasedExternalTests.class);
    public static final String DATA_PROVIDER_CLASS_NAME="org.qamation.data.provider.DataProviderExcelAdapter";

    protected static final String NAVIGATION_DELIMITER = "\\|";

    protected WebPageNavigator webPageNavigator =null;
    protected Page page = null;

    protected String fileName;
    protected String fileTab;



    @DataProvider(name = "external")
    public  Iterator<Object[]> getData() {
        org.qamation.data.provider.DataProvider provider = getDataProvider(fileName,fileTab);
        return provider.getDataAsIterator();
    }


    public void createWebPage() {
        log.info("BasedExternalTests setUp()");
        webPageNavigator = new WebPageNavigator(driver);
        page = new GeneralPage(driver);
    }



    public void navigate(String navigation) {
        NavigationString navigationString = new NavigationString(navigation,NAVIGATION_DELIMITER);
        String[] seq = navigationString.getNavigationSequence();
        webPageNavigator.processNavigationSequience(seq,page);
    }



}
