package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.objectrepository.LoginPage;
import com.blz.selenium.utility.LogClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ObjectRepoLoginTest extends BaseClass {

    @Test
    public void login_Application() throws IOException, InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.loginTo_Application();
        String actual = login.loginTo_Application();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual,expected);
        LogClass.info("Checking actual and expected title");
        System.out.println("You are successfully login");

    }

}
