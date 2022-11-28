package org.example;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Test3_switchToProfileWindow {

    static String siteUrl = "url";
    static String login = "login";
    static String pass = "pass";

    public static void main(String[] args) {

        Logger log = Logger.getLogger(Test3_switchToProfileWindow.class);

        WebDriver driver = new ChromeDriver();
        driver.get(siteUrl);
        log.debug("Switch to url - " + siteUrl);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement inputPasswordField = driver.findElement(By.xpath(".//input[@type='email']"));
        inputPasswordField.sendKeys(login);
        log.info("Auto test user login to the system");
        log.info("Send auto test user email");
        inputPasswordField.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement passInput = driver.findElement(By.xpath(".//input[@name='passwd']"));
        passInput.sendKeys(pass);
        log.info("Send auto test user pass");

        WebElement buttonNext = driver.findElement(By.xpath(".//input[@type='submit']"));
        buttonNext.click();

        driver.manage().window().maximize();
        log.info("Maximize window");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement searchInputField = driver.findElement(By.xpath(".//div[@class='ant-card-body']//input[@data-qa-modifier='player-search']"));
        searchInputField.sendKeys("175598218");
        log.info("Type test user id into player search field - 175598218");
        searchInputField.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement profileIdLink = driver.findElement(By.xpath(".//tr[@data-row-key='profile_id']//a"));
        String playerInfoWindow = driver.getWindowHandle();

        log.info("WindowHandle -> " + playerInfoWindow);
        profileIdLink.click();

        Set<String> handles = driver.getWindowHandles();

        for (String hnd : handles) {
            if (!hnd.equals(playerInfoWindow))
                driver.switchTo().window(hnd);
        }

        if (driver.getCurrentUrl().contains("/profile")) {
            log.info("Correct switching to profile window" );
        } else {
            log.error("Incorrect switching to profile window!" );
        }

        driver.switchTo().window(playerInfoWindow);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver.getCurrentUrl().contains("/player/")) {
            log.info("Correct switching to player info window" );
        } else {
            log.error("Incorrect switching to player info window!" );
        }
    }
}
