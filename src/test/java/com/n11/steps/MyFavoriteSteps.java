package com.n11.steps;

import com.n11.core.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyFavoriteSteps extends TestBase {

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
