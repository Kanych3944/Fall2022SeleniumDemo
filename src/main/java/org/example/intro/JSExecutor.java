package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutor extends BaseTest{

    @Test
    public void test1(){
        browserHelper.openURL("https://www.etsy.com/");
        WebElement careersLink = driver.findElement(By.xpath("//a[@href='https://www.etsy.com/careers?ref=ftr']"));
        Helper.jsClick(driver,careersLink);
        Helper.jsScrollDownThePage(driver, "350");
        Helper.pause(5000);
        Helper.jsScrollDownThePage(driver, "500");
        Helper.pause(5000);
    }
}
