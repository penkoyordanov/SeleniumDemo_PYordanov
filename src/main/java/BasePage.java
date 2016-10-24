import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 10/24/2016.
 */
public class BasePage extends Base {
    String url = "http://demoqa.com";
    BasePage(WebDriver driver){
        super(driver);
        visit(url);
    }

    public SignUpPage navigateToSignUp(){
        visit(url+"/registration/");
        return new SignUpPage(driver);
    }
}
