package com.blz.selenium.pages;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.utility.LogClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoardPage extends BaseClass {

    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_txtSearch']")
    WebElement searchBar;

    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
    WebElement searchEnter;

    @FindBy(xpath = "//div[@id='listSearchResult']")
    List<WebElement> searchList;

    @FindBy(xpath = "//div[1]//div[4]//div[5]//a[2]//input[1]")
    WebElement add_to_wishlist;

    @FindBy(xpath = "//span[@class='cart-item-count']")
    WebElement cart;

    @FindBy(xpath = "//div[@id='cboxClose']")
    WebElement checkbox;

    @FindBy(xpath = "/html/body/form/div[4]/div[2]/div[3]/div[2]/div[2]/div[4]/div[5]/a[1]/input")
    WebElement buy_now;

    @FindBy(name = "BookCart$lvCart$ctrl0$txtQty")
    WebElement quantity;

    @FindBy(name = "BookCart$lvCart$imgPayment")
    WebElement place_order;

    @FindBy(xpath = "//a[normalize-space()='Remove']")
    WebElement remove_from_cart;

    public DashBoardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String add_to_wishlist_books(String username, String password) throws InterruptedException {
        searchBar.click();
        Thread.sleep(1000);
        searchBar.sendKeys("C++");
        Thread.sleep(2000);
        searchEnter.click();
        Thread.sleep(1000);
        System.out.println(searchList.size());
        Thread.sleep(2000);
        for (WebElement webElement : searchList) {
            String properties_name = webElement.getText();
            Thread.sleep(2000);
            System.out.println(properties_name);
        }
        Thread.sleep(2000);
        LogClass.info("print all properties");
        System.out.println(searchList.get(0).getText());
        Thread.sleep(3000);
        searchList.get(0).click();
        Thread.sleep(4000);
        add_to_wishlist.click();
        Thread.sleep(5000);
        Login_Page loginPage =new Login_Page(driver );
        loginPage.loginWith_Valid_Credentials(username,password);
        cart.click();
        Thread.sleep(3000);
        LogClass.info("click on checkbox button");
        checkbox.click();
        return driver.getTitle();
    }

    public String buy_test(WebDriver webdriver) throws InterruptedException {
        searchBar.click();
        Thread.sleep(1000);
        searchBar.sendKeys("C++");
        Thread.sleep(2000);
        searchEnter.click();
        Thread.sleep(1000);

        System.out.println(searchList.size());
        Thread.sleep(2000);
        for (WebElement webElement : searchList) {
            String books_name = webElement.getText();
            Thread.sleep(2000);
            System.out.println(books_name);
        }
        Thread.sleep(2000);

        System.out.println(searchList.get(0).getText());
        Thread.sleep(3000);
        searchList.get(0).click();
        Thread.sleep(4000);
        buy_now.click();
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        quantity.clear();
        quantity.sendKeys("5");
        Thread.sleep(3000);
        place_order.click();
        Thread.sleep(500);
        webdriver.switchTo().parentFrame();
        Thread.sleep(2000);
        LogClass.info("print Title");
        return driver.getTitle();
    }

    public String remove_from_cart() throws InterruptedException {
        LogClass.info("Remove from the cart");
        searchBar.click();
        Thread.sleep(1000);
        searchBar.sendKeys("C++");
        Thread.sleep(2000);
        searchEnter.click();
        Thread.sleep(1000);
        System.out.println(searchList.size());
        Thread.sleep(2000);
        searchList.get(0).click();
        Thread.sleep(4000);
        buy_now.click();
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        Thread.sleep(4000);
        remove_from_cart.click();
        Thread.sleep(2000);
        return driver.getTitle();
    }
}

