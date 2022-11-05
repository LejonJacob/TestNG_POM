package Tests.Day15_pageObjectModel;

import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D02_DriverKullanimi {

    @Test
    public void Test01() {


        Driver.getDriver().get("https://www.amazon.com");

        String expectedUrl = "amazon.com";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualUrl.contains(expectedUrl), "Baslik amazon.com icermiyor");

        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYazisiElementi = Driver.getDriver().findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));

        String expectedKelime = "Nutella";
        String actualKelime = sonucYazisiElementi.getText();

        Assert.assertTrue(actualKelime.contains(expectedKelime), "Arama sonucu Nutella icermiyor");


        Driver.getDriver().get("https://www.wisequarter.com");

        String expectedUrlWise = "wisequarter";
        String actualUrlWise = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrlWise.contains(expectedUrlWise), "Url wisequarter icermiyor");

        ReusableMethods.waiting(3);

        softAssert.assertAll();


    }
}
