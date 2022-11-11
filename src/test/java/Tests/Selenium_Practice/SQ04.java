package Tests.Selenium_Practice;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SQ04 {

    /*

     1- Navigate to https://www.saucedemo.com/
     2- Enter the username as standard_user
     3- Enter the password as secret_sauce
     4- Click on login button
     5- `Test1 : Choose price low to high
     6-  Test2 : Verify item prices are sorted from low to high with soft Assert

     */

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void sauceDemoTest1 (){

        Driver.getDriver().get("https://www.saucedemo.com/");

        Driver.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");

        Driver.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        Driver.getDriver().findElement(By.id("login-button")).click();

        WebElement dropDown = Driver.getDriver().findElement(By.className("product_sort_container"));

        Select select = new Select(dropDown);

        select.selectByVisibleText("Price (low to high)");

        String exp = "PRICE (LOW TO HIGH)";
        String act = Driver.getDriver().findElement(By.className("active_option")).getText();

        softAssert.assertEquals(act,exp,"Aktif secenekteki yazi expected datadan farkli.");

        softAssert.assertAll();

    }


    @Test
    public void sauceDemoTest2 () {


        Driver.getDriver().get("https://www.saucedemo.com/");

        Driver.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");

        Driver.getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        Driver.getDriver().findElement(By.id("login-button")).click();

        WebElement dropDown = Driver.getDriver().findElement(By.className("product_sort_container"));

        Select select = new Select(dropDown);

        select.selectByVisibleText("Price (low to high)");

        List<WebElement> fiyatlar = Driver.getDriver().findElements(By.className("inventory_item_price"));

        ArrayList<Double> fiyatlarDouble = new ArrayList<>();

        for (WebElement fiyat:fiyatlar) {

            // String fiyatStr = fiyat.getText().replaceAll("$","");
            String fiyatStr = fiyat.getText().replaceAll("^\\D","");
            fiyatlarDouble.add(Double.parseDouble(fiyatStr));

        }

        ArrayList<Double> kontrolList = new ArrayList<>(fiyatlarDouble);

        Collections.sort(kontrolList);

        System.out.println(kontrolList+"\n"+fiyatlarDouble);

        softAssert.assertEquals(kontrolList,fiyatlarDouble);

        softAssert.assertAll();

    }


}