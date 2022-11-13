package Tests.Day19_DataProvider;

import Pages.MyCoursedemyPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class D02_negativeLoginDataProvider {


    @DataProvider
    public static Object[][] kullaniciDataProvider() {


        Object[][] kullaniciBilgileri={  {"icardi@gmail.com","12345"}
                                        ,{"seher@gmail.com","12455"}
                                        ,{"lejon@gmail.com","5hfgt"}
                                        ,{"soner@gmail.com","9jdgfr"}
                                        ,{"fatih@gmail.com","jhhgf65"}
                                        ,{"nevzat@gmail.com","6645gd"}
                                        ,{"murat@gmail.com","7fghrt"}
                                        ,{"ahmet@gmail.com","hfgdt"}
                                        ,{"bora48@gmail.com","5dgder"}
                                        ,{"budason@gmail.com","7y65f"}};

        return kullaniciBilgileri;

    }

    // Negatif login testi icin verilen 10 adet kullanici adi ve sifreyi deneyip
    // Giris yapilamadigini test edelim


    MyCoursedemyPage myCoursedemyPage = new MyCoursedemyPage();

    @BeforeClass
    public void setupTest(){

        Driver.getDriver().get(ConfigReader.getProperty("myCourseUrl"));

        // Login linkine basin
        myCoursedemyPage.cookies.click();
        myCoursedemyPage.loginLink.click();
        ReusableMethods.waiting(2);

    }

    @Test(dataProvider = "kullaniciDataProvider")
    public void negatifCokluTest(String email,String password) {

        // Mycoursedemy anasayfasina gidin

        // 1- Verilen listeden kullanici adi ve password yazalim
        myCoursedemyPage.emailBox.sendKeys(email);
        myCoursedemyPage.passwordBox.sendKeys(password);

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();
        ReusableMethods.bekle(2);

        // Basarili olarak giris yapilamadigini test edin
        // bunun icin hala login linklinin gorunur oldugunu test edelim
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());

    }

    @AfterClass
    public void tearDown(){

        Driver.closeDriver();

    }


}
