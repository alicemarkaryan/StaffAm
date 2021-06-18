package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverWaiter {

    private WebDriverWait wait;

     public DriverWaiter(WebDriver driver, int timeout){
          wait=new WebDriverWait(driver,timeout);
     }
     public DriverWaiter visibilityOfElem(By by){
         wait.until(ExpectedConditions.visibilityOfElementLocated(by));
         return this;
     }

     public DriverWaiter clickableOfElem(By by){
         wait.until(ExpectedConditions.elementToBeClickable(by));
         return this;
     }
}
