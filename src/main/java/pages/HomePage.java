package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage clickMakeAppointment(){
        driver.findElement(By.id("btn-make-appointment")).click();
        return new LoginPage(driver);
    }
}
