package org.example.intro;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UploadDownloadDemo extends BaseTest{

    @Test
    public void test1 (){
        driver.navigate().to("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("C:/Users/DevX/Pictures/Saved Pictures/ba2022.jpg");
        Helper.pause(5000);
    }
}
