import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.UUID;

public class Task_6_Test_Dodania_Procesu_Test extends SeleniumBaseTest{
    @Test
    public void addNewProcess(){
        String name= UUID.randomUUID().toString().substring(0,10);
        String description= UUID.randomUUID().toString().substring(0,10);
        String notes= UUID.randomUUID().toString().substring(0,15);
        new LoginPage(driver)
                .submitCorrectLogin(config.getApplicationUser(),config.getApplicationPassword())
                .goToProcesses()
                .addNewProcess()
                .addingProcess(name,description,notes)
                .assertProcessAdded(name,description,notes);
    }
}
