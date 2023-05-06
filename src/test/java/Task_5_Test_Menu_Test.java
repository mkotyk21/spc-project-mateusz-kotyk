import org.testng.annotations.Test;
import pages.LoginPage;

public class Task_5_Test_Menu_Test extends SeleniumBaseTest{
   @Test
    public void menuTest() {
String processesUrl="http://localhost:4444/Projects";
String characteristicsUrl="http://localhost:4444/Characteristics";
String dashboardUrl="http://localhost:4444/";

       new LoginPage(driver)
               .submitCorrectLogin(config.getApplicationUser(),config.getApplicationPassword())
               .goToProcesses()
               .expectedProcessesUrl(processesUrl)
               .goToCharacteristics()
               .expectedCharacteristicsUrl(characteristicsUrl)
               .goToDashboard()
               .expectedDashboardUrl(dashboardUrl);
   }
}
