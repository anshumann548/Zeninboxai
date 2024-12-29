package com.zeninbox ;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

            // Locate the fields for the sign-up form
            WebElement firstNameField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div[1]/div[1]/div/input"));
            WebElement lastNameField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div[1]/div[2]/div/input"));
            WebElement emailField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div[2]/div/input"));
            WebElement passwordField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div[3]/div/div/input"));
            WebElement confirmpasswordField = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div[4]/div/div/input"));
            WebElement termsCheckbox = driver.findElement(By.xpath("//*[@id='terms']"));
            WebElement signUpButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/form/div[6]/button"));

            // Fill out the form with special characters in first name and last name
            firstNameField.clear();
            firstNameField.sendKeys("John@Doe#");

            lastNameField.clear();
            lastNameField.sendKeys("Doe$%^");

            emailField.clear();
            emailField.sendKeys("frema+1@yopmail.com");

            passwordField.clear();
            passwordField.sendKeys("Passdd@123");

            confirmpasswordField.clear();
            confirmpasswordField.sendKeys("Passdd@123");

            // Click the terms checkbox
            termsCheckbox.click();

            // Click the Sign-Up button
            signUpButton.click();

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

