package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LoginPage {
    protected WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "Email")
    private WebElement emailTxt;
    @FindBy(id = "Password")
    private WebElement passwordTxt;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginBtn;
    @FindBy (css="div.validation-summary-errors>ul>li")
    public List<WebElement> loginErrors;
    @FindBy (css="#Email-error")
    private WebElement emailError;
    @FindBy (xpath = "//a[contains(text(),'Register as a new user')]")
    public WebElement regPage;


    public HomePage submitCorrectLogin(String email, String password){
        emailTxt.clear();
        passwordTxt.clear();
        emailTxt.sendKeys(email);
        passwordTxt.sendKeys(password);
        loginBtn.click();
        return new HomePage(driver);
    }

    public LoginPage submitLoginWithFailure() {
        loginBtn.click();
        return this;
    }

    public LoginPage expectLoginError(String expectedError) {
        boolean errorStatus = loginErrors.stream().anyMatch(e->e.getText().equals(expectedError));
        Assert.assertTrue(errorStatus);
        return this;
    }
    public LoginPage invalidEmail(){
        Assert.assertTrue(emailError.getText().contains("The Email field is not a valid e-mail address"));
        return this;
    }

}
