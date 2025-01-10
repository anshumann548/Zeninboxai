package com.zeninbox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Duplicatemail {

    public void mailverfier() {

        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "/home/anshumann/Desktop/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");  // Fixed the reference to 'options'

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

            // Wait for the page to load (using WebDriverWait for better handling than Thread.sleep)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/form/div[2]/p")));

            // Check the current URL to verify if sign-up was successful
            String currentPage = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form/div[2]/p")).getText();

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
