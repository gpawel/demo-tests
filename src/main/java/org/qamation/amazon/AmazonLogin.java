package org.qamation.amazon;

import org.openqa.selenium.WebDriver;
import org.qamation.navigator.WebPageNavigator;


public class AmazonLogin extends Amazon implements Runnable {

    public AmazonLogin(WebDriver driver) {
        super(driver,200);
    }

    public void run() {
        WebPageNavigator navigator = new WebPageNavigator(driver);
        navigator.processNavigationString("<@!{xpath=//*[contains(text(),'Hello. Sign in')]}>");
        navigator.processNavigationString("gpawel17@email.com {TAB} 1Qazxsw2!");
    }
}
