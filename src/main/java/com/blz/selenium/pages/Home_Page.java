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

    @FindBy(xpath = "//a[normalize-space()='Applied Data Science Using Pyspark']")
    WebElement book;

    @FindBy(xpath = "//input[@value='Add to Wishlist']")
    WebElement add_to_wishlist;

    @FindBy(xpath = "//div[@id='cboxClose']")
    WebElement checkbox;

    @FindBy(xpath = "//span[@class='cart-item-count']")
    WebElement cart;

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
}
