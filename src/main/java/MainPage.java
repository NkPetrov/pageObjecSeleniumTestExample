import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author N.Petrov
 * @link http://N.Petrov.com
 */
public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]");
    private By signUpButton = By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[2]");
    private By userNameField = By.xpath("//*[@id=\"user[login]\"]");
    private By userEmailField = By.xpath("//*[@id=\"user[email]\"]");
    private By userPasswordField = By.xpath("//*[@id=\"user[password]\"]");
    private By signUpToGitHubButton = By.xpath("//button[text()='Sign up for GitHub']");

    public LoginPage clickSignIn(){
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp(){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpToGitHubButton(){
        driver.findElement(signUpToGitHubButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String userName){
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public MainPage typeUserEmail(String userEmail){
        driver.findElement(userEmailField).sendKeys(userEmail);
        return this;
    }

    public MainPage typeUserPassword(String userPassword){
        driver.findElement(userPasswordField).sendKeys(userPassword);
        return this;
    }

    public SignUpPage register(String userName, String userEmail, String userPassword){
        this.typeUserName(userName);
        this.typeUserEmail(userEmail);
        this.typeUserPassword(userPassword);
        this.clickSignUpToGitHubButton();
        return new SignUpPage(driver);
    }


}
