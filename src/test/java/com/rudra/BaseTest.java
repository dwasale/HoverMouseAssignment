package com.rudra;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends Utils{
    DriverManager driverManager = new DriverManager();

    //This method runs before calling any other methods or class
    @BeforeMethod
    public void setUp(){
        driverManager.openBrowser();
    }

    //This methods is called after all the other methods are called
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception{
        if (!result.isSuccess()){
            takeScreenshot(result.getName());
        }
        driverManager.closeBrowser();
    }
}
