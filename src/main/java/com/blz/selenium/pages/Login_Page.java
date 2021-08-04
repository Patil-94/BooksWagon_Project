package com.blz.selenium.pages;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.utility.LogClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends BaseClass {

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement login_btn;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
    WebElement user_Email;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
    WebElement user_Pwd;

    @FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_btnLogin']")
    WebElement login;

    @FindBy(xpath = "//span[@class='login-bg sprite usermenu-bg']")
    WebElement myProfile;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logout;

    public Login_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String loginWith_Valid_Credentials(String username, String password) throws InterruptedException {
        LogClass.info("clicking on login");
        login_btn.click();
        Thread.sleep(1000);
        LogClass.info("Enter email id");
        user_Email.sendKeys(username);
        Thread.sleep(500);
        LogClass.info("Enter password");
        user_Pwd.sendKeys(password);
        Thread.sleep(500);
        LogClass.info("click on login button");
        login.click();
        LogClass.info("you're login successfully");
        return driver.getTitle();
    }

    public String loginTo_Invalid_Credentials() throws InterruptedException {
        LogClass.info("clicking on login");
        login_btn.click();
        Thread.sleep(1000);
        LogClass.info("Enter email id");
        user_Email.sendKeys("latikakhairnar@gmail.com");
        Thread.sleep(500);
        LogClass.info("Enter password");
        user_Pwd.sendKeys("latika123");
        LogClass.info("click on login button");
        login.click();
        LogClass.info("you're login Unsuccessfully");
        return driver.getTitle();
    }

    public String logout_ToApp() throws InterruptedException {
        Actions actions = new Actions(driver);//Action class handling mouse event
        Thread.sleep(2000);
        //Hovering on my account menu
        LogClass.info("Mouse hovering on my account menu");
        actions.moveToElement(myProfile).build().perform();//we are simply going to mouse over the myprofile
        LogClass.info("Clicking on sub menu logout");
        logout.click();
        LogClass.info("you're logout successfully");
        Thread.sleep(200);
        return driver.getTitle();
    }
}
