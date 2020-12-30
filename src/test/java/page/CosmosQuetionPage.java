package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CosmosQuetionPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='q-5-1']")
    private WebElement checkboxSN;

    @FindBy(xpath = "//input[@name='question[35]']")
    private WebElement favouriteTV;

    @FindBy(xpath = "//input[@name='question[36]']")
    private WebElement myThings;

    @FindBy(xpath = "//input[@name='question[37]']")
    private WebElement aditional;

    @FindBy(xpath = "//input[@name='submit']")
    private WebElement sendButton;

    public CosmosQuetionPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String setAnswers(){
        checkboxSN.click();
        favouriteTV.sendKeys("mtv");
        myThings.sendKeys("hello");
        aditional.sendKeys("dont know");
        sendButton.click();
        return "good";
    }
}
