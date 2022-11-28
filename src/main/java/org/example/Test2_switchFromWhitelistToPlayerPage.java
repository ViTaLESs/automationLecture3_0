package org.example;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2_switchFromWhitelistToPlayerPage {

    static String siteUrl = "url";
    static String login = "login";
    static String pass = "pass";

    public static void main(String[] args) {
        Logger log = Logger.getLogger(Test2_switchFromWhitelistToPlayerPage.class);

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

        //TODO:
        //1. Switch to VIP => Whitelist
        driver.findElement(By.xpath(".//li[@data-qa-modifier='vip']")).click();
        log.info("Clicked on VIP menu item");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath(" .//li[@data-qa-modifier='whitelist']")).click();
        log.info("Clicked on 'Whitelist' submenu item");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver.getCurrentUrl().contains("whitelist")) {
            log.info("Switched to 'Whitelist' submenu correctly!");
        } else {
            log.error("Error during switching to 'Whitelist' submenu item!");
        }

        //2. Click on first uid and save it
        WebElement firstUid = driver.findElement(By.xpath(".//tbody[@class='ant-table-tbody']/tr[1]//a"));
        String userUidFromWhitelistPage = firstUid.getText();
        log.info("User first uid on Whitelist page - " + userUidFromWhitelistPage);
        firstUid.click();

        //3. Check switching on Player page
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver.getCurrentUrl().contains(userUidFromWhitelistPage)) {
            log.info("Switched to Player page correctly!");
        } else {
            log.error("Error during switching to Player page - " + userUidFromWhitelistPage);
        }

        //4. Compare uid on Player page and from p.2
        WebElement uidFromPlayerPage = driver.findElement(By.xpath(".//span[@data-qa='User ID']"));
        String userUidFromPlayerPage = uidFromPlayerPage.getText();
        log.info("User uid on Player page - " + userUidFromPlayerPage);

        if (userUidFromWhitelistPage.equals(userUidFromPlayerPage)) {
            log.info("Uid is correct!");
        } else {
            log.error("Uid is incorrect!");
        }

        //driver.quit();
    }
}
