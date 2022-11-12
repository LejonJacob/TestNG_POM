package Tests.Day18_TestNGReports_ParalelTesting;

import Pages.AmazonPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class D02_ReusableMethodsElementList {

    @Test
    public void test01(){

        // Amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Arama kutusunun yanindaki dropdown menuyu locate edin
        // dropDown menudeki tum options listesini olusturup
        AmazonPage amazonPage=new AmazonPage();
        Select select=new Select(amazonPage.dropdownMenu);
        List<WebElement> optionsElementList= select.getOptions();

        // Menude Electronics basligi oldugunu test edin

        // Yukaridaki optionsElementList webElement'lerden olusuyor
        // Electronics String'inin listede olup olmadigini test etmek icin
        // Öncelikle String'lerden olusan bir liste olmali
        List<String> optionsStringListesi= ReusableMethods.getElementsText(optionsElementList);

        Assert.assertTrue(optionsStringListesi.contains(ConfigReader.getProperty("dropdownArananOption")));

        Driver.closeDriver();

    }

}
