package org.qamation.amazon;

import org.openqa.selenium.WebDriver;

public class AmazonOpen extends Amazon implements Runnable {

    public AmazonOpen(WebDriver driver) {
        super(driver,200);
    }

    public void run() {
        driver.get("https://amazon.ca");
        page.isReady();
    }
}
