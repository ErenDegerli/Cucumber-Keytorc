package com.n11.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends Base {

    @FindBy(css = "div[class='listItemWrap'] a")
    private WebElement myFavourites;

    @FindBy(css = "h4[class='listItemTitle']")
    private WebElement favouritesTitle;

    @FindBy(linkText = "Favorilerim / Listelerim")
    private WebElement favourites;

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public void goToFavourites() {
        waitUntilVisible(myFavourites).click();
    }

    public String getFavouritesTitle() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitUntilClickable(favourites).click();
        return waitUntilVisible(favouritesTitle).getText();
    }
}
