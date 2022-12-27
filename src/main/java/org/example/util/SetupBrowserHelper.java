package org.example.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SetupBrowserHelper {

    private Logger log = Logger.getLogger(SetupBrowserHelper.class);
    private WebDriver driver;

    public SetupBrowserHelper(WebDriver driver){
        this.driver = driver;
    }

    public void goToUrl(String siteUrl){
        driver.get(siteUrl);
        log.debug("Switch to url - " + siteUrl);
    }

    public void maximizeBrowserWindow(){
        driver.manage().window().maximize();
        log.info("Maximize window");
    }

    public void closeBrowser(){
        driver.quit();
        log.info("Close Browser inst.");
    }
}
