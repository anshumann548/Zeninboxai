package com.zeninbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SQLinjectionverifier {

    public void SQLverfier() {

        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "/home/anshumann/Desktop/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Declare driver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open the sign-up page
            driver.get("https://staging.zeninbox.ai/sign-up"); // Update with the actual sign-up page URL

            driver.findElement(By.xpath(locators.firstNameField)).sendKeys(config.getProperty("firstname"));
            driver.findElement(By.xpath(locators.lastNameField)).sendKeys(config.getProperty("lastname"));
            driver.findElement(By.xpath(locators.emailField)).sendKeys(config.getProperty("email"));
            driver.findElement(By.xpath(locators.passwordField)).sendKeys(config.getProperty("password"));
            driver.findElement(By.xpath(locators.confirmpasswordField)).sendKeys(config.getProperty("confirmpassword"));
            driver.findElement(By.xpath(locators.termsbutton)).click();

            WebElement signUpButton;
            (signUpButton = driver.findElement(By.xpath(locators.signup))).click();

            // Check if the sign-up button is disabled
            boolean isButtonDisabled = !signUpButton.isEnabled();

            if (isButtonDisabled) {
                System.out.println("TEST CASE PASSED: Sign-Up button is disabled.");
            } else {
                System.out.println("TEST CASE FAILED: Sign-Up button is enabled.");
            }

        } catch (Exception e) {

        } finally {
            // Close the browser
            driver.quit();
        }
    }

}
