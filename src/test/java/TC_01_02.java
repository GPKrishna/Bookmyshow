import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;

public class TC_01_02 extends BasePage {

    public TC_01_02(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void searchMovie(String MovieName) throws IOException {
        try {
            click(By.xpath("//img[@alt='MUMBAI']"));
            click(By.id("4"));
            locateElement(By.xpath("//input[@value='']")).sendKeys(MovieName);
            waitFor(By.xpath("//li"));
            Thread.sleep(100);
            if (!(getText(By.xpath("//li")).contains("No Results found"))) {
                click(By.xpath("//li"));
                String NameMovie = getText(By.xpath("//h1[@class='styles__EventHeading-sc-qswwm9-6 dEOMtn']"));
                Assert.assertEquals(NameMovie, MovieName);
                if (NameMovie.contains(MovieName)) {
                    System.out.println("Movie : " + MovieName);
                    Reports.extentTest.log(Status.PASS, "Selected Movie is Correct : " + MovieName);
                    takeScreenshot();
                } else {
                    System.out.println("Incorrect Movie : " + MovieName);
                    Reports.extentTest.log(Status.FAIL, "Selected Movie is Incorrect : " + MovieName);
                    takeScreenshot();
                }
            } else {
                System.out.println("No results found");
                Reports.extentTest.log(Status.PASS, "No Results found");
                takeScreenshot();
            }
        } catch (Exception e) {
            System.out.println(e);
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot();
        }
    }
}
