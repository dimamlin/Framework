package test;
import model.User;
import driver.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CosmosHomePage;
import service.UserCreator;

import java.util.concurrent.TimeUnit;


public class WebDriverCosmosTest extends CommonConditions{

    protected WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = DriverSetup.getDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test (description = "tryToConnectNewClient")
    public void connectUserWithUserNameAndPhoneNumberTest() {

        String afterSendingInfoMessageText = new CosmosHomePage(driver)
                .openPage()
                .openConnectPage()
                .addUserInfoToField(UserCreator.withDefaultOptions());

        Assert.assertEquals(afterSendingInfoMessageText, "Спасибо! Ваша заявка принята");
    }

    @Test (description = "changeNormalViewTo")
    public void changeMainColorsToBlackAndWhiteVersionTest() {

        WebElement moduleSpecialVisually = new CosmosHomePage(driver)
                .openPage()
                .changeMainTheme()
                .checkSpecialModule();

        Assert.assertFalse(moduleSpecialVisually  == null, "Special Visually module not found!");

    }

    @Test (description = "tryToConnectNewClientFromBusiness")
    public void sendRequestToConnectFromBusinessUserTest() {

        WebElement afterSendingInfoFromBusinessMessageText = new CosmosHomePage(driver)
                .openPage()
                .openBusinessPage()
                .addUserInfoFromBusinessToField(UserCreator.withBusinessOptions());

        Assert.assertFalse(afterSendingInfoFromBusinessMessageText == null, "Success message not found!");
    }

    @Test (description = "checkSearchResult")
    public void searchResultIsNotEmptyTest() {

        WebElement afterSendingInfoFromBusinessMessageText = new CosmosHomePage(driver)
                .openPage()
                .enterSearchRequest("internet")
                .checkSearchResult();

        Assert.assertFalse(afterSendingInfoFromBusinessMessageText == null, "Search result not found!");
    }

    @Test (description = "signInWithUser")
    public void signInUserRoomTest() {

        String afterSignInFromUserMessage = new CosmosHomePage(driver)
                .openPage()
                .openSignInPage()
                .enterUserData(UserCreator.withDefaultOptions());

        Assert.assertFalse(afterSignInFromUserMessage == "Неверный логин или пароль!", "Input data incorrect!");
    }

    @Test (description = "requestForSupportCall")
    public void supportCallRequest() {

        String afterCallRequestMessage = new CosmosHomePage(driver)
                .openPage()
                .openSupportPage()
                .enterUserData(UserCreator.withBusinessOptions());

        Assert.assertTrue(afterCallRequestMessage != "Ваш запрос отправлен!", "Input data incorrect!");
    }

    @Test (description = "sendMessageToOnlineHelpTest")
    public void sendMessageToOnlineHelpTest() {

        String afterCallRequestMessage = new CosmosHomePage(driver)
                .openPage()
                .openOnlineHelp()
                .enterUserData(UserCreator.withBusinessOptions());

        Assert.assertTrue(afterCallRequestMessage != "Ваш запрос отправлен!", "Input data incorrect!");
    }

    @Test (description = "answerQuestionsAboutServiceTest")
    public void answerQuestionsAboutServiceTest() {

        String afterQuestionSendingMessage = new CosmosHomePage(driver)
                .openPage()
                .openQuetionPage()
                .setAnswers();

        Assert.assertTrue(afterQuestionSendingMessage != null, "Error in answer!");
    }

    @Test (description = "signInWithBusiness")
    public void signInBusinessRoomTest() {

        String afterSignInFromBusinessMessage = new CosmosHomePage(driver)
                .openPage()
                .openSignInPage()
                .enterUserData(UserCreator.withDefaultOptions());

        Assert.assertFalse(afterSignInFromBusinessMessage == "Неверный логин или пароль!", "Input data incorrect!");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        DriverSetup.closeDriver();
    }

}
