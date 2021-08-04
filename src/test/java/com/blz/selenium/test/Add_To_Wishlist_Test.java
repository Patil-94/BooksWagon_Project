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
public class Add_To_Wishlist_Test extends BaseClass {
    @Test(priority = 1, dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    public void addTo_wishlist_test(String username,String password) throws InterruptedException {
        LogClass.info("add to wishlist");
        Login_Page login_page = new Login_Page(driver);
        login_page.loginWith_Valid_Credentials(username,password);
        Home_Page homePage = new Home_Page(driver);
        homePage.addTo_cart();
        String actual_Title=homePage.addTo_cart();
        System.out.println(actual_Title);
        String expected_Title="Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual_Title ,expected_Title );
    }
}
