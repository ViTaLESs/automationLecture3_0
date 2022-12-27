package org.example.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private Logger log = Logger.getLogger(LoginPage.class);
    private WebDriver driver;
    private WebDriverWait wait;

    private By loginInputLocator = By.xpath(".//input[@type='email']");
    private By passInputLocator = By.xpath(".//input[@name='passwd']");
    private By submitButton = By.xpath(".//input[@type='submit']");

    private String login = "login";
    private String pass = "pass";

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loginToTheSystem(){
        //Fill login field
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginInputLocator));

        driver.findElement(loginInputLocator).sendKeys(login);
        log.info("Send auto test user email");
        driver.findElement(loginInputLocator).sendKeys(Keys.ENTER);

        //Fill password field
        wait.until(ExpectedConditions.visibilityOfElementLocated(passInputLocator));

        WebElement passInput = driver.findElement(passInputLocator);
        passInput.sendKeys(pass);
        log.info("Send auto test user pass");

        driver.findElement(submitButton).click();
    }
}
