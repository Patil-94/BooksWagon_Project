package com.blz.selenium.utility;

import com.blz.selenium.base.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadObjectRepo extends BaseClass {


    public static String filePath = "config/objectrepofile.properties";

    public static String getLocatorProperty(String filePath, String key)throws IOException {

        String property = "";

        Properties properties = new Properties();// create object of prop.class
        try {

            properties.load(new FileInputStream(filePath));

            //getProperty fetches the value of target key from the properties file

            property = properties.getProperty(key);

        } catch (IOException exception ) {
            exception .printStackTrace();
        }
        return property;
    }
}
