package firsttests;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test4_waits {

    private Logger log = Logger.getLogger(Test4_waits.class);
    private WebDriver driver;
    private WebDriverWait wait;

    private By playerSearchField = By.xpath(".//div[@class='ant-card-body']//input[@data-qa-modifier='player-search']");
    private By loginInputLocator = By.xpath(".//input[@type='email']");
    private By passInputLocator = By.xpath(".//input[@name='passwd']");
    private By submitButton = By.xpath(".//input[@type='submit']");
    private By userIdOnPlayerInfoPage = By.cssSelector("tr[data-row-key='User ID']");
    private By userBalance = By.cssSelector("tr[data-row-key='balance'] span");

    private String siteUrl = "url";
    private String login = "login";
    private String pass = "pass";
    private String uid = "175598218";

    @BeforeEach
    public void setupBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        maximizeBrowserWindow();
    }

    @Test
    public void checkUserBalanceOnPlayerInfoPage() {
        goToUrl(siteUrl);
        loginToTheSystem();

        searchByUid(uid);
        checkUserBalance();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    private void searchByUid(String uid){
        wait.until(ExpectedConditions.visibilityOfElementLocated(playerSearchField));
        WebElement searchInputField = driver.findElement(playerSearchField);
        searchInputField.sendKeys(uid);
        log.info("Type test user id into player search field - " + uid);
        searchInputField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(userIdOnPlayerInfoPage));
    }

    private void checkUserBalance(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userBalance));

        String actualUserBalance = driver.findElement(userBalance).getText();
        String expectedUserBalance = "11,392,519,547,498.55";

        assertEquals(expectedUserBalance, actualUserBalance, "User balance is incorrect on Player Info page");

        log.info("User balance is correct!");
    }

    private void loginToTheSystem(){
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

    private void goToUrl(String siteUrl){
        driver.get(siteUrl);
        log.debug("Switch to url - " + siteUrl);
    }

    private void maximizeBrowserWindow(){
        driver.manage().window().maximize();
        log.info("Maximize window");
    }
}
