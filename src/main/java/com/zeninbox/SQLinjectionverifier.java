package com.zeninbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SQLinjectionverifier {

    public  SQLinjectionverifier() {

         WebDriver driver = driverfactory.getChromeDriver();

        try {
            // Open the sign-up page
            driver.get("https://staging.zeninbox.ai/sign-up"); // Update with the actual sign-up page URL

            driver.findElement(By.xpath(locators.firstNameField)).sendKeys(config.getProperty("firstname"));
            driver.findElement(By.xpath(locators.lastNameField)).sendKeys(config.getProperty("lastname"));
            driver.findElement(By.xpath(locators.emailField)).sendKeys(config.getProperty("sqlemail"));
            driver.findElement(By.xpath(locators.passwordField)).sendKeys(config.getProperty("password"));
            driver.findElement(By.xpath(locators.confirmpasswordField)).sendKeys(config.getProperty("confirmpassword"));
            driver.findElement(By.xpath(locators.termsbutton)).click();

            WebElement signUpButton = driver.findElement(By.xpath(locators.signup));

            // Check if the sign-up button is disabled
            boolean isButtonenabled = signUpButton.isEnabled();

            if (isButtonenabled) {
                signUpButton.click();
                System.out.println("TEST CASE FAILED: Sign-Up button is enabled.");

            } else {
                System.out.println("TEST CASE PASSED: Sign-Up button is disabled.");
            }

        } catch (Exception e) {

        } finally {
            // Close the browser
            driver.quit();
        }
    }

}
