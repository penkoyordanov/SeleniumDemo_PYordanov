import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by admin on 10/24/2016.
 */
public class SignUpPage extends Base{
    private By firstNameField=By.id("name_3_firstname");
    private By lastNameField=By.id("name_3_lastname");


    public void setFirstName(String firstName){
        type(firstName,firstNameField);
    }
    public void setLastName(String lastName){
        type(lastName,lastNameField);
    }

   public void selectRadioBtn(String value){
       click(By.xpath("//input[@value='"+value+"' and @type='radio']"));
   }

   public void selectCheckBox(String value){
       click(By.cssSelector("[value='"+value+"']"));
   }

    public void selectCountry(String country){
        selectFromDrpdownByVisibleText(By.id("dropdown_7"),country);
    }

    public void selectBdayMonth(String month){
        selectFromDrpdownByVisibleText(By.id("mm_date_8"),month);
    }


    /*//Select from dropdown by text
    select =new Select(driver.findElement(By.id("dd_date_8")));
        select.selectByVisibleText("28");

    //Assert that selected option matches expected selection
    assertEquals("28", select.getFirstSelectedOption().getText());

    //Select from dropdown by text
    select =new Select(driver.findElement(By.id("yy_date_8")));
        select.selectByVisibleText("1985");

    //Assert that selected option matches expected selection
    assertEquals("1985", select.getFirstSelectedOption().getText());

    WebElement phoneNumberField=driver.findElement(By.id("phone_9"));
        phoneNumberField.sendKeys("359895654123");

    WebElement userNameField=driver.findElement(By.id("username"));
        userNameField.sendKeys("penkoyordanov"+milis);

    WebElement emailField=driver.findElement(By.id("email_1"));
        emailField.sendKeys("penko"+milis+"@icb.bg");

    WebElement passwordField=driver.findElement(By.xpath("//label[text()='Password']/../input"));
        passwordField.sendKeys("188k#F41|4o*6IZ");

    WebElement confirmPassword=driver.findElement(By.xpath("//label[text()='Confirm Password']/../input"));
        confirmPassword.sendKeys("188k#F41|4o*6IZ");

        Assert.assertEquals("Strong",driver.findElement(By.id("piereg_passwordStrength")).getText());

    WebElement submitBtn=driver.findElement(By.cssSelector("[type='submit']"));
        submitBtn.click();
*/

    SignUpPage(WebDriver driver){
        super(driver);

    }
}
