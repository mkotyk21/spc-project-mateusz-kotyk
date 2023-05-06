package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProcessesPage extends HomePage{
    public ProcessesPage(WebDriver driver){
        super(driver);
    }



    public ProcessesPage expectedProcessesUrl(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
        return this;
    }
    }
