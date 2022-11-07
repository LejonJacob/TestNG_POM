package Tests.Day17_SmokeTests;

import Pages.MyCoursedemyPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D03_EndToEndTest {

        /*

          E2E (End to end testi, uctan uca bir islevin tum asamalarini
          gerceklestirerek, islevin calistigini test etmek demektir.

          Bir uygulamada bircok e2e testi olabilir.

        */

    @Test
    public void e2eKursOlusturmaTesti(){

        // MyCoursedemy sayfasina gidin
        // Gecerli kullanici adi ve sifre girerek sisteme login olun
        // MyCourses linkini tiklayin
        // Yeni bir course olusturmak icin istenen bilgileri girin
        // Yeni kursun olusturuldugunu test edin


        // MyCoursedemy sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myCourseUrl"));


        MyCoursedemyPage myCoursedemyPage = new MyCoursedemyPage();

        // Gecerli kullanici adi ve sifre girerek sisteme login olun
        myCoursedemyPage.loginMethod();

        // Instructor linkini tiklayin
        myCoursedemyPage.instructorLinki.click();

        // Course Manager linkine tiklayin
        myCoursedemyPage.courseManagerLinki.click();

        // Add New Course butonuna tiklayin
        myCoursedemyPage.addNewCourseButonu.click();

        // Course title bilgisi girin
        myCoursedemyPage.courseTitleKutusu.sendKeys(ConfigReader.getProperty("myCourseTitle"));

        // Category menusune tiklayin
        myCoursedemyPage.categoryMenusu.click();

        // Ilgili kurs kategorisini secin
        myCoursedemyPage.categorySecimi.click();

        // Next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();

        // Tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();

        // Tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();

        // Price kutusuna fiyati yazdiralim
        myCoursedemyPage.coursePrice.sendKeys(ConfigReader.getProperty("myCoursePrice"));

        // Indirim kutusuna %50 yazalim
        myCoursedemyPage.discountKutusu.sendKeys(ConfigReader.getProperty("myDiscount"));

        // tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();

        // Tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();

        // Meta keywords kutusuna java kursu yazdiralim
        myCoursedemyPage.metaKeywordsKutusu.sendKeys(ConfigReader.getProperty("myMetaKeywords"));

        // Tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();

        // Submit butonuna basalim
        myCoursedemyPage.submitButonu.click();

        // Yeni kursun olusturuldugunu test edin
        Assert.assertTrue(myCoursedemyPage.backToCourseListButonu.isEnabled());

        Driver.closeDriver();

    }

}