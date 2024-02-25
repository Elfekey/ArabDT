package Pages;

import Utilities.GeneralMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    //global variables
    GeneralMethods generalMethods;
    //to store the total price
    private double totalPrice;

    //Elements
    @FindBy(xpath = "//td[@class='cart-line-subtotal']")
    private WebElement totalPriceEl;

    //methods
    //check Total Price
    public void checkTotalPrice() {
        generalMethods = new GeneralMethods();
        totalPrice = generalMethods.extractNoFromString(totalPriceEl);
    }

    public void verifyTotalPriceEqualsSelectedProductPrice() {
        BraceletsPage braceletsPage = new BraceletsPage(driver);
        Assert.assertEquals(totalPrice, braceletsPage.productPrice);
        System.out.println(totalPrice + "<< Total  and   Product >> " + braceletsPage.productPrice);
    }


}
