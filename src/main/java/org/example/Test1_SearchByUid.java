package org.example;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_SearchByUid {

    public static void main(String[] args) {

        Logger log = Logger.getLogger(Test1_SearchByUid.class);
        log.info("Hello world!");

        WebDriver driver = new ChromeDriver();
        String siteUrl = "URL";
        driver.get(siteUrl);
        log.debug("Switch to url - " + siteUrl);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement inputPasswordField = driver.findElement(By.xpath(".//input[@type='email']"));
        inputPasswordField.sendKeys("login");
        log.info("Auto test user login to the system");
        log.info("Send auto test user email");
        inputPasswordField.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement passInput = driver.findElement(By.xpath(".//input[@name='passwd']"));
        passInput.sendKeys("pass");
        log.info("Send auto test user pass");

        WebElement buttonNext = driver.findElement(By.xpath(".//input[@type='submit']"));
        buttonNext.click();

        //TODO:
        //1. Switch to /player info page
        //2. Search by UIS - 175598218
        //3. Get Balance

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

        WebElement balanceField = driver.findElement(By.cssSelector("tr[data-row-key='balance'] span"));
        String balance = balanceField.getText();

        log.info("Get user balance -> " + balance);

        if ("11,392,519,547,498.55".equals(balance)) {
            log.info("User balance is correct!");
        } else {
            log.error("User balance is INCORRECT!!! User balance -> " + balance);
        }

        //driver.quit();
    }
}
