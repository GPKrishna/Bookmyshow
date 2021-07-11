import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    public static WebDriver openBrowser() throws Exception {
        WebDriver driver;
        String baseDirectory = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", baseDirectory + "/src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://in.bookmyshow.com/");
        return driver;
    }

    public static void closeBrowser(WebDriver driver) {
        driver.quit();
    }
}
