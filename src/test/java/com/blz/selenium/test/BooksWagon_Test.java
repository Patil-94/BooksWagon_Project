package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.listener.CustomListener;
import com.blz.selenium.pages.Login_Page;
import com.blz.selenium.listener.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class BooksWagon_Test extends BaseClass  {
    @Test(priority = 5,dataProvider = "LoginDetails", dataProviderClass = DataProvider.class)
    public void logout_Application(String username,String password) throws InterruptedException {
        Login_Page login_page = new Login_Page(driver);
        login_page.loginWith_Valid_Credentials(username, password);
        login_page.logout_ToApp();
    }
}

