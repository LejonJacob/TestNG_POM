package Tests.Day17_SmokeTests;

import Pages.MyCoursedemyPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class D02_NegatifLoginTest {


        // Mycoursedemy anasayfasina gidin
        // Login linkine basin
        // Üc farkli test method'u ile yanlis bilgilerle giris yapilamadigini test edin
        // 1- yanlis kullanici adi, gecerli password
        // 2- gecerli kullanici adi, yanlis password
        // 3- yanlis kullanici adi, yanlis password
        // Login butonuna basarak login olmaya calisin
        // Basarili olarak giris yapilamadigini test edin

    MyCoursedemyPage myCoursedemyPage = new MyCoursedemyPage();

    @BeforeClass
    public void setup(){

        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myCourseUrl"));

        ReusableMethods.waiting(2);
        myCoursedemyPage.cookies.click();

        // Login linkine basin
        myCoursedemyPage.loginLink.click();

    }

    // Üc farkli test method'u ile yanlis bilgilerle giris yapilamadigini test edin

    @Test
    public void yanlisKullaniciTesti(){


        // 1- yanlis kullanici adi, gecerli password
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myCourseYanlisMail"));

        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myCoursePassword"));

        ReusableMethods.waiting(2);

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();

        // Basarili olarak giris yapilamadigini test edin
        // bunun icin hala login linklinin gorunur oldugunu test edelim
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());

    }

    @Test
    public void yanlisPasswordTesti(){


        // 2- gecerli kullanici adi, yanlis password
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myCourseEmail"));

        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myCourseYanlisPassword"));

        ReusableMethods.waiting(2);

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();

        // Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());

    }

    @Test
    public void yanlisEmailSifreTesti(){


        // 3- yanlis kullanici adi, yanlis password
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myCourseYanlisMail"));

        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myCourseYanlisPassword"));

        ReusableMethods.waiting(2);
        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();

        // Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());

    }

    @AfterClass
    public void teardown(){
        ReusableMethods.waiting(3);
        Driver.closeDriver();

    }

}