package Tests;

import Pages.BraceletsPage;
import Pages.CartPage;
import Pages.HomePage;
import Utilities.GeneralMethods;
import org.testng.annotations.Test;

public class MainScenario extends GeneralMethods {

    @Test(description = "This is test case one now")
    public void test1() throws Exception {
        //objects of the used pages
        HomePage homePage = new HomePage(driver);
        BraceletsPage braceletsPage = new BraceletsPage(driver);
        CartPage cartPage = new CartPage(driver);

        //#first page part
        //1. Launch Chrome browser
        //2. Navigate to http://demo.themeparrot.com/shopy/
        NavigateTo("https://demo.themeparrot.com/shopy/");
        //3. Navigate to Catalog > Bracelets
        homePage.gotoBraceletsPage();
        //#second page part
        //4. Verify the opening of the correct page
        braceletsPage.verifyOpeningTheCorrectPage("bracelets");
        //5. Search for the text fa
        braceletsPage.searchForFaText("fa");
        //6. Verify that the search results are relevant to the search done
        braceletsPage.verifySearchResultsAreRelevant("fa");
        //get first item price!
        braceletsPage.getFirstItemPrice();
        //add first item to cart !
        //7. Add the first displayed product to the cart
        braceletsPage.addFirstItemToCart();
        //8. Open the cart and verify that the total price equals the price of the product in the search results
        //of the previous page
        //check cart
        braceletsPage.openCart();
        //#third page part
        cartPage.checkTotalPrice();
        cartPage.verifyTotalPriceEqualsSelectedProductPrice();

    }
	/*
	Full Scenario
1. Launch Chrome browser
2. Navigate to http://demo.themeparrot.com/shopy/
3. Navigate to Catalog > Bracelets
4. Verify the opening of the correct page
5. Search for the text fa
6. Verify that the search results are relevant to the search done
7. Add the first displayed product to the cart
8. Open the cart and verify that the total price equals the price of the product in the search results
of the previous page
	 */


}