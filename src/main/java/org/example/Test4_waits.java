package org.example;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test4_waits {

    static Logger log = Logger.getLogger(Test4_waits.class);
    static WebDriver driver;

    static String siteUrl = "url";
    static String login = "login";
    static String pass = "pass";


    public static void main(String[] args) {
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginToTheSystem();

        WebElement searchInputField = driver.findElement(By.xpath(".//div[@class='ant-card-body']//input[@data-qa-modifier='player-search']"));
        searchInputField.sendKeys("175598218");
        log.info("Type test user id into player search field - 175598218");
        searchInputField.sendKeys(Keys.ENTER);
    }

    private static void loginToTheSystem(){

        driver.get(siteUrl);
        log.debug("Switch to url - " + siteUrl);

        By loginInputLocator = By.xpath(".//input[@type='email']");

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginInputLocator));

        driver.findElement(loginInputLocator).sendKeys(login);
        log.info("Send auto test user email");
        driver.findElement(loginInputLocator).sendKeys(Keys.ENTER);


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
    }
}
