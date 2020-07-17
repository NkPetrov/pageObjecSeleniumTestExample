import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author N.Petrov
 * @link http://N.Petrov.com
 */
public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@name='login']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By signInButton = By.xpath("//input[@value='Sign in']");
    private By heading = By.xpath("//h1[text()='Sign in to GitHub']");
    private By error = By.xpath("///html/body/div[3]/main/div/form/div[2]/div/div");
    private By createAccountLink = By.xpath("//a[text()='Create an account']");

    public LoginPage typeUserName(String userName){
        driver.findElement(loginField).sendKeys(userName);
        return this;
    }

    public LoginPage typePasswordField(String userPassword){
        driver.findElement(passwordField).sendKeys(userPassword);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String userName,String userPassword){

        this.typeUserName(userName);
        this.typePasswordField(userPassword);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(createAccountLink).click();
        return new SignUpPage(driver);
    }
}
