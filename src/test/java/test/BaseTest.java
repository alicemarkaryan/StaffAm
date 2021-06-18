package test;

import DriverSetter.DriverSetter;
import UrlSetter.UrlSetter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.FilterPageStaff;

public class BaseTest {
   private WebDriver driver;
   protected int maxSizeList = 100;
    FilterPageStaff page;
    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void BeforeSuit() {
        UrlSetter.setUrl();
    }

    @BeforeClass
    public void BeforeClass() {
        DriverSetter.setDriver();
        driver = DriverSetter.getDriver();
        driver.manage().window().maximize();
        page = new FilterPageStaff(driver).open();

    }
    @AfterMethod
    public void AfterMethod() {
        softAssert.assertAll();
        page.clearFilterFun();
    }


    @AfterClass
    public void AfterClass() {
        driver.quit();
    }
}
