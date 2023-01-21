package org.example.Autotrader.UItests;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test {

    @Before
    public void setUp() {
        String driverPath = "src/test/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
    }


    @org.junit.Test
    public void navigateToAutotrader() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.autotrader.co.uk/");
        String title = "Auto Trader UK - New and Used Cars For Sale";
        Assert.assertEquals(title,driver.getTitle());
        driver.quit();

    }

    @org.junit.Test
    public void bmwSearch() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.autotrader.co.uk/");

        driver.switchTo().frame("sp_message_iframe_687971");
        WebElement noticeDiv = driver.findElement(By.id("notice"));
        noticeDiv.findElement(By.xpath("//button[@title='Accept All']")).click();
        driver.switchTo().parentFrame();

        driver.findElement(By.id("postcode")).sendKeys("CR05UW");
        Select distanceDropdown = new Select(driver.findElement(By.id("distance")));
        distanceDropdown.selectByValue("1");
        Select makeDropdown = new Select(driver.findElement(By.id("make")));
        makeDropdown.selectByValue("BMW");
        Select modelDropdown = new Select(driver.findElement(By.id("model")));
        modelDropdown.selectByValue("3 Series");
        driver.findElement(By.className("atds-hero__search-button")).click();
        driver.quit();

    }



}
