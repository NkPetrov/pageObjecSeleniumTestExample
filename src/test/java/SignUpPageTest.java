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
public class SignUpPageTest {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp(){

        System.setProperty("webdriver.gecko.driver", "F:\\Drivers\\FirefoxDriver\\GeckoDriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithShortPassword(){
        SignUpPage signUpPageTwo = signUpPage.typeUserEmail("qwe");
        String error = signUpPageTwo.getErrorEmail();
        Assert.assertEquals("Email is invalid or already taken",error);
    }

    @Test
    public void signUpReservedUserNameTest() {
        SignUpPage signUpPageTwo = signUpPage.typeUserName("username");
        String error = signUpPageTwo.getErrorUser();
        Assert.assertEquals("Username 'username' is unavailable.", error);
    }

    @Test
    public void signUpTakenUserName(){
        SignUpPage signUpPageTwo = signUpPage.typeUserName("user");
        String error = signUpPageTwo.getErrorUser();
        Assert.assertEquals("\n" +
                "    Username user is not available.\n" +
                "    user805, user469, or user252 are available.\n",error);
    }

    @Test
    public void getHeadertest() {
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }



    @After
    public void tearDown(){
        driver.quit();
    }

}
