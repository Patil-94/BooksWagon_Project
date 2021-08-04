package com.blz.selenium.listener;

import com.blz.selenium.utility.ExcelUtils;

import java.io.IOException;

public class DataProvider {
    //A dataProvider method with return type as 2D Array
    @org.testng.annotations.DataProvider(name = "LoginDetails")

    public  Object[][] getDataFromProvider() throws IOException {

        Object data[][]= ExcelUtils.getTestData("Sheet1");
        return data;
    }
}
