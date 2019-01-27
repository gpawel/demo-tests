package org.qamation.amazon;

import org.openqa.selenium.WebDriver;
import org.qamation.web.page.GeneralPage;
import org.qamation.web.page.Page;
import org.qamation.webdriver.utils.WebDriverUtils;

public class Amazon {
    WebDriver driver;
    Page page;
    WebDriverUtils utils;

    public Amazon(WebDriver driver) {
        this.driver = driver;
        page = new GeneralPage(driver);
        utils = new WebDriverUtils(driver);
    }
}
