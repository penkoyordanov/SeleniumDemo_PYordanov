import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.Browser;
import pages.SelectablePage;
import pages.SignUpPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

/**
 * This test case will demonstrate usage of page object model for creation of maintanable test cases
 */
public class TestSelectablePOM {
    private WebDriver driver;
    private SelectablePage selectablePage;

    @Before
    public void setUp(){
        Browser.initChrome();
        this.driver=Browser.driver();
        BasePage basePage=new BasePage(driver);
        selectablePage=basePage.navigateSelectablePage();
    }
   /* @After
    public void shutDown() {
        driver.close();
    }*/

    @Test
    public void SelectItems(){
    selectablePage.selectElement("Item 1","Item 2");
    }
}
