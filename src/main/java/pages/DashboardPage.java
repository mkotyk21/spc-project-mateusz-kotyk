package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends HomePage{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage expectedDashboardUrl(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
        return this;
    }
}
