package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.pages.DashBoardPage;
import com.blz.selenium.pages.Home_Page;
import com.blz.selenium.pages.Login_Page;
import com.blz.selenium.utility.LogClass;
import org.testng.Assert;
import com.blz.selenium.listener.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class BuyBook_Test extends BaseClass {

    @Test(dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    public void buyBook_test(String username, String password) throws InterruptedException, IOException {
        Login_Page login_page = new Login_Page(driver);
        login_page.loginWith_Valid_Credentials(username, password);
        DashBoardPage books_wagon_page = new DashBoardPage(driver);
        String act_title = books_wagon_page.buy_test(driver);
        String exp_title = "Bookswagon.com: Buy Books Online: Bookstore in India: Highest Discount";
        Assert.assertEquals(act_title, exp_title);
        System.out.println("please login with details.");
    }


}

