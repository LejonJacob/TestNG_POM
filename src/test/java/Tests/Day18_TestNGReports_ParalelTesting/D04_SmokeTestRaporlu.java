package Tests.Day18_TestNGReports_ParalelTesting;

import Pages.MyCoursedemyPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import Utilities.TestBaseReport;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class D04_SmokeTestRaporlu extends TestBaseReport {

    MyCoursedemyPage myCoursedemyPage = new MyCoursedemyPage();


    @BeforeClass
    public void setup(){

        // MyCoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myCourseUrl"));

        ReusableMethods.waiting(1);
        myCoursedemyPage.cookies.click();

        ReusableMethods.waiting(2);

        // Login linkine tiklayin
        myCoursedemyPage.loginLink.click();

    }


    // Üc farkli test method'u ile yanlis bilgilerle giris yapilamadigini test edin

    @Test
    public void yanlisKullaniciTesti(){

        // Mycoursedemy anasayfasina gidin
        // Driver.getDriver().get(ConfigReader.getProperty("myCourseUrl"));



        extentTest=extentReports.createTest("Yanlis kullanici adi","Yanlis kullanici adi ile giris yapilamaz");

        // 1- Yanlis kullanici adi, gecerli password
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myCourseYanlisMail"));
        extentTest.info("Kullanici adi olarak yanlis bir email yazildi");

        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myCoursePassword"));
        extentTest.info("Password olarak gecerli password yazildi");

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();
        extentTest.info("Login butonuna basildi");

        // Basarili olarak giris yapilamadigini test edin
        // Bunun icin hala login linklinin gorunur oldugunu test edelim
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());
        extentTest.pass("Giris yapilamadigi test edildi");

    }

    @Test
    public void yanlisPasswordTesti(){

        // Mycoursedemy anasayfasina gidin
        // Driver.getDriver().get(ConfigReader.getProperty("myCourseUrl"));

        extentTest=extentReports.createTest("Yanlis password","Yanlis password ile giris yapilamaz");

        // 2- Gecerli kullanici adi, yanlis password
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myCourseEmail"));
        extentTest.info("Kullanici adi olarak gecerli bir email yazildi");

        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myCourseYanlisPassword"));
        extentTest.info("Password olarak yanlis password yazildi");

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();
        extentTest.info("Login butonuna basildi");

        // Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());
        extentTest.pass("Giris yapilamadigi test edildi");

    }

    @Test
    public void yanlisEmailSifreTesti(){

        // Mycoursedemy anasayfasina gidin
        // Driver.getDriver().get(ConfigReader.getProperty("myCourseUrl"));

        extentTest=extentReports.createTest("Yanlis kullanici adi ve Yanlis password","Yanlis kullanici adi ve yanlis password ile giris yapilamaz");

        // 3- Yanlis kullanici adi, yanlis password
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myCourseYanlisMail"));
        extentTest.info("Kullanici adi olarak yanlis bir email yazildi");

        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myCourseYanlisPassword"));
        extentTest.info("Password olarak yanlis password yazildi");

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();
        extentTest.info("Login butonuna basildi");

        // Basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());
        extentTest.pass("Giris yapilamadigi test edildi");

    }

    @AfterClass
    public void teardown(){

        ReusableMethods.waiting(2);
        Driver.closeDriver();

    }


}