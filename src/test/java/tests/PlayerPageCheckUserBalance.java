package tests;

import org.example.pages.LoginPage;
import org.example.pages.PlayerInfoPage;
import org.example.pages.PlayerSearchArea;
import org.example.util.SetupBrowserHelper;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class PlayerPageCheckUserBalance {

    private WebDriver driver;

    SetupBrowserHelper setupBrowserHelper;

    private final String siteUrl = "url";
    private final String uid = "175598218";

    @BeforeEach
    public void setupBrowser() {
        driver = new ChromeDriver();

        setupBrowserHelper = new SetupBrowserHelper(driver);
        setupBrowserHelper.maximizeBrowserWindow();
        setupBrowserHelper.goToUrl(siteUrl);
    }

    @Test
    public void checkUserBalanceOnPlayerInfoPageTest() {
        new LoginPage(driver).loginToTheSystem();
        new PlayerSearchArea(driver).searchByUid(uid);
        new PlayerInfoPage(driver).checkUserBalance();
    }

    @AfterEach
    public void teardown() {
        setupBrowserHelper.closeBrowser();
    }
}
