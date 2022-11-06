package Tests.Day15_pageObjectModel;

import Pages.AmazonPage;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D04_PagesKullanimi2 {

    // Amazon anasayfaya gidin
    // 3 test method'u olusturun
    // Herbir method'da Nutella, Java, Bicycle icin arama yapip,
    // Sonuclarin arama yaptigimiz kelimeleri icerdigini test edin

    AmazonPage amazonPage=new AmazonPage();


    @Test(dependsOnMethods = "bicycleTesti")
    public void nutellaTesti(){

        amazonPage.aramaKutusu.clear();
        amazonPage.aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        String actualAramaSonucu= amazonPage.aramaSonucElementi.getText();
        String expectedKelime="nutella";

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

        ReusableMethods.waiting(3);
        Driver.closeDriver();

    }

    @Test(dependsOnMethods = "bicycleTesti")
    public void javaTesti(){

        amazonPage.aramaKutusu.clear();
        amazonPage.aramaKutusu.sendKeys("java"+Keys.ENTER);

        String actualAramaSonucu= amazonPage.aramaSonucElementi.getText();
        String expectedKelime="java";

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

    }

    @Test
    public void bicycleTesti(){

        Driver.getDriver().get("https://www.amazon.com");

        amazonPage.aramaKutusu.sendKeys("bicycle"+ Keys.ENTER);

        String actualAramaSonucu= amazonPage.aramaSonucElementi.getText();
        String expectedKelime="bicycle";

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

    }

}
