package test;

import DriverSetter.DriverSetter;
import UrlSetter.UrlSetter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.DataProviders;
import pages.FilterPageStaff;

public class StaffAmTest extends BaseTest {

    @Test(dataProvider = "getTestParameters", dataProviderClass = DataProviders.class)
    public void jobSearchResultCategory(String filter1, String filter2)  {

        page.filterClick(filter1);
        if (page.jobCountFunc(filter1) < maxSizeList) {
            softAssert.assertEquals(page.jobCountFunc(filter1), page.jobsCountsList());
        } else {
            softAssert.assertEquals(page.jobsCountsList(), maxSizeList);
        }
        page.filterClick(filter2);
        if (page.jobCountFunc(filter2) < maxSizeList) {
            softAssert.assertEquals(page.jobCountFunc(filter2), page.jobsCountsList());
        } else {
            softAssert.assertEquals(page.jobsCountsList(), maxSizeList);
        }

    }

}
