package org.qamation.scenarios.amazon;

import org.openqa.selenium.WebDriver;
import org.qamation.navigator.WebPageNavigator;


public class AmazonLogin extends Amazon implements Runnable {

    public AmazonLogin(WebDriver driver) {
        super(driver);
    }

    public void run() {
        WebPageNavigator navigator = new WebPageNavigator(driver);
        navigator.processNavigationSequience(new String[]{"<@!{xpath=//*[contains(text(),'Hello. Sign in')]}>"},page);
        navigator.processNavigationSequience(new String[] {"gpawel17@email.com {TAB} 1Qazxsw2!"},page);
    }
}
