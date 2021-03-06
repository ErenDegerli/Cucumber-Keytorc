package com.n11.steps;

import com.n11.core.TestBase;
import com.n11.pages.HomePage;
import com.n11.pages.SignInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps extends TestBase {

    private HomePage homePage;
    private SignInPage signInPage;

    public LoginSteps() {
        this.homePage = new HomePage(driver);
        this.signInPage = new SignInPage(driver);
    }

    @Given("Visitor is on the HomePage")
    public void visitor_is_on_the_HomePage() {
        homePage.getHomePage();
    }

    @When("Customer login with {string} email and {string} password")
    public void customer_login_with_email_and_password(String email, String password) throws InterruptedException {
        homePage.getSignInPage();
        signInPage.getLogIn(email, password);
    }

    @Then("Customer should see the page title as {string} on HomePage")
    public void customer_should_see_the_page_title_as_on_HomePage(String title) {
        Assert.assertEquals(title, homePage.getPageTitle());
    }
}