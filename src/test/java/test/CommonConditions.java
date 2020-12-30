package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    private WebDriver driver;

    @BeforeMethod()
    public void setUp() {
        driver = new ChromeDriver();
        ChromeOptions chromeOptions_windowOne = new ChromeOptions();
        chromeOptions_windowOne.setHeadless(true);

    }

    @AfterMethod (alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }

}
