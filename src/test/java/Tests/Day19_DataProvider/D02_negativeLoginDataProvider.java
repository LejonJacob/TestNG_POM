package Tests.Day19_DataProvider;

import Pages.MyCoursedemyPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class D02_negativeLoginDataProvider {


    @DataProvider
    public static Object[][] kullaniciDataProvider() {


        Object[][] kullaniciBilgileri={  {"abc@gmail.com","12345"}
                                        ,{"gfre@gmail.com","12455"}
                                        ,{"abcde@gmail.com","5hfgt"}
                                        ,{"soner@gmail.com","9jdgfr"}
                                        ,{"Fatih@gmail.com","jhhgf65"}
                                        ,{"Nevzat@gmail.com","6645gd"}
                                        ,{"Murat@gmail.com","7fghrt"}
                                        ,{"Ahmet@gmail.com","hfgdt"}
                                        ,{"yghdr48@gmail.com","5dgder"}
                                        ,{"budason@gmail.com","7y65f"}};

        return kullaniciBilgileri;

    }

    // Negatif login testi icin verilen 10 adet kullanici adi ve sifreyi deneyip
    // giris yapilamadigini test edin

    @Test(dataProvider = "kullaniciDataProvider")
    public void negatifCokluTest(String email,String password){

        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));

        // login linkine basin
        MyCoursedemyPage myCoursedemyPage=new MyCoursedemyPage();
        myCoursedemyPage.loginLink.click();

        // 1- verilen listeden kullanici adi ve password yazalim
        myCoursedemyPage.emailBox.sendKeys(email);
        myCoursedemyPage.passwordBox.sendKeys(password);

        // Login butonuna basarak login olmaya calisin
        myCoursedemyPage.loginButton.click();
        ReusableMethods.bekle(2);

        // Basarili olarak giris yapilamadigini test edin
        // bunun icin hala login linklinin gorunur oldugunu test edelim
        Assert.assertTrue(myCoursedemyPage.loginLink.isEnabled());

    }


}
