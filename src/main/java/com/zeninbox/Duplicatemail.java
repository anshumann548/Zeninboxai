package com.zeninbox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Duplicatemail {

    public Duplicatemail() {
        WebDriver driver = driverfactory.getChromeDriver();
        try {
            // Open the sign-up page
            driver.get("https://staging.zeninbox.ai/sign-up"); // Update with the actual sign-up page URL

            driver.findElement(By.xpath(locators.firstNameField)).sendKeys(config.getProperty("firstname"));
            driver.findElement(By.xpath(locators.lastNameField)).sendKeys(config.getProperty("lastname"));
            driver.findElement(By.xpath(locators.emailField)).sendKeys(config.getProperty("duplicateemail"));
            driver.findElement(By.xpath(locators.passwordField)).sendKeys(config.getProperty("password"));
            driver.findElement(By.xpath(locators.confirmpasswordField)).sendKeys(config.getProperty("confirmpassword"));
            driver.findElement(By.xpath(locators.termsbutton)).click();

            WebElement signUpButton = driver.findElement(By.xpath(locators.signup));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
            signUpButton.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.signupvalidation)));

            // Check the current URL to verify if sign-up was successful
            String currentPage = driver.findElement(By.xpath(locators.signupvalidation)).getText();

            if (currentPage.contains("already exist")) {
                System.out.println("Test case passed");
            } else {
                System.out.println("Test case failed");
            }

        } catch (Exception e) {
        } finally {
            driver.quit();
        }
    }
}
