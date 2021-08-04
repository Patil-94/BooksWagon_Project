package com.blz.selenium.base;

import com.blz.selenium.utility.EmailReport;
import com.blz.selenium.utility.LogClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    public static WebDriver driver;

    @BeforeTest
    @Feature("BrowserName and url for starting test")
    @Description("Used setUp method for setting the browser")
    @Severity(SeverityLevel.CRITICAL)
    public void setUp() throws InterruptedException {

        //Handling browser level show notification popup window
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");

        LogClass.info("Test is starting");
        //launch chromedriver
        WebDriverManager.chromedriver().setup();
        LogClass.info("chrome is starting");
        driver = new ChromeDriver();
        LogClass.info("navigating to url : https://www.bookswagon.com/");
        driver.get("https://www.bookswagon.com/");
        driver.manage().window().maximize();
        LogClass.info("Launched the web application.");
        Thread.sleep(5000);
    }

    @AfterTest
    @Feature("Closing application")
    @Description("Used tearDown method for closing the browser.")
    @Severity(SeverityLevel.CRITICAL)
    public void tearDown() {
        EmailReport.sendMail();
        LogClass.info("Browser is closed");
        driver.close();
        LogClass.info("Test is ended");
        Reporter.log("====Application Launched====");
    }
}

