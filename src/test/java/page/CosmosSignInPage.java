package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CosmosSignInPage extends AbstractPage {

    @FindBy(id = "user_login")
    private WebElement userLoginField;

    @FindBy(xpath = "//input[@id='user_password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//input[@name='commit']")
    private WebElement signInButton;

    @FindBy(xpath = "//fieldset/div")
    private WebElement signInMessage;

    public CosmosSignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String enterUserData(User user){
        userLoginField.sendKeys(user.getUserName());
        userPasswordField.sendKeys(user.getUserShortPhoneNumber());
        signInButton.click();
        return signInMessage.getText();
    }
}
