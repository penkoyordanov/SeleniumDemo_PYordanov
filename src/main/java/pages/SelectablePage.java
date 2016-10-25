package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by admin on 10/25/2016.
 */
public class SelectablePage extends Base {
    public SelectablePage(WebDriver driver) {
        super(driver);
    }

    public void selectElement(String element1,String element2) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(find(By.xpath("//ol[@id='selectable']/li[text()='"+element1+"']")))
                .clickAndHold(find(By.xpath("//ol[@id='selectable']/li[text()='"+element2+"']")))
                .release()
                .build().perform();
    }

}
