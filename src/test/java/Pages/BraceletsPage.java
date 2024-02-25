package Pages;

import Utilities.GeneralMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BraceletsPage extends BasePage {

    public BraceletsPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    //global variables
    GeneralMethods generalMethods;
    //to store the product price
    public static double productPrice;

    //#Elements
    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchbarElement;
    @FindBy(xpath = "//input[@onclick='jQuery(this.form).submit();']")
    private WebElement goBTN;
    @FindBy(xpath = "(//div[@class=\"col-sm-4\"])/div/div[@class=\"j2store-content\"]/h2/a[1]")
    private WebElement firstItemTitle;
    @FindBy(xpath = "(//i[@class='fa fa-cart-plus'])[1]")
    private WebElement firstItemAddToCart;
    @FindBy(xpath = "(//i[@class='fa fa-cart-plus'])[1]")
    private WebElement firstItemName;
    @FindBy(xpath = "(//span[@class='sale-price'])[1]")
    private WebElement priceOfFirstItem;
    @FindBy(xpath = "//i[@class='fa fa-shopping-cart']")
    private WebElement cart;

    //#methods
    //verifyOpeningTheCorrectPage
    public void verifyOpeningTheCorrectPage(String text) {
        generalMethods = new GeneralMethods();
        generalMethods.checkCurrentUrlContainsText(text);
    }

    //search for fa text
    public void searchForFaText(String text) {
        generalMethods = new GeneralMethods();
        generalMethods.sendText(searchbarElement, text);
        generalMethods.clickAnElement(goBTN);
    }

    //verify Search Results Are Relevant
    public void verifySearchResultsAreRelevant(String text) {
        generalMethods = new GeneralMethods();
        int noOfProduct = driver.findElements(By.xpath("(//div[@class=\"col-sm-4\"])/div/div[@class=\"j2store-content\"]/h2/a")).size();
        System.out.println("No.Of proucts found is : " + noOfProduct);
        for (int i = 0; i < noOfProduct; i++) {
            WebElement Products = driver.findElement(By.xpath("(//div[@class=\"col-sm-4\"]/div/div[@class=\"j2store-content\"]/h2/a)" + "[" + (i + 1) + "]"));
            String s = generalMethods.getAttributeValueOfElement(Products, "text");
            generalMethods.checkStringConatinsText(s, text);
        }
    }

    //getFirstItemPrice
    public void getFirstItemPrice() {
        generalMethods = new GeneralMethods();
        productPrice = generalMethods.extractNoFromString(priceOfFirstItem);
    }

    //Add first itme to cart
    public void addFirstItemToCart() {
        generalMethods = new GeneralMethods();
        generalMethods.clickAnElement(firstItemAddToCart);
    }

    public void openCart() {
        generalMethods = new GeneralMethods();
        generalMethods.clickAnElement(cart);
    }


}
