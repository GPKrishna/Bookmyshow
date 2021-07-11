import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC_05 extends BasePage {

    public TC_05(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void menuValidate() throws IOException {
        try {
            Assert.assertEquals(driver.getCurrentUrl(), "https://in.bookmyshow.com/");
            click(By.xpath("//img[@alt='MUMBAI']"));
            List<String> validate = Arrays.asList("Movies", "Stream", "Events", "Plays", "Sports", "Activities", "Fanhood", "Buzz");
            List<WebElement> menu = driver.findElements(By.xpath("//a[@class='sc-bmyXtO WORWN']"));
            int num = 0;
            for (WebElement webElement : menu) {
                String text_menu = webElement.getText();
                text_menu = text_menu.replace("NEW", "");
                text_menu = text_menu.replaceAll("\\s", "");
                if (validate.contains(text_menu)) {
                    System.out.println(text_menu);
                    Reports.extentTest.log(Status.INFO, text_menu);
                    num++;
                }
            }
            if (num == 7) {
                System.out.println("Correct number of Menu");
                Reports.extentTest.log(Status.PASS, "Correct number of Menu");
                takeScreenshot();
            } else {
                System.out.println("Incorrect number of Menu");
                Reports.extentTest.log(Status.FAIL, "Incorrect number of Menu");
                takeScreenshot();

            }
        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot();
        }
    }
}
