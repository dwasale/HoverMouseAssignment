package com.rudra;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utils extends BasePage {
    //This method will perform click action in given element
    public void clickOnElement(By by) {
        driver.findElement(by).click(); // It will find the unique element from the unique locator and performs click action

    }

    //This method will give user data to the specific field
    public void sendUserInput(By by, String text) {
        driver.findElement(by).sendKeys(text);  //Uniquely identify the element within the web page and perform given action

    }

    //This method will get the text value from the element
    public String getText(By by) {
        return driver.findElement(by).getText(); //Uniquely identify the element within the web page and get the text after execution
    }

    //This method is created to get the time stamp
    public String dateTimeStamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); // Storing current date and time as given pattern
    }

    //This method will select the dropdown list of webpage which is by value
    public void selectListByValue(By by, String text) {
        Select select = new Select(driver.findElement(by)); // It selects the elements and given unique locator and store in select variable
        select.selectByValue(text);
    }

    //This method will select the dropdown list by visible by text
    public void selectListByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by)); // It selects the elements and given unique locator and store in select variable
        select.selectByVisibleText(text);
    }

    //This method will select the dropdown list by index value
    public void selectListByIndexValue(By by, int value) {
        Select select = new Select(driver.findElement(by)); // It selects the elements and given unique locator and store in select variable
        select.selectByIndex(value);
    }

    public void elementToBeVisible(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //This method call WebDriver wait function by clickable properties
    public void waitElementToBeClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time)); //Instantiating Webdriver wait by seconds
        wait.until(ExpectedConditions.elementToBeClickable(by)); //clickable properties to be called for certain given time
    }

    //This method Webdriver wait function by url properties
    public void waitForUrlToBe(String url, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));   //Instantiating Webdriver wait by seconds
        wait.until(ExpectedConditions.urlToBe(url));    //urlToBe called by given url

    }

    public void takeScreenshot(String screenshotName) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        //Convert web driver object to TakeScreenshot
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Call getScreenshotAs method to create image file
        File DestFile = new File("src/main/ScreenShots" + screenshotName + dateTimeStamp() + ".jpg");
        //Move image file to new destination
        FileUtils.copyFile(SrcFile, DestFile);

    }
}
