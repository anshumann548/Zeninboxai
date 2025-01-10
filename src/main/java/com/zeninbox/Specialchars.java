package com.zeninbox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Specialchars {

    public Specialchars() {

        WebDriver driver = driverfactory.getChromeDriver();

        try {
            // Open the sign-up page
            driver.get("https://staging.zeninbox.ai/sign-up"); // Update with the actual sign-up page URL

            // Locate the fields for the sign-up form
            driver.findElement(By.xpath(locators.firstNameField)).sendKeys(config.getProperty("specialfirstname"));
            driver.findElement(By.xpath(locators.lastNameField)).sendKeys(config.getProperty("speciallastname"));
            driver.findElement(By.xpath(locators.emailField)).sendKeys(config.getProperty("email"));
            driver.findElement(By.xpath(locators.passwordField)).sendKeys(config.getProperty("password"));
            driver.findElement(By.xpath(locators.confirmpasswordField)).sendKeys(config.getProperty("confirmpassword"));
            driver.findElement(By.xpath(locators.termsbutton)).click();

            WebElement signUpButton = driver.findElement(By.xpath(locators.signup));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(signUpButton));

            signUpButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.otppagetext))); //waiting for otp page loading and verifying with text over that page after clicking signup

            // Check the current URL to verify if sign-up was successful
            String currentPage = driver.findElement(By.xpath(locators.otppagetext)).getText();
            if (currentPage.contains("OTP")) {
                System.out.println("Test case failed");
            } else {
                System.out.println("Test case passed");
            }

            Thread.sleep(3000);

        } catch (InterruptedException e) {
        } finally {
          driver.quit();
        }
    }
}
