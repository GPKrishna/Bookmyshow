import DataProviders.DataProvider_Repository;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class BookMyShow {
    private WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws Exception {
        driver = Browser.openBrowser();
    }

    @Test(dataProviderClass = DataProvider_Repository.class, dataProvider = "BothData")
    //Scenario 01 & 02 : Search Movie Positive & Negative Scenario
    public void movieSearch(String MovieName, String ReportSearch)  throws IOException{
        Reports.createTest(ReportSearch);
        TC_01_02 TC01_02 = new TC_01_02(driver);
        TC01_02.searchMovie(MovieName);
    }



    @Test(priority = 2, dataProviderClass = DataProvider_Repository.class, dataProvider = "BothData")
    //Scenario 09: Search Offers-Positive & Negative scenario
    public void searchOffer(String Offer, String ReportOffer) throws IOException {
        Reports.createTest(ReportOffer);
        TC_03_04 TC03_04 = new TC_03_04(driver);
        TC03_04.searchOffer(Offer);
    }

    @Test(priority = 3)
    //Scenario 12 : Validate Menu
    public void validateMenU() throws IOException {
        Reports.createTest("Scenario 12/Validate Menu");
        TC_05 TC05 = new TC_05(driver);
        TC05.menuValidate();
    }


    @AfterMethod
    public void closeBrowser() {
        Browser.closeBrowser(driver);
    }
}
