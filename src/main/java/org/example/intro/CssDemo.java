package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CssDemo extends BaseTest {

    @Test
    public void cssTest1() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        WebElement appleText = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));
        System.out.println(appleText.getText());
        driver.findElement(By.xpath("//*[@id=\"brandsRefinements\"]ul/li[8]/span/div/a/span")).click();
        By brandsName =By.xpath("//li[contains(@id,'p_89/')]/span/a/div");
        By checkBoxes = By.xpath("/label/input");
        List<WebElement> allBrands = driver.findElements(brandsName);


        for (WebElement e : allBrands){
           if (e.getText().equals("OnePlus")){
               driver.findElement(brandsName).findElement(checkBoxes).click();
               break;

           }
           Thread.sleep(6000);
        }
    }

}
