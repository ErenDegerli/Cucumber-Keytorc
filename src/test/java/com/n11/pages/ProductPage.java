package com.n11.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends Base {

    @FindBy(css = "h1[class='proName']")
    private WebElement productTitle;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleOfOpenedProduct() {
        return waitUntilVisible(productTitle).getText();
    }

    public void goBackToSearchPage() {
        driver.navigate().back();
    }
}