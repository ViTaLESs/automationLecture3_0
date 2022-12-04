package firsttests;

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

    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    static By playerSearchField = By.xpath(".//div[@class='ant-card-body']//input[@data-qa-modifier='player-search']");
    static By loginInputLocator = By.xpath(".//input[@type='email']");
    static By passInputLocator = By.xpath(".//input[@name='passwd']");
    static By submitButton = By.xpath(".//input[@type='submit']");
    static By userBalance = By.cssSelector("tr[data-row-key='balance'] span");

    static String siteUrl = "url";
    static String login = "login";
    static String pass = "pass";
    static String uid = "175598218";

/*    @BeforeEach
    void setupBrowser() {
        //DrOp -> incognito
        //driver = new ChromeDriver();
        //clear cash
        //maximizeBrowserWindow();

        //goToUrl(siteUrl);
        //loginToTheSystem();
    }*/

    public static void main() {
        driver = new ChromeDriver();

        goToUrl(siteUrl);
        loginToTheSystem();
        maximizeBrowserWindow();

        wait.until(ExpectedConditions.visibilityOfElementLocated(playerSearchField));
        WebElement searchInputField = driver.findElement(playerSearchField);
        searchInputField.sendKeys(uid);
        log.info("Type test user id into player search field - " + uid);
        searchInputField.sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(userBalance));

        String actualUserBalance = driver.findElement(userBalance).getText();
        String expectedUserBalance = "11,392,519,547,498.55";

        //Add assert

        log.info("User balance is correct!");

        //driver.quit();
    }

/*    @AfterEach
    void teardown() {
        //driver.quit();
    }*/

    //private void checkUserBalance(){}

    private static void loginToTheSystem(){
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

    public static void goToUrl(String siteUrl){
        driver.get(siteUrl);
        log.debug("Switch to url - " + siteUrl);
    }

    private static void maximizeBrowserWindow(){
        driver.manage().window().maximize();
        log.info("Maximize window");
    }
}