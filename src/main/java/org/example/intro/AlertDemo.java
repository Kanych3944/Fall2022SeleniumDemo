package org.example.intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDemo extends BaseTest {

    @Test
    public void testAlert1(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Helper.pause(3000);
    }

    @Test
    public void testExplicitWaitAndAlert(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("timerAlertButton"));
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void testThirdBtn (){
        driver.get("https://demoqa.com/alerts");
        WebElement thirdBtn = driver.findElement(By.id("confirmButton"));
        thirdBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement cancelText = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(cancelText.getText(), "You selected Cancel");
    }

    @Test
    public void testTextEnterAlert (){
        driver.get("https://demoqa.com/alerts");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement textEnterBtn = driver.findElement(By.id("promtButton"));
        textEnterBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Kanat");
        alert.accept();
        WebElement textTest = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(textTest.getText(), "You entered Kanat");
    }
}
