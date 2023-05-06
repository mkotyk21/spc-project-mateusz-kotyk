package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateProcessesPage extends HomePage {
    public CreateProcessesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#Name")
    private WebElement nameTxt;
    @FindBy(css = "#Description")
    private WebElement descriptionTxt;
    @FindBy(css = "#Notes")
    private WebElement notesTxt;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement createBtn;

    public ProcessesPage addingProcess(String name, String description, String notes) {
        nameTxt.sendKeys(name);
        descriptionTxt.sendKeys(description);
        notesTxt.sendKeys(notes);
        createBtn.click();
        return new ProcessesPage(driver);
    }
}

