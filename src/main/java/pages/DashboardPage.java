package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends HomePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    String GENERIC_DASHBOARD_NAME = "//h2[text()='%s']";
    String GENERIC_DASHBOARD_CHARACTERISTIC_NAME = "//p/..//p[contains(text(),'%s')]";

    public DashboardPage expectedDashboardUrl(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
        return this;
    }

    public DashboardPage assertNameProcessIsDisplayed(String name) {
        String dashbordNameXpath = driver.findElement(By.xpath(String.format(GENERIC_DASHBOARD_NAME, name))).getText();
        Assert.assertEquals(dashbordNameXpath, name);
        return this;
    }

    public DashboardPage assertCharacteristicNameIsDisplayed(String name) {
        String dashbordNameXpath = driver.findElement(By.xpath(String.format(GENERIC_DASHBOARD_CHARACTERISTIC_NAME, name))).getText();
        Assert.assertEquals(dashbordNameXpath, name);
        return this;
    }
}
