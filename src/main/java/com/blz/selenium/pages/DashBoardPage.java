package com.blz.selenium.pages;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.utility.LogClass;
import com.blz.selenium.objectrepository.ReadObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
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

    @FindBy(xpath = "/html/body/form/div[3]/div[3]/div[2]/div[1]/div[2]/div/div/div/a")
    WebElement Continue;

    @FindBy(name = "ctl00$cpBody$txtNewRecipientName")
    WebElement recipient_name;

    @FindBy(name = "ctl00$cpBody$txtNewAddress")
    WebElement recipient_address;

    @FindBy(xpath = "//select[@id='ctl00_cpBody_ddlNewCountry']//option[@value='India'][normalize-space()='India']")
    WebElement recipient_country;

    @FindBy(xpath = "//select[@id='ctl00_cpBody_ddlNewState']//option[@value='Maharashtra'][normalize-space()='Maharashtra']")
    WebElement recipient_state;

    @FindBy(xpath = "//option[@value='Nashik']")
    WebElement recipient_city;

    @FindBy(name = "ctl00$cpBody$txtNewPincode")
    WebElement recipient_pincode;

    @FindBy(name = "ctl00$cpBody$txtNewMobile")
    WebElement recipient_mobile;

    @FindBy(name = "ctl00$cpBody$imgSaveNew")
    WebElement submit_details;

    @FindBy(xpath = "//input[@id='ctl00_cpBody_ShoppingCart_lvCart_savecontinue']")
    WebElement save_and_continue;

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

    public String buy_test(WebDriver webdriver) throws InterruptedException, IOException {
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
        Continue.click();
        Thread.sleep(500);
        LogClass.info("sending name");
        recipient_name.sendKeys(ReadObjectRepo.getLocatorProperty(ReadObjectRepo.filePath,"name"));
        Thread.sleep(1000);
        LogClass.info("sending addresss");
        recipient_address.sendKeys(ReadObjectRepo.getLocatorProperty(ReadObjectRepo.filePath,"address"));
        Thread.sleep(500);
        LogClass.info("selecting country option");
        recipient_country.click();
        Thread.sleep(500);
        LogClass.info("selecting state option");
        recipient_state.click();
        Thread.sleep(500);
        LogClass.info("selecting city option");
        recipient_city.click();
        Thread.sleep(500);
        LogClass.info("sending pincode");
        recipient_pincode.sendKeys(ReadObjectRepo.getLocatorProperty(ReadObjectRepo.filePath,"pinCode"));
        Thread.sleep(500);
        LogClass.info("sending mobile number");
        recipient_mobile.sendKeys(ReadObjectRepo.getLocatorProperty(ReadObjectRepo.filePath,"mobile"));
        Thread.sleep(500);
        LogClass.info("click on submit button");
        submit_details.click();
        Thread.sleep(1500);
        LogClass.info("click on save and continue button");
        save_and_continue.click();
        Thread.sleep(1000);
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

