package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SwitchToFrameAndWindowExample {

    WebDriver driver = new ChromeDriver();

    public void switchToFrame(String inputLocator) {
        driver.switchTo().frame(driver.findElement(By.xpath(inputLocator)));
        //do some actions
        driver.switchTo().defaultContent();
    }

    public void switchWindow(String inputLocator) {
        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("someLinkLocator")).click(); //=> new window is opened
        Set<String> handles = driver.getWindowHandles();

        for (String hnd : handles) {
            if (!hnd.equals(originalWindow))
                driver.switchTo().window(hnd);
        }
        //do some actions

        driver.switchTo().window(originalWindow);
    }
}
