package Tests.Day18_TestNGReports_ParalelTesting;

import Pages.AmazonPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import Utilities.TestBaseReport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class D03_RaporluTestOlusturma extends TestBaseReport {

    @Test
    public void test01(){

        extentTest = extentReports.createTest("DropDown Testi", "DropDown'da istenen elementin oldugunu test etme");

        // Amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Amazon anasayfaya gidildi");

        // Arama kutusunun yanindaki dropdown menuyu locate edin
        // dropDown menudeki tum options listesini olusturup
        AmazonPage amazonPage=new AmazonPage();
        Select select=new Select(amazonPage.dropdownMenu);
        extentTest.info("Dropdown menu locate edildi");

        List<WebElement> optionsElementList= select.getOptions();

        // Menüde Electronics basligi oldugunu test edin

        // Yukaridaki optionsElementList webElement'lerden olusuyor
        // Electronics String'inin listede olup olmadigini test etmek icin
        // Öncelikle String'lerden olusan bir liste olmali
        List<String> optionsStringListesi= ReusableMethods.getElementsText(optionsElementList);
        extentTest.info("Dropdown menüdeki tüm option'lar bir list olarak kaydedildi");

        Assert.assertTrue(optionsStringListesi.contains(ConfigReader.getProperty("dropdownArananOption")));
        extentTest.pass("Dropdown menüde aranan kelime oldugu test edildi");

        Driver.closeDriver();

    }

}
