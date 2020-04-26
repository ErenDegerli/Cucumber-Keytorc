package com.n11.steps;

import com.n11.core.TestBase;
import com.n11.pages.FavouritesPage;
import com.n11.pages.SearchPage;
import com.n11.pages.WishListPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyFavouritesSteps extends TestBase {

    private SearchPage searchPage;
    private WishListPage wishListPage;
    private FavouritesPage favouritesPage;

    public MyFavouritesSteps() {
        this.searchPage = new SearchPage(driver);
        this.wishListPage = new WishListPage(driver);
        this.favouritesPage = new FavouritesPage(driver);
    }

    @Then("Customer should see product on Favourite List")
    public void customer_should_see_product_on_Favourite_List() {
        searchPage.goToMyWishPage();
        wishListPage.goToFavourites();
        Assert.assertEquals(thirdProductName, favouritesPage.getFavouriteProductName());
    }

    @When("Customer should remove added favorite product from Favourite List")
    public void customer_should_remove_added_favourite_product_from_Favorite_List() {
        favouritesPage.removeProductFromFavourites();
    }

    @Then("Customer should see {string} success message")
    public void customer_should_see_success_message(String message) {
        Assert.assertEquals(message, favouritesPage.getMessage());
        favouritesPage.closeMessageField();

    }
    @And("Customer should see the product is removed from Favourite List")
    public void customer_should_see_the_product_is_removed_from_Favourite_List() {
        Assert.assertTrue(wishListPage.getFavouritesTitle().contains("0"));
        tearDown();
    }
}