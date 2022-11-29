package com.rudra;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class DriverManager extends Utils{

    String browserName = LoadProp.getProperty("Browser");

    @BeforeMethod
    public void openBrowser(){
        if (browserName.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver","src/test/Drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver","src/test/Drivers/msedgedriver");
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.firefox.driver","src/test/Drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.get(LoadProp.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
