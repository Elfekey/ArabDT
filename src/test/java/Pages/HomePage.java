package Pages;

import Utilities.GeneralMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    GeneralMethods generalMethods;

    //Elements
    @FindBy(xpath = " //a[contains(@class,'dropdown-toggle')][normalize-space()='Catalog']")
    private WebElement catalog;
    @FindBy(xpath = "//a[@itemprop='url'][normalize-space()='Bracelets']")
    private WebElement bracelets;

    //methods
    public void gotoBraceletsPage() {
        generalMethods = new GeneralMethods();
        generalMethods.clickAnElement(catalog);
        bracelets.click();
    }

}
