package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;
    @FindBy(id = "Password")
    private WebElement passwordTxt;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    public HomePage submitCorrectLogin(String email, String password) {
        emailTxt.clear();
        passwordTxt.clear();
        emailTxt.sendKeys(email);
        passwordTxt.sendKeys(password);
        loginBtn.click();
        return new HomePage(driver);
    }

}
