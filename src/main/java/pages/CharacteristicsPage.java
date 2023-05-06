package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CharacteristicsPage extends HomePage {
    public CharacteristicsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[contains(text(),'Add new characteristic')]")
    private WebElement addBtn;

    private String GENERIC_CHARACTERISTIC_ROW_XPATH = "//td[text()='%s']/..";


    public CharacteristicsPage expectedCharacteristicsUrl(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
        return this;
    }

    public CreateCharacteristicsPage goToCreateNewCharacteristics() {
        addBtn.click();
        return new CreateCharacteristicsPage(driver);
    }
    public CharacteristicsPage assertCharacteristic(String expName, String expLsl, String expUsl, String expBinCount) {
        String characteristicXpath = String.format(GENERIC_CHARACTERISTIC_ROW_XPATH, expName);
        WebElement characteristicRow = driver.findElement(By.xpath(characteristicXpath));
        String actLsl = characteristicRow.findElement(By.xpath("./td[3]")).getText();
        String actUsl = characteristicRow.findElement(By.xpath("./td[4]")).getText();
        String actBinCount = characteristicRow.findElement(By.xpath("./td[5]")).getText();
        Assert.assertEquals(actLsl, expLsl);
        Assert.assertEquals(actUsl, expUsl);
        Assert.assertEquals(actBinCount, expBinCount);
        return this;
    }
}
