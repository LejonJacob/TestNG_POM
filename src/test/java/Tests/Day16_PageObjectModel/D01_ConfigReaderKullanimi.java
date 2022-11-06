package Tests.Day16_PageObjectModel;

import Pages.AmazonPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D01_ConfigReaderKullanimi {

    @Test
    public void method01(){

        // 1 test method'u olusturun
        // Amazon anasayfaya gidin
        // Nutella icin arama yapip,
        // Sonuclarin arama yaptigimiz kelimeyi icerdigini test edin

        // Amazon anasayfaya gidin https://www.amazon.com
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));


        // Nutella icin arama yapip,
        AmazonPage amazonPage = new AmazonPage();

        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAramaKelimesi") + Keys.ENTER);

        // Sonuclarin arama yaptigimiz kelimeyi icerdigini test edin
        String actualArananText = amazonPage.aramaSonucElementi.getText();

        String expectedArananText =  ConfigReader.getProperty("amazonAramaKelimesi");

        Assert.assertTrue(actualArananText.contains(expectedArananText));


        ReusableMethods.waiting(3);
        Driver.closeDriver();

    }
}
