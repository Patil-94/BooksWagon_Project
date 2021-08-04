package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.listener.CustomListener;
import com.blz.selenium.listener.DataProvider;
import com.blz.selenium.pages.Login_Page;
import com.blz.selenium.utility.Remove_From_Cart;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class Remove_Book_Test  extends BaseClass {
    @Test(priority = 4,dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    public void remove_book_test(String username,String password) throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        login_page.loginWith_Valid_Credentials(username,password);
        Remove_From_Cart removeFromCart = new Remove_From_Cart(driver);
        String actual_title = removeFromCart.remove_from_cart();
        System.out.println(actual_title);
        String expected_title = "c++ - Books - 24x7 online bookstore Bookswagon.com";
        Assert.assertEquals(actual_title, expected_title);
        System.out.println("book is removed successfully");
    }
}
