package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignUpPage extends Base {
    private By firstNameField = By.id("name_3_firstname");
    private By lastNameField = By.id("name_3_lastname");
    private By phoneField = By.id("phone_9");
    private By usernameField = By.id("username");
    private By emailField = By.id("email_1");
    private By passwordField = By.xpath("//label[text()='Password']/../input");
    private By confirmPasswordField = By.xpath("//label[text()='Confirm Password']/../input");
    private By submitBtn = By.cssSelector("[type='submit']");


    SignUpPage(WebDriver driver) {
        super(driver);
    }


    public void setFirstName(String firstName) {
        type(firstName, firstNameField);
    }

    public void setLastName(String lastName) {
        type(lastName, lastNameField);
    }

    public void selectMarialStatus(String marialStatus) {
        click(By.xpath("//input[@value='" + marialStatus + "' and @type='radio']"));
    }

    public void selectHobby(String hobby) {
        click(By.cssSelector("[value='" + hobby + "']"));
    }

    public void selectCountry(String country) {
        selectFromDrpdownByVisibleText(By.id("dropdown_7"), country);
    }


    public void selectBday(String birthday) {
        String[] bdaySeparate=birthday.split("/");
        selectDay(bdaySeparate[0]);
        selectMonth(bdaySeparate[1]);
        selectYear(bdaySeparate[2]);
    }

    private void selectDay(String day) {
        selectFromDrpdownByVisibleText(By.id("dd_date_8"), day);
    }

    private void selectMonth(String month) {
        selectFromDrpdownByVisibleText(By.id("mm_date_8"), month);
    }

    private void selectYear(String year) {
        selectFromDrpdownByVisibleText(By.id("yy_date_8"), year);
    }

    public void setPhoneNumber(String phone) {
        type(phone, phoneField);
    }

    public void setUsername(String username) {
        type(username, usernameField);
    }

    public void setEmail(String email) {
        type(email, emailField);
    }

    public void setPassword(String password) {
        type(password, passwordField);
    }

    public void setConfirmPassword(String password) {
        type(password, confirmPasswordField);
    }

    public void clickSubmitBtn() {
        click(submitBtn);
    }

    public String getConfimationText(){
        return getTextOfElement(By.xpath("//p[@class='piereg_message']"));
    }

}
