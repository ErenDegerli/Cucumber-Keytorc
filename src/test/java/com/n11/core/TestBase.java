package com.n11.core;

import com.n11.driver.SetDriver;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected static WebDriver driver = SetDriver.initializeDriver();
    public static String secondProductName;
    public static String thirdProductName;

    public void tearDown() {
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
