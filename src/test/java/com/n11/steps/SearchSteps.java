package com.n11.steps;

import com.n11.core.TestBase;
import com.n11.pages.LoggedHomePage;
import com.n11.pages.ProductPage;
import com.n11.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchSteps extends TestBase {

    private LoggedHomePage loggedHomePage;
    private SearchPage searchPage;
    private ProductPage productPage;

    public SearchSteps() {
        this.loggedHomePage = new LoggedHomePage(driver);
        this.searchPage = new SearchPage(driver);
        this.productPage = new ProductPage(driver);
    }

    @When("Customer search with {string} word")
    public void customer_search_with_word(String value) {
        loggedHomePage.getSearch(value);
    }

    @Then("Customer should see {string} result message")
    public void customer_should_see_result_message(String resultMessage) {
        Assert.assertTrue(searchPage.getResultMsg().contains(resultMessage));
    }

    @When("Customer visit 2nd result page")
    public void customer_visit_2nd_result_page() {
        secondProductName = searchPage.getSecondProductTitle();
        searchPage.getSecondProduct();
    }

    @Then("Customer should see the exact product")
    public void customer_should_see_the_exact_product() {
        Assert.assertEquals(secondProductName, productPage.getTitleOfOpenedProduct());
    }

    @When("Customer should add to favourite 3rd product")
    public void customer_should_add_to_favourite_3rd_product() {
        productPage.goBackToSearchPage();
        thirdProductName = searchPage.getThirdProductTitle();
        searchPage.getThirdItemToFavouriteList();
    }
}