import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    private By emailField = By.xpath("//input[@type = 'email']");
    private By passwordField = By.xpath("//input[@type = 'password']");
    private By submitButton = By.xpath("//input[@id = 'signInSubmit']");
    private By warningMessage = By.xpath("//div[@id = 'auth-warning-message-box']//h4");

    public SignInPage (WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage enterInvalidEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignInPage enterInvalidPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignInPage clickSubmitInvalid() {
        driver.findElement(submitButton).click();
        return this;
    }

    public SignInPage SignInInvalid(String email, String password) {
        enterInvalidEmail(email);
        enterInvalidPassword(password);
        clickSubmitInvalid();
        return this;
    }

    public String getWarning(){
        return driver.findElement(warningMessage).getText();
    }
}
