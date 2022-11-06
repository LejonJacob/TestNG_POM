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

        // 1- Amazon anasayfasina gidin, basliginin amazon icerdigini dogrulayin
        Driver.getDriver().get("https://www.amazon.com");

        String expectedTitle = "Amazon";
        String actualTitle = Driver.getDriver().getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedTitle), "Baslik amazon.com icermiyor");

        // 2- Nutella icin arama yapin ve sonuclarin Nutella icerdigini dogrulayin
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYazisiElementi = Driver.getDriver().findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));

        String expectedKelime = "Nutella";
        String actualKelime = sonucYazisiElementi.getText();

        Assert.assertTrue(actualKelime.contains(expectedKelime), "Arama sonucu Nutella icermiyor");

        // 3- Wisequarter anasayfasina gidip, url'in wisequarter icerdigini dogrulayin
        Driver.getDriver().get("https://www.wisequarter.com");

        String expectedUrlWise = "wisequarter";
        String actualUrlWise = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrlWise.contains(expectedUrlWise), "Url wisequarter icermiyor");

        ReusableMethods.waiting(3);

        softAssert.assertAll();


    }
}
