package Tests.Day17_SmokeTests;

import Pages.MyCoursedemyPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D02_PozitifLoginTest {

    @Test
    public void pozitifLoginTest(){

        // Mycoursedemy anasayfasina gidin
        // login linkine basin
        // Kullanici email'i olarak valid email girin
        // Kullanici sifresi olarak valid sifre girin
        // Login butonuna basarak login olun
        // Basarili olarak giris yapilabildigini test edin

        // 1 - Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myCourseUrl"));



        // 2 - Login linkine basin
        MyCoursedemyPage myCoursedemyPage = new MyCoursedemyPage();

        myCoursedemyPage.cookies.click();

        myCoursedemyPage.loginLink.click();

        // 3 - Kullanici email'i olarak valid email girin
        myCoursedemyPage.emailBox.sendKeys(ConfigReader.getProperty("myCourseEmail"));

        // 4 - Kullanici sifresi olarak valid sifre girin
        myCoursedemyPage.passwordBox.sendKeys(ConfigReader.getProperty("myCoursePassword"));

        ReusableMethods.waiting(3);

        // 5 - Login butonuna basarak login olun
        myCoursedemyPage.loginButton.click();

        // 6 - Basarili olarak giris yapilabildigini test edin
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(myCoursedemyPage.myCoursesLink.isDisplayed());

        softAssert.assertAll();
        Driver.closeDriver();


    }

}
