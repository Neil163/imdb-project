import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;
    private By createAccountButton = By.xpath("//a[text() = 'Create a New Account']");
    private By signInButton = By.xpath("//div[@class = 'list-group']/*[1]");
    private By headerSignIn = By.xpath("//div[@id = 'signin-options']//h1");

    public RegistrationPage (WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }

    public SignUpPage clickCreateAccount() {
        driver.findElement(createAccountButton).click();
        return new SignUpPage(driver);
    }

    public String getHeader() {
        return driver.findElement(headerSignIn).getText();
    }
}
