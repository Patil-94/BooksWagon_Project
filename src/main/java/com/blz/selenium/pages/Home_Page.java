package com.blz.selenium.pages;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.utility.LogClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page extends BaseClass {

    @FindBy(xpath = "//a[@class='sprite home-ico toplevel oneline']")
    WebElement home;

    @FindBy(xpath = "//div[@class='books-category']//a[normalize-space()='Computer & Internet']")
    WebElement computer_nd_internet;

    @FindBy(xpath = "//img[@alt='Applied Data Science Using Pyspark']")
    WebElement book;

    @FindBy(xpath = "//input[@value='Add to Wishlist']")
    WebElement add_to_wishlist;

    @FindBy(xpath = "//div[@id='cboxClose']")
    WebElement checkbox;

    @FindBy(xpath = "//span[@class='cart-item-count']")
    WebElement cart;

    @FindBy(xpath = "//ul[@class='ac-tabs']//a[normalize-space()='My Addresses']")
    WebElement addresses;

    @FindBy(xpath = "//input[@value='Add a New Address']")
    WebElement add_new;

    @FindBy(xpath = "//input[@id='ctl00_phBody_ShippingAddress_imgSubmit']")
    WebElement save_address;

    @FindBy(linkText = "Change Password")
    WebElement password;

    @FindBy(xpath = "//input[@id='ctl00_phBody_ChangePassword_txtNewPassword']")
    WebElement new_Pwd;

    @FindBy(xpath = " //input[@id='ctl00_phBody_ChangePassword_txtConfirmPwd']")
    WebElement confirm_Pwd;

    @FindBy(xpath = "//input[@id='ctl00_phBody_ChangePassword_imgSubmit']")
    WebElement save_Btn;


    public Home_Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String addTo_cart() throws InterruptedException {
        LogClass.info("click on home icon");
        home.click();
        Thread.sleep(1000);
        LogClass.info("click on category");
        computer_nd_internet.click();
        Thread.sleep(1000);
        LogClass.info("click on books");
        book.click();
        Thread.sleep(2000);
        LogClass.info("click on add to wishlist");
        add_to_wishlist.click();
        Thread.sleep(4000);
        LogClass.info("click on card");
        cart.click();
        Thread.sleep(3000);
        LogClass.info("click on checkbox button");
        checkbox.click();
        Thread.sleep(5000);
        return driver.getTitle();
    }

    public String adding_address() throws InterruptedException {
        addresses.click();
        Thread.sleep(1000);
        add_new.click();
        Thread.sleep(1000);
        save_address.click();
        Thread.sleep(1000);
        return driver.getTitle();
    }

    public String change_password() throws InterruptedException {
        password .click();
        Thread.sleep(1000);
        new_Pwd .sendKeys("latika");
        Thread.sleep(1000);
        confirm_Pwd.sendKeys("latika");
        Thread.sleep(1000);
        save_Btn.click();
        return driver.getTitle();
    }
}
