package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.listener.CustomListener;
import com.blz.selenium.listener.DataProvider;
import com.blz.selenium.pages.DashBoardPage;
import com.blz.selenium.pages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class BuyBook_Test extends BaseClass {
    @Test(priority = 3,dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    public void buyBook_test(String username,String password) throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        login_page.loginWith_Valid_Credentials(username,password);
        DashBoardPage books_wagon_page = new DashBoardPage(driver);
        String act_title = books_wagon_page.buy_test(driver);
        String exp_title = "Bookswagon.com: Buy Books Online: Bookstore in India: Highest Discount";
        Assert.assertEquals(act_title,exp_title);
        System.out.println("please login with details.");
    }

}
