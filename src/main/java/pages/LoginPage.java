package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    // Get Values
    public String getUserName(){
        String userNameValue = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div[1]/div/div/input")).getAttribute("value");
        return userNameValue;
    }
    public String getPassword(){
        String passwordValue = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/form/div[1]/div[2]/div/div/input")).getAttribute("value");
        return passwordValue;
    }
    // Set Values
    public void setUserName(String username){
        driver.findElement(By.id("txt-username")).sendKeys(username);
    }
    public void setPassword(String password){
        driver.findElement(By.id("txt-password")).sendKeys(password);
    }

    public MakeAppointmentPage clickLoginButton(){
        driver.findElement(By.id("btn-login")).click();
        return new MakeAppointmentPage(driver);
    }

    public String getURL(){
        String urlValue = driver.getCurrentUrl();
        return urlValue;
    }
}