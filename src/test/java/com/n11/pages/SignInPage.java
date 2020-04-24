package com.n11.pages;

import com.n11.configuration.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class SignInPage extends Base {

    @FindBy(id = "email")
    private WebElement emailTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxtBox;

    @FindBy(css = "div#loginButton.green_flat")
    private WebElement loginBtn;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void getLogIn(String email, String password) {
        waitUntilVisible(emailTxtBox).sendKeys(email);
        passwordTxtBox.sendKeys(password);
        loginBtn.click();
    }
}
