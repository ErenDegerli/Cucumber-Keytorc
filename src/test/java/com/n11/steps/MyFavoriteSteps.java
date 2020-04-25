package com.n11.steps;

import com.n11.core.TestBase;
import com.n11.pages.FavouritesPage;
import com.n11.pages.SearchPage;
import com.n11.pages.WishListPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;

public class MyFavoriteSteps extends TestBase {

    private SearchPage searchPage;
    private WishListPage wishListPage;
    private FavouritesPage favouritesPage;

    public MyFavoriteSteps() {
        this.searchPage = new SearchPage(driver);
        this.wishListPage = new WishListPage(driver);
        this.favouritesPage = new FavouritesPage(driver);
    }

    @Then("Customer should see product on Favorite List")
    public void customerShouldSeeProductOnFavoriteList() {
        searchPage.goToMyWishPage();
        wishListPage.goToFavourites();
        Assert.assertEquals(thirdProductName,favouritesPage.getFavouriteProductName());
    }

    @When("Customer should remove added favorite product from Favorite List")
    public void customer_should_remove_added_favorite_product_from_Favorite_List() {
        favouritesPage.removeProductFromFavourites();
    }

    @Then("Customer should see {string} success message and removed favorite product from Favorite List")
    public void customer_should_see_success_message_and_removed_favorite_product_from_Favorite_List(String message) {
        Assert.assertEquals( message, favouritesPage.getMessage());
        favouritesPage.closeMessageField();
        Assert.assertTrue(wishListPage.getFavouritesTitle().contains("0"));
        tearDown();
    }
}
