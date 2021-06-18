package pages;
import org.testng.annotations.DataProvider;


public class DataProviders {


    @org.testng.annotations.DataProvider
    public static Object[][] getTestParameters() {
        return new Object[][]{
                {"Senior", "Quality Assurance /Control"},
                {"Quality Assurance /Control", "Full time"},
                {"Full time", "Permanent"}
        };
    }
}