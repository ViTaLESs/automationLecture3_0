package org.example.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlayerSearchArea {

    private Logger log = Logger.getLogger(PlayerSearchArea.class);
    private WebDriver driver;
    private WebDriverWait wait;

    private By playerSearchField = By.xpath(".//div[@class='ant-card-body']//input[@data-qa-modifier='player-search']");


    public PlayerSearchArea(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchByUid(String uid){
        wait.until(ExpectedConditions.visibilityOfElementLocated(playerSearchField));
        WebElement searchInputField = driver.findElement(playerSearchField);
        searchInputField.sendKeys(uid);
        log.info("Type test user id into player search field - " + uid);
        searchInputField.sendKeys(Keys.ENTER);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(userIdOnPlayerInfoPage));
    }
}

