package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.listener.DataProvider;
import com.blz.selenium.pages.DashBoardPage;
import com.blz.selenium.pages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveBook_From_Cart  extends BaseClass {
    @Test(dataProvider = "LoginDetails", dataProviderClass = DataProvider.class,priority = 2)
    public void remove_book_test(String username,String password) throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        login_page.loginWith_Valid_Credentials(username,password);
        DashBoardPage books_wagon_page = new DashBoardPage(driver);
        String actual_title = books_wagon_page.remove_from_cart();
        System.out.println(actual_title);
        String expected_title = "c++ - Books - 24x7 online bookstore Bookswagon.com";
        Assert.assertEquals(actual_title, expected_title);
        System.out.println("book is removed successfully");
    }
}
