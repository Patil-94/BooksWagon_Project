package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.listener.DataProvider;
import com.blz.selenium.pages.DashBoardPage;
import com.blz.selenium.utility.LogClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashBoard_Test extends BaseClass {
    @Test(dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    public void searchBook_test(String username,String password ) throws InterruptedException {
        DashBoardPage bookswagon_page = new DashBoardPage(driver);
        String actual = bookswagon_page.add_to_wishlist_books(username,password);
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual,expected);
        LogClass.info("Checking title actual and expected");
        System.out.println("Please login first!");
    }


}
