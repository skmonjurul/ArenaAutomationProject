package com.selenium.selenium_wrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriver {

    private static WebDriver driver = null;
    private static SeleniumDriver seleniumDriver = null;

    public static WebDriver getDriver(String browserName) {
        if (seleniumDriver == null) {
            seleniumDriver = new SeleniumDriver();
            driver = seleniumDriver.getDriverByBrowserName(browserName);
        }
        return driver;

    }

    public WebDriver getDriverByBrowserName(String browserName) {
        WebDriver driver = null;
        if (browserName.equals("gc")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browserName.equals("ff")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }
}