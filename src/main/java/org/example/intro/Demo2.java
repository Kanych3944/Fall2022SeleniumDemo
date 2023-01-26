package org.example.intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo2 {

    @Test
    public void testDemo2 (){
        Faker faker = new Faker();

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        WebElement submitButton = driver.findElement(By.id("submit"));


        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String currentAddress1 = faker.address().fullAddress();
        String permanentAddress2 = faker.address().secondaryAddress();

        fullNameInputField.sendKeys(fullName);
        userEmail.sendKeys(email);
        currentAddress.sendKeys(currentAddress1);
        permanentAddress.sendKeys(permanentAddress2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        submitButton.click();

        String actualName = driver.findElement(By.id("name")).getText();
        String expectedName = fullNameInputField.getAttribute("value");
        Assert.assertTrue(actualName.contains(expectedName));

        String actualEmail = driver.findElement(By.id("email")).getText();
        String expectedEmail = userEmail.getAttribute("value");
        Assert.assertTrue(actualEmail.contains(expectedEmail));

        String actualCurrentAddress = driver.findElement(By.xpath("//p[@id=\"currentAddress\"]")).getText();
        String expectedCurrentAddress = currentAddress.getAttribute("value");
        Assert.assertTrue(actualCurrentAddress.contains(expectedCurrentAddress));

        String actualPermanentAddress = driver.findElement(By.xpath("//p[@id=\"permanentAddress\"]")).getText();
        String expectedPermanentAddress = permanentAddress.getAttribute("value");
        Assert.assertTrue(actualPermanentAddress.contains(expectedPermanentAddress));



    }

}
