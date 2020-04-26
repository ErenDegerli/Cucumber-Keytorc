package com.n11.pages;

import com.n11.configuration.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class HomePage extends Base {

    @FindBy(css = "a[class='btnSignIn']")
    private WebElement signInBtn;

    @FindBy(css = "div[class='content'] span")
    private WebElement closeBtn;

    @FindBy(css = "span[class='hLogoT']")
    private WebElement pageTitle;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void getHomePage() {
        try {
            driver.get(Config.getValue("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getSignInPage() throws InterruptedException {
        waitUntilClickable(closeBtn).click();
        Thread.sleep(1000);
        waitUntilClickable(signInBtn).click();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }
}