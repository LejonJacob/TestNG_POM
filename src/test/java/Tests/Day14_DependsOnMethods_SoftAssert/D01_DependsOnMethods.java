package Tests.Day14_DependsOnMethods_SoftAssert;

import Utilities.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D01_DependsOnMethods extends TestBaseClass {

        // Üc test method'u olusturun
        // 1. testin ismi amazon testi olsun,
        //    amazon anasayfasina gidip, amazona gittigimizi test edin
        // 2. testin ismi nutella testi olsun
        //    nutella icin arama yapip, sonuclarin nutella icerdigini test edin
        // 3. testin ismi arama sonuc testi olsun
        //    sonuc sayisinin 100'den fazla oldugunu test edin

        /*

          DependsOnMethods="BagliOlunanTestAdi"
          iki test method'unu birbirine baglar
          Bu sekilde bagli olunan test failed olursa,
          bagli olan test ignore edilir, hic calismaz

        */


    @Test(priority = 1)
    public void amazonTesti(){

        // 1. testin ismi amazon testi olsun,
        // Amazon anasayfasina gidip, amazona gittigimizi test edin

        driver.get("https://www.amazon.com");

        String expectedUrl = "amazon.com";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }

    @Test(priority = 2, dependsOnMethods = "amazonTesti")
    public void nutellaTesti(){

        // 2. testin ismi nutella testi olsun
        // Nutella icin arama yapip, sonuclarin nutella icerdigini test edin

        WebElement searchBoxElement = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));

        searchBoxElement.sendKeys("Nutella" + Keys.ENTER);

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));

        String expectedKelime = "Nutella";
        String actualKelime = sonucYazisiElementi.getText();

        Assert.assertTrue(actualKelime.contains(expectedKelime));

    }


    @Test(priority = 3,dependsOnMethods = "nutellaTesti")
    public void aramaSonucTesti(){

        // 3. testin ismi arama sonuc testi olsun
        // Nutella icin sonuc sayisinin 100'den fazla oldugunu test edin

        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualSonucYazisi= sonucYaziElementi.getText(); // 1-48 of 114 results for "nutella"

        int indexOf = actualSonucYazisi.indexOf("of");
        int indexresults= actualSonucYazisi.indexOf("result");

        String sonucSayisiStr= actualSonucYazisi.substring(indexOf+3,indexresults-1);

        Integer sonucSayisiInt=Integer.parseInt(sonucSayisiStr);

        Integer expectedMinSonucSayisi=100;

        Assert.assertTrue(sonucSayisiInt>expectedMinSonucSayisi);

    }

}