package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class MakeAppointmentPage {

    WebDriver driver;
    private By dropdown = By.id("combo_facility");
    private By checkBox = By.id("chk_hospotal_readmission");
    private By buttonMedicare = By.id("radio_program_medicare");
    private By buttonMedicaid = By.id("radio_program_medicaid");
    private By buttonNone = By.id("radio_program_none");
    private By visitDate = By.id("txt_visit_date");
    private By comment = By.id("txt_comment");
    private By buttonBook = By.id("btn-book-appointment");

    public MakeAppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromDropDown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements =
                findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement() {
        return new Select(driver.findElement(dropdown));
    }

    public void checkBox(){
        driver.findElement(checkBox).click();
    }

    public void buttonMedicare() {
        driver.findElement(buttonMedicare).click();
    }

    public void buttonMedicaid() {
        driver.findElement(buttonMedicaid).click();
    }

    public void buttonNone() {
        driver.findElement(buttonNone).click();
    }

    public void accessVisitDate(){
        driver.findElement(visitDate).click();
    }

    // This is a hard coded random date
    public void setVisitDate(){
        driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[4]/td[5]")).click();
    }

    public void accessCommentSection(){
        driver.findElement(comment).click();
    }

    public void setComment(String comment1){
        driver.findElement(comment).sendKeys(comment1);
    }

    public String getCurrentURL() {
        String urlValue = driver.getCurrentUrl();
        return urlValue;
    }

    public AppointmentSummaryPage clickBookButton(){
        driver.findElement(buttonBook).click();
        return new AppointmentSummaryPage(driver);
    }
}
