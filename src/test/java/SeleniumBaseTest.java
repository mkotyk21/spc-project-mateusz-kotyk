import com.github.javafaker.Faker;
import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SeleniumBaseTest {
    protected WebDriver driver;
    protected Config config = new Config();
    protected Faker faker = new Faker();

    @BeforeMethod
    public void baseBeforeMethod() {
        System.setProperty("webdriver.chrome.driver", "c:/dev/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(config.getApplicationUrl());
    }

    @AfterMethod
    public void baseAfterMethod() {
        driver.quit();
    }
}
