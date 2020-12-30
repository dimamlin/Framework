package util;

import driver.DriverSetup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private void saveScreenshot(){
        File screenCapture = ((TakesScreenshot)DriverSetup
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(screenCapture, new File(".//target/screenshots/" +
                    getCurrentTimeAsString()
                    +".png"));
        } catch (IOException e) {
        }
    }

    public String getCurrentTimeAsString() {
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }


    @Override
    public void onTestStart(ITestResult iTestResult){}

    @Override
    public void onTestSuccess(ITestResult iTestResult){}

    @Override
    public void onTestFailure(ITestResult iTestResult){ saveScreenshot(); }

    @Override
    public void onTestSkipped(ITestResult iTestResult){}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) { }

    @Override
    public void onStart(ITestContext iTestContext) { }

    @Override
    public void onFinish(ITestContext iTestContext) { }
}
