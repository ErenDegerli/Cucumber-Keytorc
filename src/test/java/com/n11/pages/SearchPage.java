package com.n11.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Base {

    @FindBy(css = "[class='resultText ']")
    private WebElement resultMessageText;

    @FindBy(xpath = "//*[@id='view']/ul/li[2]/div/div[1]/a")
    private WebElement secondProduct;

    @FindBy(xpath = "//*[@id='view']/ul/li[3]/div/div[1]/a/h3")
    private WebElement thirdProduct;

    @FindBy(xpath = "//*[@id='view']/ul/li[3]/div/div[1]/span")
    private WebElement addThirdProductToFavourite;

    @FindBy(css = "div[class='myAccount']")
    private WebElement myAccount;

    @FindBy(css = "a[href='//www.n11.com/hesabim/istek-listelerim']")
    private WebElement favourites;

    @FindBy(css = "[title='Favorilerim / Listelerim']")
    private WebElement myFavoriteButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getResultMsg() {
        return waitUntilVisible(resultMessageText).getText();
    }

    public void getSecondProduct() {
        waitUntilClickable(secondProduct).click();
    }

    public String getSecondProductTitle() {
        return secondProduct.getText();
    }

    public String getThirdProductTitle() {
        return waitUntilVisible(thirdProduct).getText();
    }

    public void getThirdItemToFavouriteList() {
        waitUntilClickable(addThirdProductToFavourite).click();
    }

    public void goToMyWishPage() {
        js.executeScript("arguments[0].scrollIntoView(true);", myAccount);
        mouseOver(myAccount);
        waitUntilClickable(myFavoriteButton).click();
    }
}