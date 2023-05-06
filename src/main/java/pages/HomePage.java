package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".profile_info>h2")
    private WebElement welcomeText;

    public HomePage assertCorectLogin() {
        Assert.assertTrue(welcomeText.isDisplayed());
        Assert.assertTrue(welcomeText.getText().contains("Welcome"));
        return this;
    }


}
