package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.listener.CustomListener;
import com.blz.selenium.pages.Login_Page;
import com.blz.selenium.utility.LogClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class Invalid_Login_Test extends BaseClass {

    @Test(priority =6)
    public void login_negative_test() throws InterruptedException {
        LogClass.info("Login with Invalid credentials");
        Login_Page login_page = new Login_Page(driver);
        String actual_title = login_page.loginTo_Invalid_Credentials();
        String expected_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual_title,expected_title);
        LogClass.info("Please enter valid credentials");
        System.out.println("Invalid email or password");
    }
}
