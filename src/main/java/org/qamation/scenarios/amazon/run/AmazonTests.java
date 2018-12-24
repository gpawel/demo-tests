package org.qamation.scenarios.amazon.run;

import org.qamation.scenarios.amazon.AmazonLogin;
import org.qamation.scenarios.amazon.AmazonOpen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonTests extends BaseTest {
    private static Logger log = LoggerFactory.getLogger(AmazonTests.class);

    @BeforeClass
    public void setUp() {
        //createWebDrvier();
        AmazonOpen open = new AmazonOpen(driver);
        open.run();
    }



    @Test
    public void loginToAmazon() {
        try {
            AmazonLogin login = new AmazonLogin(driver);
            login.run();
        }
        catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
