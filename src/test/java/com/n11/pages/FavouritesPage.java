package com.n11.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavouritesPage extends Base {

    @FindBy(css = "h3[class='productName bold']")
    private WebElement favouriteItem;

    @FindBy(css = "span[class='deleteProFromFavorites']")
    private WebElement deleteBtn;

    @FindBy(css = "span[class='message']")
    private WebElement messageTextField;

    @FindBy(css = "span[class='closeBtn']")
    private WebElement closeBtn;

    public FavouritesPage(WebDriver driver) {
        super(driver);
    }

    public String getFavouriteProductName() {
        return favouriteItem.getText();
    }

    public void removeProductFromFavourites() {
        waitUntilClickable(deleteBtn).click();
    }

    public String getMessage() {
        return waitUntilVisible(messageTextField).getText();
    }

    public void closeMessageField() {
        waitUntilClickable(closeBtn).click();
    }
}
