package com.blz.selenium.objectrepository;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.utility.LogClass;
import com.blz.selenium.utility.ReadObjectRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends BaseClass {
    @FindBy(linkText = "Login")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
    WebElement user_Email;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
    WebElement user_Pwd;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_btnLogin']")
    WebElement login;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String  loginTo_Application() throws InterruptedException, IOException {
        LogClass.info("clicking on login");
        loginBtn.click();
        Thread.sleep(2000);
        LogClass.info("Enter email id");
        user_Email.sendKeys(ReadObjectRepo.getLocatorProperty(ReadObjectRepo.filePath,"username")) ;
        Thread.sleep(2000);
        LogClass.info("Enter password");
        user_Pwd.sendKeys(ReadObjectRepo.getLocatorProperty(ReadObjectRepo.filePath,"password")) ;
        Thread.sleep(2000);
        LogClass.info("click on login button");
        login.click();
        Thread.sleep(4000);
        return driver.getTitle();
    }
}

