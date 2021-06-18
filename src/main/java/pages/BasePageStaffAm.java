package pages;

import UrlSetter.UrlSetter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageStaffAm {

   protected WebDriver driver;
   protected WebDriverWait wait;

   protected  String Base_Url= UrlSetter.getUrl();

   public BasePageStaffAm(WebDriver driver){
       this.driver=driver;
       PageFactory.initElements(driver,this);
   }

    public WebElement StringFormatMethod(String a, String b){
        String actual=String.format(a,b);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(actual)));
    }

}

