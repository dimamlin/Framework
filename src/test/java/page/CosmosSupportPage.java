package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CosmosSupportPage extends AbstractPage {

    @FindBy(xpath = "//li[3]/a/div")
    private WebElement callRequestButton;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name='code']")
    private WebElement userCodeField;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement userPhoneField;

    @FindBy(xpath = "//input[@name='time']")
    private WebElement userTimeField;

    @FindBy(xpath = "//div[@id='call-button']/input")
    private WebElement sendButton;

    public CosmosSupportPage(WebDriver driver){
        driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String enterUserData(User user){
        callRequestButton.click();
        userNameField.sendKeys(user.getUserName());
        userCodeField.sendKeys(user.getUserCode());
        userPhoneField.sendKeys(user.getUserShortPhoneNumber());
        userTimeField.sendKeys(user.getUserTime());
        sendButton.click();
        return sendButton.getText();
    }
}
