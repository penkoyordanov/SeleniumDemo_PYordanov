package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

/**
 * Created by admin on 10/24/2016.
 */
public class Browser {
    private static WebDriver driver;

//    private static String folderPath = System.getenv("DRIVERS");

    public static WebDriver driver() {
        return driver;
    }

    public static void initChrome() {
        ChromeOptions options=new ChromeOptions();

        options.addArguments("chrome.switches","--disable-extensions");
        System.setProperty("webdriver.chrome.driver", "drivers" + File.separator + "chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
    }

    public static void initFF(){
//        System.setProperty("webdriver.gecko.driver", folderPath + File.separator + "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver	.manage().window().maximize();
    }
    public static void initEdge(){
//        System.setProperty("webdriver.edge.driver", folderPath + File.separator + "MicrosoftWebDriver.exe");
        EdgeOptions options=new EdgeOptions();
        options.setPageLoadStrategy("eager");
        driver = new EdgeDriver();
        driver	.manage().window().maximize();
    }



    public static void open(String url) {
        driver.get(url);
    }

    public static void quit() {
        driver.quit();
    }


    public static void close() {
        driver.close();
    }

}
