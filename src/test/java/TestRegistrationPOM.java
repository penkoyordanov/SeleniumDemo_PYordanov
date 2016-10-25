import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.Browser;
import pages.SignUpPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

/**
 * This test case will demonstrate usage of page object model for creation of maintanable test cases
 */
public class TestRegistrationPOM {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp(){
        Browser.initChrome();
        this.driver=Browser.driver();
        BasePage basePage=new BasePage(driver);
        signUpPage=basePage.navigateToSignUp();
    }
    @After
    public void shutDown() {
        driver.close();
    }

    @Test
    public void successfullRegistration(){
        long milis=System.currentTimeMillis() % 1000;
        String firstName = "Penko";
        String lastName="Yordanov";
        String marialStatus="single";
        String hobby="dance";
        String country="Bulgaria";
        String birthday="28/9/1985";
        String phoneNumber="359895654123";
        String userName="penkoyordanov"+milis;
        String email=userName+milis+"@icb.bg";

        signUpPage.setFirstName(firstName);
        signUpPage.setLastName(lastName);
        signUpPage.selectMarialStatus(marialStatus);
        signUpPage.selectHobby(hobby);
        signUpPage.selectCountry(country);
        signUpPage.selectBday(birthday);
        signUpPage.setPhoneNumber(phoneNumber);
        signUpPage.setUsername(userName);
        signUpPage.setEmail(email);
        signUpPage.setPassword("188k#F41|4o*6IZ");
        signUpPage.setConfirmPassword("188k#F41|4o*6IZ");
        signUpPage.clickSubmitBtn();


        Assert.assertThat(signUpPage.getConfimationText(),is(equalTo("Thank you for your registration")));

    }
}
