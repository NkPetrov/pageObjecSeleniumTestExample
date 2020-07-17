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
public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){

        System.setProperty("webdriver.gecko.driver", "F:\\Drivers\\FirefoxDriver\\GeckoDriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCredsTest(){
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("","");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }

    @Test
    public void loginWithIncorrectCredsTest(){
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("qrqwrqrqrwwqeqwe","eqwqrqwrqwrqr");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }

    @Test
    public void createAccountTest(){
        SignUpPage signUpPage = loginPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub",heading);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
