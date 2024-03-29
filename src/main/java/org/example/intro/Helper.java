package org.example.intro;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Helper {
    private static JavascriptExecutor js;

    public static void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void jsClick(WebDriver driver,WebElement element){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void jsScrollDownThePage(WebDriver driver, String pixels){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+ pixels +")", "");
    }

    public static void waitForElementToBeDisplayed(WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
    }

}
