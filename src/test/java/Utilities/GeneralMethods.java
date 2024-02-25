package Utilities;

import Tests.BaseTest;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

//here we are creating inheritance from the basetest as parent to use it's varibles and methods
public class GeneralMethods extends BaseTest {
    public synchronized void NavigateTo(String url) {//,String tcN,String TcDesc
        driver.navigate().to(url);
    }

    public void sendText(WebElement webElement, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        wait.until(ExpectedConditions.visibilityOf(webElement));
        //clear the text box if it's not empty
        if (!webElement.getText().isEmpty()) {
            webElement.clear();
        }
        webElement.sendKeys(text);
    }

    //clicking  element
    public void clickAnElement(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    //extract the numbers from the String
    public double extractNoFromString(WebElement e) {
        //get the full string of the price with $
        String stringValueOfPrice = e.getText();
        //extract the numbers only in another string
        String numberOnly = stringValueOfPrice.replaceAll("[^0-9.]", "");
        //converting the numbers from string to double
        double d = Double.parseDouble(numberOnly);
        return d;
    }

    //get attributeValueOfElement
    public String getAttributeValueOfElement(WebElement element, String attibute) {
        String result = element.getAttribute(attibute);
        System.out.println("text found is : " + result);
        return result;
    }

    //check Current Url Contains Text
    public void checkCurrentUrlContainsText(String text) {
        String currentURL = driver.getCurrentUrl().toString();
        Assert.assertTrue(StringUtils.containsIgnoreCase(currentURL, text));
        System.out.println(text + " found in   :  " + currentURL);
    }

    //check String Conatins Text
    public void checkStringConatinsText(String s, String text) {
        Assert.assertTrue(StringUtils.containsIgnoreCase(s, text));
        System.out.println("this String : " + s + "Contains this Text : " + text);
    }
}
