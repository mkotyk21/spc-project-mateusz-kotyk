import org.testng.annotations.Test;
import pages.LoginPage;

public class Tasks_6_and_7_Test_Adding_Process_Test extends SeleniumBaseTest{
    @Test
    public void addNewProcess(){

        String name= faker.company().buzzword();
        String description= faker.company().profession();
        String notes= faker.company().industry();
        new LoginPage(driver)
                .submitCorrectLogin(config.getApplicationUser(),config.getApplicationPassword())
                .goToProcesses()
                .addNewProcess()
                .addingProcess(name,description,notes)
                .assertProcessAdded(name,description,notes)
                .goToDashboard()
                .assertNameProcessIsDisplayed(name);
    }
}
