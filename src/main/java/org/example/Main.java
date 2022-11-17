package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        WebDriver driver = new ChromeDriver();

        driver.get("https://hof-bong-preprod.playticorp.com/");
        //driver.navigate().to("https://hof-bong-preprod.playticorp.com/");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement inputPasswordField = driver.findElement(By.xpath(".//input[@type='email']"));
        inputPasswordField.sendKeys("bong_test.user@playtika.com");
        inputPasswordField.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement passInput = driver.findElement(By.xpath(".//input[@name='passwd']"));
        passInput.sendKeys("Purn#1983");

        WebElement buttonNext = driver.findElement(By.xpath(".//input[@type='submit']"));
        buttonNext.click();

        //TODO:
        //1. Switch to /player info page
        //2. Search by UIS - 175598218
        //3. Get Balance

        driver.manage().window().maximize();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement searchInputField = driver.findElement(By.xpath(".//input[@data-qa-modifier='player-search']"));
        searchInputField.sendKeys("175598218");
        searchInputField.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement balanceField = driver.findElement(By.cssSelector("tr[data-row-key='balance'] span"));
        String balance = balanceField.getText();

        System.out.println(balance);
        System.out.println("Result -> " + "1,028,527,338.50".equals(balance));

        //driver.quit();
    }

    public void switchToFrame(String inputLocator) {
        //driver.switchTo().frame(driver.findElement(By.xpath(inputLocator)));
        //actions
        //driver.switchTo().defaultContent();
    }

    public void switchWindow(String inputLocator) {
        //String originalWindow = driver.getWindowHandle();
        //button.click(); //=> new window is opened
        //Set<String> handles = driver.getWindowHandles();

        //for (String hnd : handles) {
        //    if (!hnd.equals(originalWindow))
        //        driver.switchTo().window(hnd);
        //}
        //do some actions
        //driver.close();

        //driver.switchTo().window(originalWindow);
    }
}
