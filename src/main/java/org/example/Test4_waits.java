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

    static By playerSearchField = By.xpath(".//div[@class='ant-card-body']//input[@data-qa-modifier='player-search']");
    static By loginInputLocator = By.xpath(".//input[@type='email']");
    static By passInputLocator = By.xpath(".//input[@name='passwd']");
    static By submitButton = By.xpath(".//input[@type='submit']");
    static By userBalance = By.cssSelector("tr[data-row-key='balance'] span");

    static String siteUrl = "url";
    static String login = "login";
    static String pass = "pass";
    static String uid = "175598218";

    public static void main(String[] args) {
        driver = new ChromeDriver();

        goToUrl(siteUrl);
        loginToTheSystem();
        maximizeBrowserWindow();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(playerSearchField));

        WebElement searchInputField = driver.findElement(playerSearchField);
        searchInputField.sendKeys(uid);
        log.info("Type test user id into player search field - " + uid);
        searchInputField.sendKeys(Keys.ENTER);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(userBalance));

        //driver.quit();
    }

    private static void loginToTheSystem(){
        //Fill login field
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginInputLocator));

        driver.findElement(loginInputLocator).sendKeys(login);
        log.info("Send auto test user email");
        driver.findElement(loginInputLocator).sendKeys(Keys.ENTER);

        //Fill password field
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(passInputLocator));

        WebElement passInput = driver.findElement(passInputLocator);
        passInput.sendKeys(pass);
        log.info("Send auto test user pass");

        driver.findElement(submitButton).click();
    }

    public static void goToUrl(String siteUrl){
        driver.get(siteUrl);
        log.debug("Switch to url - " + siteUrl);
    }

    private static void maximizeBrowserWindow(){
        driver.manage().window().maximize();
        log.info("Maximize window");
    }
}
