package makeAppointmentTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AppointmentSummaryPage;
import pages.LoginPage;
import pages.MakeAppointmentPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HongKongTest extends BaseTests {

    @Test
    public void tokyoTest() throws InterruptedException {

        // Login
        LoginPage loginPage = homePage.clickMakeAppointment();
        loginPage.setUserName(loginPage.getUserName());
        loginPage.setPassword(loginPage.getPassword());
        MakeAppointmentPage makeAppointmentPage = loginPage.clickLoginButton();

        // Select from dropdown
        String option = "Hongkong CURA Healthcare Center";
        makeAppointmentPage.selectFromDropDown("Hongkong CURA Healthcare Center");
        java.util.List<String> selectedOptions = makeAppointmentPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");


        // Choose radio button
        makeAppointmentPage.buttonMedicaid();
        TimeUnit.SECONDS.sleep(1);

        // Set random date
        makeAppointmentPage.accessVisitDate();
        makeAppointmentPage.setVisitDate();
        TimeUnit.SECONDS.sleep(1);

        // Make a comment
        String comment = "This is a comment";
        makeAppointmentPage.accessCommentSection();
        makeAppointmentPage.setComment(comment);
        TimeUnit.SECONDS.sleep(1);

        // Press Button Book Appointment
        AppointmentSummaryPage appointmentPage = makeAppointmentPage.clickBookButton();
        assertEquals(appointmentPage.getAppointmentSummary(), "Appointment Confirmation", "The booking failed!");
        TimeUnit.SECONDS.sleep(1);
    }
}
