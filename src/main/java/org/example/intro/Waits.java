package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Waits extends BaseTest{

    @Test
    public void testExplicitWait (){
        driver.navigate().to("https://demoqa.com/dynamic-properties");
        WebElement enableAfter = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(enableAfter)).click();
        wait.until(ExpectedConditions.attributeContains(By.id("colorChange"),"class", "text-danger"));
        WebElement colorChange = driver.findElement(By.id("colorChange"));
        colorChange.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter"))).click();
    }

    @Test
    public void etsySignIn (){
        driver.navigate().to("https://etsy.com/");
        WebElement signIn = driver.findElement(By.xpath("//button[contains(text(), 'Sign in'"));
        signIn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("join-neu-overlay-title")));
    }
}
