import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private WebDriver driver;
    private By searchResult = By.xpath("//span[@class = 'findSearchTerm']");

    public SearchPage (WebDriver driver) {
        this.driver = driver;
    }

    public String getSearchResult() {
        return driver.findElement(searchResult).getText();
    }
}
