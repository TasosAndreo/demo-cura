package loginTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MakeAppointmentPage;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class LoginTest extends BaseTests {

    @Test (priority = 0)
    public void testSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = homePage.clickMakeAppointment();
        loginPage.setUserName(loginPage.getUserName());
        loginPage.setPassword(loginPage.getPassword());
        MakeAppointmentPage makeAppointmentPage = loginPage.clickLoginButton();
        System.out.println(makeAppointmentPage.getCurrentURL());
        TimeUnit.SECONDS.sleep(1);
        assertEquals(makeAppointmentPage.getCurrentURL(),"https://katalon-demo-cura.herokuapp.com/#appointment","Login Failed!");
    }
}
