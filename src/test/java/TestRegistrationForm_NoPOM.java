import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by penko.yordanov on 21-Oct-16.
 */
public class TestRegistrationForm_NoPOM {
    private String baseURL="http://demoqa.com/registration/";
    private WebDriver driver;

    String firstName="Penko";
    WebDriverWait wait;
    private long milis;


    @Before
    public void setUp(){
        //Initialize Chrome browser
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        this.driver=new ChromeDriver();
        driver.manage().window().maximize();

        //Navigate to page
        driver.get(baseURL);
        //Get current time in miliseconds. This number will be added to the email and username, as registration requires unique users
        milis=System.currentTimeMillis() % 1000;
    }

    @After
    public void shutDown() {
        driver.close();
    }

    @Test
    public void sucessfullRegistrationUsingPOM(){

    }

    @Test
    public void submitRegistrationForm(){

        //Start locating elements
        WebElement firstNameField=driver.findElement(By.id("name_3_firstname"));
        firstNameField.sendKeys("Penko");
        WebElement lastNameField=driver.findElement(By.id("name_3_lastname"));
        lastNameField.sendKeys("Yordanov");

        //Locate and click on radio button
        WebElement radioBtn=driver.findElement(By.xpath("//input[@value='single' and @type='radio']"));
        radioBtn.click();
        Assert.assertTrue(radioBtn.isSelected());

        //Locate and click on radio button
        WebElement checkBox=driver.findElement(By.cssSelector("[value='dance']"));
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected());

        //Select from dropdown by text
        Select select = new Select(driver.findElement(By.id("dropdown_7")));
        select.selectByVisibleText("Bulgaria");

        //Assert that selected option matches expected selection
        assertEquals("Bulgaria", select.getFirstSelectedOption().getText());

        //Select from dropdown by text
        select =new Select(driver.findElement(By.id("mm_date_8")));
        select.selectByVisibleText("9");

        //Assert that selected option matches expected selection
        assertEquals("9", select.getFirstSelectedOption().getText());

        //Select from dropdown by text
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

        Assert.assertThat(driver.findElement(By.xpath("//p[@class='piereg_message']")).getText(),is(equalTo("Thank you for your registration")));


    }


}
