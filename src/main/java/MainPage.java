import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By signInButton = By.xpath("//span[text() = 'Sign in']");
    private By searchButton = By.xpath("//button[@id = 'navbar-submit-button']");
    private By searchBox = By.xpath("//input[@id = 'navbar-query']");
    private By searchSelect = By.xpath("//select[@id = 'quicksearch']");
    private By optionOfSelector = By.xpath("//select//option[text() = 'TV Episodes']");
    private By navLink = By.xpath("//p//a[text() = 'Movies']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new RegistrationPage (driver);
    }

    public MainPage fillSearch(String searchText) {
        driver.findElement(searchBox).sendKeys(searchText);
        return this;
    }

    public MainPage setSelector() {
        driver.findElement(searchSelect).click();
        driver.findElement(optionOfSelector).click();
        return this;
    }

    public SearchPage clickSearchButton() {
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }

    public SearchPage search(String name) {
        fillSearch(name);
        setSelector();
        clickSearchButton();
        return new SearchPage(driver);
    }

    public String getLinkText(){

        return driver.findElement(navLink).getText();
    }
}
