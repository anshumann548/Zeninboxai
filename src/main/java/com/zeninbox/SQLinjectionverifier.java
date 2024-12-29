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
            emailField.sendKeys(" ' OR 1=1 --");

            passwordField.clear();
            passwordField.sendKeys("Passdd@123");

            confirmpasswordField.clear();
            confirmpasswordField.sendKeys("Passdd@123");

            // Click the terms checkbox
            termsCheckbox.click();

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

    public static void main(String[] args) {
        SQLinjectionverifier verifier = new SQLinjectionverifier();
        verifier.SQLverfier();
    }
}
