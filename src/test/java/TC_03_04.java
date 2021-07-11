import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class TC_03_04 extends BasePage {

    public TC_03_04(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void searchOffer(String offer) throws IOException {
        try {
            click(By.xpath("//img[@alt='MUMBAI']"));
            click(By.linkText("Offers"));
            Assert.assertEquals(driver.getCurrentUrl(),"https://in.bookmyshow.com/offers");
            locateElement(By.id("ajax-typeahead")).sendKeys(offer + Keys.RETURN);
            List<WebElement> menu = driver.findElements(By.className("__description"));
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
            int index = 0, num = 0;
            for (int k = 0; k < menu.size(); k++) {
                if (menu.get(k).isDisplayed()) {
                    num++;
                    index = k;
                }
            }
            if (num > 0) {
                if (((menu.get(index).getText()).toLowerCase()).contains(offer.toLowerCase())) {
                    System.out.println("Offer is present : " + offer);
                    Reports.extentTest.log(Status.PASS, "Offer is present :" + offer);
                    takeScreenshot();

                } else {
                    System.out.println("Offer is not present : " + offer);
                    Reports.extentTest.log(Status.PASS, "Offer is not present :" + offer);
                    takeScreenshot();
                }
            } else {
                System.out.print("Offer is not present : " + offer);
                Reports.extentTest.log(Status.PASS, "Offer is not present" + offer);
                takeScreenshot();
            }
            takeScreenshot();

        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, e);
            takeScreenshot();
        }
    }
}
