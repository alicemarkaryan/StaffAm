package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FilterPageStaff extends BasePageStaffAm{

    String url="/jobs/";
    private String specialistLok="//*[@id='jobs-filter']//*[text()='%s']";
    private String specialistCountLok="//*[@id='jobs-filter']//*[text()='%s']//following-sibling::span";
    private final By jobsListLok=By.xpath ( "//div[@class='web_item_card hs_job_list_item']");
    private By pageLoadLok=By.xpath("//div[@id='hot_jobs_block']");
    @FindBy(xpath = "//*[@class='green_color pull-right jobClearFilter']")
    private WebElement clearFilter;
    JavascriptExecutor js=(JavascriptExecutor) driver;
    private By clearFilterLok=By.xpath("//*[@class='green_color pull-right jobClearFilter']");
    @FindBy(xpath = "//div[@id='main_sidebar']")
            private WebElement scroll;
    DriverWaiter driverWaiter=new DriverWaiter(driver,20);

    public FilterPageStaff(WebDriver driver){
        super(driver);
        wait=new WebDriverWait(driver,20);
    }

    public FilterPageStaff open(){
        driver.get(Base_Url+url);
        return this;
    }

    public WebElement specialistLevelsFunction(String specialistName){
        return StringFormatMethod(specialistLok,specialistName);
    }

    public WebElement specialistLevelCountElem(String specialistName){
        return StringFormatMethod(specialistCountLok,specialistName);
    }


    public void filterClick(String filter){
        driverWaiter.clickableOfElem(pageLoadLok);
        specialistLevelsFunction(filter).click();
    }

    public int jobCountFunc(String specialistLevel) {
        String specialistLevelStr= specialistLevelCountElem(specialistLevel).getText().replaceAll("[^0-9]","");
        int specialistLevelInt=Integer.parseInt(specialistLevelStr);
        System.out.println(specialistLevelInt);
        return specialistLevelInt;
    }

    public int jobsCountsList(){
        List<WebElement> jobsElem =wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(jobsListLok,2));
        int jobsCount=jobsElem.size();
        System.out.println(jobsCount);
        return jobsCount;
    }

    public void clearFilterFun()  {
        driverWaiter.clickableOfElem(clearFilterLok);
        clearFilter.click();
        js.executeScript("arguments[0].scrollIntoView(true);", scroll);
    }






}
