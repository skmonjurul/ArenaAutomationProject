package com.qa.tests;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;


import com.qa.test_setup.TestSetUp;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CheckFilterResult extends TestSetUp{

    private Map<String, String> testData = new HashMap<String, String>();

    public void setTestData(){

        String browser = "ff";
        String env = "test";
        String config = "test_data_001";
        testData.put("browser", browser);
        testData.put("env", env);
        testData.put("config", config);
    }

    @BeforeClass
    public void setUp(){
        setTestData();
        testSetUp(testData);
    }

    @Test
    public void searchBasedOnFilter(){
        HomePage homePage = new HomePage();
        homePage.clickOnVacationTab();
        homePage.selectSpecificBundle("car", 20);
        homePage.enterData(test_data);
        homePage.clickOnFindADealButton();
    }

    @Test
    public void validateResultPage(){
        ResultPage resultPage = new ResultPage();
        resultPage.waitTillPageLoad(30);
        try{
            if(resultPage.getResultCount() == 0){
                throw new AssertionError();
            }
        }
        catch (AssertionError e){
            System.out.println("No result found");
            Assert.fail();
        }
    }

    @AfterSuite
    public void tearDown(){
        tearDownDriver();
    }

}