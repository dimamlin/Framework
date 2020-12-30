package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CosmosConnectPage extends AbstractPage {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement userPhoneField;

    @FindBy(xpath = "//input[@name='connectButton']")
    private WebElement connectButton;

    @FindBy(className = "success-answer")
    private WebElement afterSendingInfoMessage;

    public CosmosConnectPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String addUserInfoToField(User user)
    {
        userNameField.sendKeys(user.getUserName());
        userPhoneField.sendKeys(user.getPhoneNumber());
        connectButton.click();
        return afterSendingInfoMessage.getText();
    }

}
