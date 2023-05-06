package pages;

import org.openqa.selenium.By;
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

    String GENERIC_DASHBOARD_NAME="//h2[text()='%s']";

    public DashboardPage assertNameProcessDisplayed(String name){
        String dashbordNameXpath= driver.findElement(By.xpath(String.format(GENERIC_DASHBOARD_NAME,name))).getText();
        Assert.assertEquals(dashbordNameXpath,name);
        return this;
    }
}
