package com.rudra;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager extends Utils{

    String browserName = LoadProp.getProperty("Browser");

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

    public void closeBrowser(){
        driver.quit();
    }
}
