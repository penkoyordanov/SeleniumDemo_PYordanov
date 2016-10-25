import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

/**
 * Following test case shows basics of selenium
 */
public class TestRegistrationForm_NoPOM {
    private WebDriver driver;

    private long milis;


    @Before
    public void setUp(){
        //Initialize Chrome browser
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        this.driver=new ChromeDriver();
        driver.manage().window().maximize();

        //Navigate to page
        String baseURL = "http://demoqa.com/registration/";
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
        WebElement marialStatusRadio=driver.findElement(By.xpath("//input[@value='single' and @type='radio']"));
        marialStatusRadio.click();

        //Locate and click on radio button
        WebElement hobbyCheckBox=driver.findElement(By.cssSelector("[value='dance']"));
        hobbyCheckBox.click();

        //Select from dropdown by text
        Select select = new Select(driver.findElement(By.id("dropdown_7")));
        select.selectByVisibleText("Bulgaria");

        //Select from dropdown by text
        select =new Select(driver.findElement(By.id("mm_date_8")));
        select.selectByVisibleText("9");

        //Select from dropdown by text
        select =new Select(driver.findElement(By.id("dd_date_8")));
        select.selectByVisibleText("28");

        //Select from dropdown by text
        select =new Select(driver.findElement(By.id("yy_date_8")));
        select.selectByVisibleText("1985");

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

        WebElement submitBtn=driver.findElement(By.cssSelector("[type='submit']"));
        submitBtn.click();

        Assert.assertTrue(marialStatusRadio.isSelected());
        Assert.assertTrue(hobbyCheckBox.isSelected());
        //Assert that selected option matches expected selection
        assertEquals("Bulgaria", select.getFirstSelectedOption().getText());
        Assert.assertEquals("Strong",driver.findElement(By.id("piereg_passwordStrength")).getText());


        Assert.assertThat(driver.findElement(By.xpath("//p[@class='piereg_message']")).getText(),is(equalTo("Thank you for your registration")));


    }


}
