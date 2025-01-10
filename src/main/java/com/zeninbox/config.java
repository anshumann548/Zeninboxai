package com.zeninbox;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class config {

    private static Properties properties = new Properties();

    static {
        try {
            // Getting the file from resources folder
            FileInputStream fileInputStream = new FileInputStream("./src/main/resources/config.properties");
            properties.load(fileInputStream);  // Load the file's content
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Method to fetch property value
    public static String getProperty(String key) {
        return properties.getProperty(key);  // Return the value for the given key
    }

}
