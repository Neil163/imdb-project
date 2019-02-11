import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestsExecution {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\mySelenium\\imdb_project\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest(){

        RegistrationPage registrationPage = mainPage.clickSignIn();
        String header = registrationPage.getHeader();
        Assert.assertEquals("Sign in", header);
        SignInPage signInPage = registrationPage.clickSignIn();
        signInPage.SignInInvalid("123", "12");
        String warning = signInPage.getWarning();
        Assert.assertEquals("Important Message!", warning);
    }

    @Test
    public void doSearch(){

        SearchPage searchPage = mainPage.search("heroes");
        String result = searchPage.getSearchResult();
        Assert.assertEquals("\"heroes\"", result);
    }

    @After
    public void endTest() {

        driver.quit();
    }
}
