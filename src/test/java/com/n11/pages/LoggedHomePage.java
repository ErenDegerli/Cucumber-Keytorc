package com.n11.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHomePage extends Base {

    @FindBy(id = "searchData")
    private WebElement searchBox;

    public LoggedHomePage(WebDriver driver) {
        super(driver);
    }

    public void getSearch(String value) {
        waitUntilVisible(searchBox).sendKeys(value);
        searchBox.sendKeys(Keys.ENTER);
    }
}
