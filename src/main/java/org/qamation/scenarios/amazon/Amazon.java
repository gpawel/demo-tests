package org.qamation.scenarios.amazon;

import org.openqa.selenium.WebDriver;
import org.qamation.web.page.GeneralPage;
import org.qamation.web.page.Page;

public class Amazon {
    WebDriver driver;
    Page page;

    public Amazon(WebDriver driver) {
        this.driver = driver;
        page = new GeneralPage(driver);
    }
}
