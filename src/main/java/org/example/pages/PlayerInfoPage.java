package org.example.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerInfoPage {

    private Logger log = Logger.getLogger(PlayerInfoPage.class);
    private WebDriver driver;
    private WebDriverWait wait;

    private By userIdOnPlayerInfoPage = By.cssSelector("tr[data-row-key='User ID']");
    private By userBalance = By.cssSelector("tr[data-row-key='balance'] span");


    public PlayerInfoPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkUserBalance(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userBalance));

        String actualUserBalance = driver.findElement(userBalance).getText();
        String expectedUserBalance = "11,392,519,547,498.55";

        assertEquals(expectedUserBalance, actualUserBalance, "User balance is incorrect on Player Info page");

        log.info("User balance is correct!");
    }
}
