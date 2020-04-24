package com.n11.core;

import com.n11.driver.SetDriver;
import com.n11.pages.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected static WebDriver driver = SetDriver.initializeDriver();
    protected HomePage homePage = new HomePage(driver);
    protected SignInPage signInPage = new SignInPage(driver);
    protected LoggedHomePage loggedHomePage = new LoggedHomePage(driver);
    protected SearchPage searchPage = new SearchPage(driver);
    protected ProductPage productPage = new ProductPage(driver);
    protected WishListPage wishListPage = new WishListPage(driver);
    protected FavouritesPage favouritesPage = new FavouritesPage(driver);
    public static String secondProductName;
    public static String thirdProductName;

    public void tearDown() {
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
