package Tests.Day19_CrossBrowserTests;

import Utilities.ConfigReader;
import Utilities.TestBaseCross;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D01_amazonSearchTest extends TestBaseCross {

    @Test
    public void test01(){

        // Amazon anasayfasina gidin
        driver.get(ConfigReader.getProperty("amazonUrl"));

        // Nutella icin arama yapin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edelim
        String actualSonucyazisi=driver .findElement(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"))
                .getText();

        String expectedKelime="Nutella";
        Assert.assertTrue(actualSonucyazisi.contains(expectedKelime));

    }

}
