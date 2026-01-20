package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentSummaryPage {

    WebDriver driver;

    public AppointmentSummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAppointmentSummary(){
        String attribute = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/h2")).getText();
        return attribute;
    }



}
