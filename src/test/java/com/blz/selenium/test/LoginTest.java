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
    @Test
   // @Test(dataProvider = "LoginDetails", dataProviderClass = DataProvider.class,priority = 1)
    public void buyBook_test() throws InterruptedException {
        /*Login_Page login_page = new Login_Page(driver);
        login_page.loginWith_Valid_Credentials(username,password);*/
        DashBoardPage books_wagon_page = new DashBoardPage(driver);
        String act_title = books_wagon_page.buy_test(driver);
        String exp_title = "Bookswagon.com: Buy Books Online: Bookstore in India: Highest Discount";
        Assert.assertEquals(act_title,exp_title);
        System.out.println("please login with details.");
    }



   /* @Test(priority = 1, dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    public void addTo_wishlist_test() throws InterruptedException {
        LogClass.info("add to wishlist");
        Home_Page homePage = new Home_Page(driver);
        homePage.addTo_cart();
        String actual_Title=homePage.addTo_cart();
        System.out.println(actual_Title);
        String expected_Title="Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual_Title ,expected_Title );
    }*/
}
