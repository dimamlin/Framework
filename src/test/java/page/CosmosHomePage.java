package page;

import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CosmosHomePage  {

    private WebDriver driver;
    private String HOMEPAGE_URL = "https://cosmos-telecom.by/";
    //private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[contains(text(),'ПОДКЛЮЧИТЬ')]")
    private WebElement connectButton;

    @FindBy(xpath = "//li[6]/div[2]/a/span")
    private WebElement changeMainThemeButton;

    @FindBy(id = "module_special_visually")
    private WebElement moduleSpecialVisually;

    @FindBy(xpath = "//label")
    private WebElement openBusinessPageButton;

    @FindBy(xpath = "//div[@id='connection']/div")
    private WebElement connectFromBusinessButton;

    @FindBy(xpath = "//form/div/input")
    private WebElement searchField;

    @FindBy(xpath = "//input[2]")
    private WebElement searchButton;

    @FindBy(xpath = "(//a[contains(text(),'Личный кабинет')])[2]")
    private WebElement roomButton;

    @FindBy(xpath = "//a[contains(.,'Для физических лиц')]")
    private WebElement userRoomButton;

    @FindBy(xpath = "//img[@alt='Помощь']")
    private WebElement supportButton;

    @FindBy(xpath = "//span[@id='maximizeChat']")
    private WebElement onlineHelpButton;

    @FindBy(xpath = "//input[@id='offline0Field']")
    private WebElement userNameOnlineHelp;

    @FindBy(xpath = "//input[@id='offline1Field']")
    private WebElement userEmailOnlineHelp;

    @FindBy(xpath = "//input[@id='offline2Field']")
    private WebElement userPhoneOnlineHelp;

    @FindBy(xpath = "//textarea[@id='offline3Field']")
    private WebElement userMessageOnlineHelp;

    @FindBy(xpath = "//button[@id='formSubmit']")
    private WebElement onlineButtonHelp;

    @FindBy(xpath = "//a[contains(text(),'Для дома')]")
    private WebElement forHomeButton;

    @FindBy(xpath = "(//a[contains(text(),'Опросы')])[2]")
    private WebElement quetionButton;

    public CosmosHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CosmosHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public CosmosConnectPage openConnectPage(){
        connectButton.click();
        return new CosmosConnectPage(driver);
    }

    public CosmosHomePage changeLanguage()
    {
        return this;
    }

    public CosmosHomePage changeMainTheme()
    {
        changeMainThemeButton.click();
        return this;
    }

    public WebElement checkSpecialModule()
    {
        return moduleSpecialVisually;
    }

    public CosmosBusinessPage openBusinessPage(){
        openBusinessPageButton.click();
        connectFromBusinessButton.click();
        return new CosmosBusinessPage(driver);
    }

    public CosmosSearchPage enterSearchRequest(String word){
        searchField.sendKeys(word);
        searchButton.click();
        return new CosmosSearchPage(driver);
    }

    public CosmosSignInPage openSignInPage(){
        roomButton.click();
        userRoomButton.click();
        return new CosmosSignInPage(driver);
    }

    public CosmosSupportPage openSupportPage()
    {
        supportButton.click();
        return new CosmosSupportPage(driver);
    }

    public CosmosHomePage openOnlineHelp()
    {
        onlineHelpButton.click();
        return this;
    }

    public String enterUserData(User user){
        userNameOnlineHelp.sendKeys(user.getUserName());
        userEmailOnlineHelp.sendKeys("dddddd@gmail.com");
        userPhoneOnlineHelp.sendKeys(user.getPhoneNumber());
        userMessageOnlineHelp.sendKeys("help me");
        onlineButtonHelp.click();
        return "";
    }

    public CosmosQuetionPage openQuetionPage(){
        forHomeButton.click();
        quetionButton.click();
        return new CosmosQuetionPage(driver);
    }

}
