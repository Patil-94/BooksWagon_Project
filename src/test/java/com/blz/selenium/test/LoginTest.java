package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.listener.CustomListener;
import com.blz.selenium.listener.DataProvider;
import com.blz.selenium.pages.DashBoardPage;
import com.blz.selenium.pages.Home_Page;
import com.blz.selenium.pages.Login_Page;
import com.blz.selenium.utility.LogClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class LoginTest extends BaseClass {

    @Test(dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    public void login_test(String username,String password) throws InterruptedException {
        LogClass.info("Login with valid credentials");
        Login_Page login_page = new Login_Page(driver);
        String actual = login_page.loginWith_Valid_Credentials(username,password);
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual,expected);
        LogClass.info("Checking actual and expected title");
        System.out.println("You are successfully login");
    }


}
