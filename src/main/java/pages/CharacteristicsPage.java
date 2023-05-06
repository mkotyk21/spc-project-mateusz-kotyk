package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CharacteristicsPage extends HomePage{
    public CharacteristicsPage(WebDriver driver){
        super(driver);
    }



    public CharacteristicsPage expectedCharacteristicsUrl(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
        return this;
    }
}
