package com.saucelabs.simplesauce.examples;

import org.openqa.selenium.WebDriver;

/**
 * Stand-in page object class for demo purposes. Details and implementation are not important.
 */
public class MyPageObject {

    private WebDriver driver;

    public MyPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void visit() {
        this.driver.get("https://www.saucedemo.com");
    }

    public void login() {
        // login logic
    }

    public boolean loginSuccessfully(){
        return true;
    }
}
