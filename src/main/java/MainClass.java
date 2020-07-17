import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author N.Petrov
 * @link http://N.Petrov.com
 */
public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "F:\\Drivers\\FirefoxDriver\\GeckoDriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");

       // MainPage mainPage = new MainPage(driver);
        MainPage mainPage = PageFactory.initElements(driver,MainPage.class);
        mainPage.register("testerName","tester@yandex.ru","testerPassword");
    }
}
