import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author N.Petrov
 * @link http://N.Petrov.com
 */
public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void setUp(){

        System.setProperty("webdriver.gecko.driver", "F:\\Drivers\\FirefoxDriver\\GeckoDriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
        mainPage = new MainPage(driver);

    }

    @Test
    public void signInTest(){
        LoginPage loginPage = mainPage.clickSignIn();
        String header = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub",header);
    }

    @Test
    public void signUpTest(){
        SignUpPage signUpPage = mainPage.register("testuser","test@mail.ru","testPassword");
        String error = signUpPage.getErrorEmail();
        Assert.assertEquals("Email is invalid or already taken",error);
    }

    @Test
    public void signUpEmptyUserNameTest(){
        SignUpPage signUpPage = mainPage.register("","test@mail.ru","testPassword");
        String error = signUpPage.getErrorUser();
        Assert.assertEquals("Username can't be blank",error);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
