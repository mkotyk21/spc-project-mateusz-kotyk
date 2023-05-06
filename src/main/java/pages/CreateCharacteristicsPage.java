package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateCharacteristicsPage extends HomePage {

    public CreateCharacteristicsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#ProjectId")
    private WebElement projectSlc;
    @FindBy(css = "[name='Name']")
    private WebElement nameTxt;
    @FindBy(css = "[name='LowerSpecificationLimit']")
    private WebElement lslTxt;
    @FindBy(css = "[name='UpperSpecificationLimit']")
    private WebElement uslTxt;
    @FindBy(css = "[name='HistogramBinCount']")
    private WebElement hisTxt;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement saveBtn;

    public CreateCharacteristicsPage selectProcess(String processName) {
        new Select(projectSlc).selectByVisibleText(processName);
        return this;
    }

    public CharacteristicsPage addNewCharacteristics(String name, String lsl, String usl, String charBinCount) {
        nameTxt.clear();
        lslTxt.clear();
        uslTxt.clear();
        hisTxt.clear();
        nameTxt.sendKeys(name);
        lslTxt.sendKeys(lsl);
        uslTxt.sendKeys(usl);
        hisTxt.sendKeys(charBinCount);
        saveBtn.click();
        return new CharacteristicsPage(driver);
    }
}
