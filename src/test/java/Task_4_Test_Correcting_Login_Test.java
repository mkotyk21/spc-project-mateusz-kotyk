import org.testng.annotations.Test;
import pages.LoginPage;

public class Task_4_Test_Correcting_Login_Test extends SeleniumBaseTest{
    @Test
    public void correctLoginTest() {
        new LoginPage(driver)
                .submitCorrectLogin(config.getApplicationUser(),config.getApplicationPassword())
                .assertCorectLogin();
    }
}
