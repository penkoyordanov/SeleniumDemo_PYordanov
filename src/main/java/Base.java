import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Base page
 */
public class Base {

    protected WebDriver driver;

    protected Base(WebDriver driver) {
        this.driver = driver;
    }

    protected final void visit(String url) {
        driver.get(url);
    }

    protected final WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected final List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    protected final void click(By locator) {
        find(locator).click();
    }

    protected final void selectFromDrpdownByVisibleText(By locator,String selectText) {
        Select select = new Select(find(locator));
        select.selectByVisibleText(selectText);
    }

    protected final void clear(By locator) {
        find(locator).clear();
    }

    protected final void type(String inputText, By locator) {
        for (char ch : inputText.toCharArray()) {
            find(locator).sendKeys(Character.toString(ch));
        }
    }

    protected final void typeJS(String inputText, By locator) {
        find(locator).sendKeys(inputText);
    }

    protected final String getTextOfElement(By locator) {
        return find(locator).getText();
    }

    protected final Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    protected final Boolean isDisplayed(By locator, int MaxTime) {
        try {
            waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator), MaxTime);
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
        return true;
    }

    private void waitFor(ExpectedCondition<List<WebElement>> condition, Integer timeout) {
        timeout = timeout != null ? timeout : 5;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }

    protected final void waitUntilElementDisappear(final By locator, Integer timeout) {
        timeout = timeout != null ? timeout : 5;
        new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
