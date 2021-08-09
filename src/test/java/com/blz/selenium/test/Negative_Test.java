package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.listener.CustomListener;
import com.blz.selenium.listener.DataProvider;
import com.blz.selenium.pages.Home_Page;
import com.blz.selenium.pages.Login_Page;
import com.blz.selenium.utility.LogClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class Negative_Test extends BaseClass {

    @Test(priority = 6)
    public void login_negative_test() throws InterruptedException {
        LogClass.info("Login with Invalid credentials");
        Login_Page login_page = new Login_Page(driver);
        String actual_title = login_page.loginTo_Invalid_Credentials();
        String expected_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual_title,expected_title);
        LogClass.info("Please enter valid credentials");
        System.out.println("Invalid email or password");
    }

    @Test(dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    public void address_blank_test(String username, String password) throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        login_page.loginWith_Valid_Credentials(username, password);
        Home_Page homePage = new Home_Page(driver);
        String actual_title = homePage.adding_address();
        String expected_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual_title, expected_title);
        LogClass.warn("required fields can't be empty");
        System.out.println("fields can not be empty");
    }


    @Test(dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    public void change_password_test(String username, String password) throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        login_page.loginWith_Valid_Credentials(username, password);
        Home_Page homePage = new Home_Page(driver);
        String actual_title = homePage.change_password();
        String expected_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual_title, expected_title);
        LogClass.warn("required fields can't be empty");
        System.out.println("fields can not be empty");
    }
}
