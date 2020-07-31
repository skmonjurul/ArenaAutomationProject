package com.selenium.selenium_wrapper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BaseClass extends Object{

    private static BaseClass baseClass = null;
    public static WebDriver driver;
    WebDriverWait explicitWait;
    Wait<WebDriver> fluentWait;


    public BaseClass(){

    }

    public BaseClass(String browser){
        driver = SeleniumDriver.getDriver(browser);
    }

    public static BaseClass getInstance(String browser){
        if(baseClass == null){
            baseClass = new BaseClass(browser);
        }
        return baseClass;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void waitFor(long millis){
        try{
            Thread.sleep(millis);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public String getTextByXpath(String locator){
        return driver.findElement(By.xpath(locator)).getText();
    }

    public String getText(WebElement webElement){
        return webElement.getText();
    }

    public String waitForPageLoad(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        return (String)javascriptExecutor.executeScript("return document.readyState");
    }

    public WebElement waitUntilElementNotVisible(String locator, int timeOut){
        explicitWait = new WebDriverWait(driver, timeOut);
        WebElement header = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return header;
    }

    public WebElement waitUntilElementIsPresent(String locator, int timeOuts){
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeOuts, TimeUnit.SECONDS)
                .pollingEvery(2,TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement webElement = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath(locator));
            }
        });
        return webElement;
    }

    public WebElement waitUntilElementToBeClickable(String locator, int timeOut){
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeOut, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS).ignoring(ElementClickInterceptedException.class);
        WebElement webElement = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath(locator));
            }
        });
        return webElement;
    }

    public void clickElementByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }

    public void clickElementById(String locator){
        driver.findElement(By.id(locator)).click();
    }

    public void clickElementByXpath(WebElement webElement){
        webElement.click();
    }

    public void sendValueByXpath(String value, String locator){
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void pressTab(String locator){
        if (locator.contains("//")){
            driver.findElement(By.xpath(locator)).sendKeys(Keys.TAB);
        }
        else{
            driver.findElement(By.id(locator)).sendKeys(Keys.TAB);
        }
    }

    public void sendValueByXpath(int value, String locator){
        driver.findElement(By.xpath(locator)).sendKeys(Integer.toString(value));
    }

    public void sendValueById(String value, String locator){
        driver.findElement(By.id(locator)).clear();
        driver.findElement(By.id(locator)).sendKeys(value);
    }

    public void sendValueById(int value, String locator){
        driver.findElement(By.id(locator)).sendKeys(Integer.toString(value));
    }

    public void selectValueFromList(String value, String locator){
        getSelectByLocator(locator).selectByVisibleText(value);
    }

    public void selectValueFromList(int index, String locator){
        try{
            getSelectByLocator(locator).selectByIndex(index);
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    public Select getSelectByLocator(String locator){
        Select select=null;
        if (locator.contains("//")){
            select = new Select(driver.findElement(By.xpath(locator)));
        }
        else{
            select = new Select(driver.findElement(By.id(locator)));
        }
        return select;
    }

    public Object executeScript(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("arguments[0].click();", element);
    }

    public int getTotalNumberOfElementPresent(String locator){
        return driver.findElements(By.xpath(locator)).size();
    }

}
