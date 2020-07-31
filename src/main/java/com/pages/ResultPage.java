package com.pages;

import com.selenium.selenium_wrapper.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ResultPage extends BaseClass{

    String _sectionHeaderTextXpath = "//*[@id='hotelResultTitle']";
    String _hotelsXpath = "//div[@id='resultsContainer']//article[@data-hotelid]";


    public void waitTillPageLoad(int timeOuts){
        String validationText = "Start by choosing your hotel";
        WebElement element = this.waitUntilElementNotVisible(_sectionHeaderTextXpath, timeOuts);
        String uiText = this.getText(element);
        Assert.assertEquals(validationText, uiText);
    }

    public int getResultCount(){
        return this.getTotalNumberOfElementPresent(_hotelsXpath);
    }

}
