package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CosmosBusinessPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='name']")
    private WebElement userBusinessNameField;

    @FindBy(xpath = "//input[@name='org']")
    private WebElement userOrganizationField;

    @FindBy(xpath = "//input[@name='code']")
    private WebElement userCodeField;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement userPhoneField;

    @FindBy(xpath = "//input[@name='time']")
    private WebElement userTimeField;

    @FindBy(xpath = "//input[@value='Заказать']")
    private WebElement connectButton;

    @FindBy(xpath = "//input[@value='Ваш запрос отправлен!']")
    private WebElement connectButtonMessage;

    public CosmosBusinessPage(WebDriver driver){
        driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement addUserInfoFromBusinessToField(User user) {
        userBusinessNameField.sendKeys(user.getUserName());
        userOrganizationField.sendKeys(user.getUserOrganization());
        userCodeField.sendKeys(user.getUserCode());
        userPhoneField.sendKeys(user.getUserShortPhoneNumber());
        userTimeField.sendKeys(user.getUserTime());
        connectButton.click();
        return  connectButtonMessage;
    }
}
