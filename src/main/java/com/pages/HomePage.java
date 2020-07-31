package com.pages;

import com.generic_methods.CommonMethods;
import com.selenium.selenium_wrapper.BaseClass;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;


public class HomePage extends BaseClass{


    String _vacationTab = "//a[@data-bdd='packages']";
    String _carBundleOption = "//button[@data-bdd='farefinder-package-bundleoption-car']";
    String _flightBundleOption = "//button[@data-bdd='farefinder-package-bundleoption-flight']";
    String _hotelBundleOption = "//button[@data-bdd='farefinder-package-bundleoption-hotel']";
    String _flyFromXpath = "//input[@id='farefinder-package-origin-location-input']";
    String _flyToXpath = "//input[@id='farefinder-package-destination-location-input']";
    String _departingDateId = "farefinder-package-startdate-input";
    String _departingTimeId = "farefinder-package-pickuptime-input";
    String _returningDateId = "farefinder-package-enddate-input";
    String _returningTimeId = "farefinder-package-dropofftime-input";
    String _findADealButtonXpath = "//button[@id='farefinder-package-search-button']";


    public void enterData(JSONObject testData){
        CommonMethods commonMethods = new CommonMethods();
        JSONObject test_data = commonMethods.getJsonObject(testData, "test_data");
        enterLocation(commonMethods.getJsonObject(test_data, "location"));
        enterDate(commonMethods.getJsonObject(test_data, "date"));
        enterTime((commonMethods.getJsonObject(test_data, "time")));
    }

    public void enterLocation(JSONObject locationData){
        CommonMethods commonMethods = new CommonMethods();
        provideFlyFrom(commonMethods.getStringValueFromJson(locationData, "from"));
        provideFlyTo(commonMethods.getStringValueFromJson(locationData, "to"));
    }

    public void enterDate(JSONObject dateDate){
        CommonMethods commonMethods = new CommonMethods();
        selectDepartingDate(
                commonMethods.getDateAfterNoOfDays("MM/dd/yyyy", commonMethods.getIntegerValueFromJson(dateDate, "depart"))
                );
        selectReturningDate(
                commonMethods.getDateAfterNoOfDays("MM/dd/yyyy", commonMethods.getIntegerValueFromJson(dateDate, "return"))
                );
    }

    public void enterTime(JSONObject timeData){
        CommonMethods commonMethods = new CommonMethods();
        selectDepartingTime(commonMethods.getStringValueFromJson(timeData, "depart"));
        selectReturningTime(commonMethods.getStringValueFromJson(timeData, "return"));
    }

    public void clickOnVacationTab(){
        this.waitUntilElementNotVisible(_vacationTab, 10);
        this.clickElementByXpath(_vacationTab);
        this.waitFor(5000);
    }

    public void selectSpecificBundle(String bundleOption, int timeOut){
        if (this.waitForPageLoad().equals("complete")) {
            try {
                switch (bundleOption.toLowerCase()) {
                    case "car":
                        this.clickElementByXpath(this.waitUntilElementToBeClickable(_carBundleOption, timeOut));
                        break;
                    case "flight":
                        this.clickElementByXpath(this.waitUntilElementToBeClickable(_flightBundleOption, timeOut));
                        break;
                    case "hotel":
                        this.clickElementByXpath(this.waitUntilElementToBeClickable(_hotelBundleOption, timeOut));
                        break;
                    default:
                        throw new Exception();
                }// end of switch block
            } // end of try block

            catch(NullPointerException ex){
                System.out.println("No Value has been Provided, please provide any value(car, hotel, flight)");
            }
            catch (Exception e) {
                e.printStackTrace();
            } // end of catch block
        }

    } //end of selectSpecificBundle method

    public void provideFlyFrom(String flyFrom){
        this.sendValueByXpath(flyFrom, _flyFromXpath);
        this.waitFor(5000);
        this.pressTab(_flyFromXpath);
    }// end of provideFlyFrom methods

    public void provideFlyTo(String flyTo){
        this.sendValueByXpath(flyTo, _flyToXpath);
        this.waitFor(5000);
        this.pressTab(_flyToXpath);
    } //end of provideFlyTo methods

    public void selectDepartingDate(String departingDate){
        this.sendValueById(departingDate, _departingDateId);
    }// end of selectDepartingDate methods

    public void selectReturningDate(String returningDate){
        this.sendValueById(returningDate, _returningDateId);
    }// end of selectReturningDate methods

    public void selectDepartingTime(String departingTime){
        this.selectValueFromList(departingTime, _departingTimeId);
    } // end of selectDepartingTime method

    public void selectReturningTime(String returningTime){
        this.selectValueFromList(returningTime, _returningTimeId);
    } // end of selectReturningTime method

    public void clickOnFindADealButton(){
        WebElement webElement = this.waitUntilElementToBeClickable(_findADealButtonXpath, 10);
        try{
            this.executeScript(webElement);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    } //end of clickOnFindADealButton method

} // end of class HomePage
