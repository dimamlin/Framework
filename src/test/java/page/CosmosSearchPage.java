package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CosmosSearchPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='search-results']/ul/li/h4/a")
    private WebElement searchResult;

    public CosmosSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement checkSearchResult(){
        return searchResult;
    }
}
