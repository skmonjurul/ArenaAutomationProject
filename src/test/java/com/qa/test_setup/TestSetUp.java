package com.qa.test_setup;

import com.generic_methods.CommonMethods;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;


import com.selenium.selenium_wrapper.BaseClass;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestSetUp {

    public WebDriver driver;
    public CommonMethods commonMethods;
    public JSONObject test_data;

    public TestSetUp(){
        this.commonMethods = new CommonMethods();
    }

    public void testSetUp(Map<String, String> testData){
        try {
            setTestData(testData.get("config"));
            BaseClass baseClass = BaseClass.getInstance(testData.get("browser"));
            this.driver = baseClass.getDriver();
            String url = getUrlAsPerEnv(testData.get("env"));
            this.driver.manage().deleteAllCookies();
            this.driver.get(url);
            this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            this.driver.manage().window().maximize();
        }
        catch(AssertionError e){
            System.out.println("No File named "+ testData.get("config") + ".json is exist. please check the file name or dir");
            System.exit(0);
        }
    }

    public String getUrlAsPerEnv(String envName){
        String url;
        JSONObject jsonObject = commonMethods.readEnvConfigFile();
        JSONObject urlObject = (JSONObject)jsonObject.get(envName);
        return (String)urlObject.get("base_url");
    }

    public void setTestData(String config) throws AssertionError{
        test_data = commonMethods.getTestData(config);
    }

    public void tearDownDriver(){
        try {
            driver.close();
            driver.quit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
