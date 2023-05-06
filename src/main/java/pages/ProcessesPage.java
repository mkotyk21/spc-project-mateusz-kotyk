package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProcessesPage extends HomePage{
    public ProcessesPage(WebDriver driver){
        super(driver);
    }
@FindBy (xpath = "//a[text()='Add new process']")
private WebElement createProcessBtn;

private String GENERIC_PROCESS_XPATH="//td[text()='%s']";

    public ProcessesPage expectedProcessesUrl(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
        return this;
    }

    public CreateProcessesPage addNewProcess(){
        createProcessBtn.click();
        return new CreateProcessesPage(driver);
    }

    public ProcessesPage assertProcessAdded(String name, String description, String notes){
        String nameXpath=String.format(GENERIC_PROCESS_XPATH,name);
        String processName=driver.findElement(By.xpath(nameXpath)).getText();
        String processDesc=driver.findElement(By.xpath(nameXpath+"/..//td[2]")).getText();
        String processNotes=driver.findElement(By.xpath(nameXpath+"/..//td[3]")).getText();
       Assert.assertEquals(processName,name);
       Assert.assertEquals(processDesc,description);
       Assert.assertEquals(processNotes,notes);
        return this;
    }

    }
