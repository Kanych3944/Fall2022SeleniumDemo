package org.example.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomeWork extends BaseTest{

    @Test
    public void checkData(){
        driver.get("https://demoqa.com/webtables");

        User kanat = new User("Kanat","Keneshov","kanych@gmail.com",30,4000,"Barcelona");
        List<User> data = new ArrayList<>();
        data.add(kanat);

        List<WebElement> containerOfData = driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys(kanat.name);
        driver.findElement(By.id("lastName")).sendKeys(kanat.lastName);
        driver.findElement(By.id("userEmail")).sendKeys(kanat.email);
        driver.findElement(By.id("age")).sendKeys(String.valueOf(kanat.age));
        driver.findElement(By.id("salary")).sendKeys(String.valueOf(kanat.salary));
        driver.findElement(By.id("department")).sendKeys(kanat.department);
        driver.findElement(By.id("submit")).click();
        Helper.pause(4000);

        String getAge = driver.findElement(By.xpath("(//div[@class='rt-tr -even'])[2]/div[3]")).getText();

        for (WebElement e: containerOfData){
            if (e.getText().contains(kanat.name)){
                Assert.assertTrue(e.getText().contains(kanat.name));
            }

            int n = Integer.parseInt(getAge);
            if (n == kanat.age){
                Assert.assertEquals(30, kanat.age);
            }
        }
    }

}
