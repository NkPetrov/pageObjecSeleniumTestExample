import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author N.Petrov
 * @link http://N.Petrov.com
 */
public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By mainLabel = By.xpath("/html/body/div[4]/main/div/div[1]/div");
    private By signUpButton = By.xpath("//button[@id='signup_button']");
    private By fieldUserName = By.xpath("//input[@id='user_login']");
    private By fieldUserEmail = By.xpath("//input[@id='user_email']");
    private By fieldUserPassword = By.xpath("//input[@id='user_password']");

    private By userError = By.xpath("//*[@id=\"input-check-2351\"]1");
    private By emailError = By.xpath("//*[@id=\"input-check-6760\"]");

    public SignUpPage typeUserName(String userName){
        driver.findElement(fieldUserName).sendKeys(userName);
        return this;
    }

    public SignUpPage typeUserEmail(String userEmail){
        driver.findElement(fieldUserEmail).sendKeys(userEmail);
        return this;
    }

    public SignUpPage typeUserPassword(String userPassword){
        driver.findElement(fieldUserPassword).sendKeys(userPassword);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String userName, String userEmail, String userPassword){
        this.typeUserName(userName);
        this.typeUserEmail(userEmail);
        this.typeUserPassword(userPassword);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText(){
        return driver.findElement(mainLabel).getText();
    }

    public String getErrorUser(){
        return driver.findElement(userError).getText();
    }

    public String getErrorEmail(){
        return driver.findElement(emailError).getText();
    }

}
