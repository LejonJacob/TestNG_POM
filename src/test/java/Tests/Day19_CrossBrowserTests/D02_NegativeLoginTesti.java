package Tests.Day19_CrossBrowserTests;

import Utilities.ConfigReader;
import Utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D02_NegativeLoginTesti extends TestBaseCross {


    @Test
    public void negativeTest(){

        // MyCoursedemy anasayfaya gidin
        driver.get(ConfigReader.getProperty("myUrl"));

        // Login butonuna basin
        WebElement loginLinki=driver.findElement(By.xpath("//a[text()='Log in']"));
        loginLinki.click();


        // Email ve password icin gecersiz degerler girin
        driver.findElement(By.xpath("//input[@id='login-email']"))
                .sendKeys(ConfigReader.getProperty("myYanlisEmail"));

        driver.findElement(By.xpath("//input[@id='login-password']"))
                .sendKeys(ConfigReader.getProperty("myYanlisPassword"));

        // Login butonuna basin
        driver.findElement(By.xpath("//button[text()='Login']")).click();


        // Giris yapilamadigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Log in']")).isDisplayed());

    }

}