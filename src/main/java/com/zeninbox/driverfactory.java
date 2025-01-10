package com.zeninbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class driverfactory {

    private static final String CHROME_DRIVER_PATH = "/home/anshumann/Desktop/chromedriver/chromedriver";

    public static WebDriver getChromeDriver() {
        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Return the configured WebDriver instance
        return new ChromeDriver(options);
    }
}
