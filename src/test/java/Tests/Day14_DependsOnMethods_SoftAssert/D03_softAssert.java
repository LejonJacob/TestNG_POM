package Tests.Day14_DependsOnMethods_SoftAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D03_softAssert {

    @Test
    public void hardAssertTesti(){
        // Verilen bir sifrenin sartlari saglayip saglamadigini test edin

        // 1- Ilk harf Buyuk harf olmali
        // 2- Son harf kucuk harf olmali
        // 3- sifre bosluk icermemeli
        // 4- uzunlugu en az 8 karakter olmali

        /*

          assertion islemi yapilirken
          ilk bulunan hatada kodun calismasi durdurulur (stop execution)
            Assert class'indaki method'lar static olduklari icin
            classIsmi.methodIsmi ile cagrilirlar

        */

        String sifre="JavAahjava";

        // 1- Ilk harf Buyuk harf olmali
        boolean ilkHarfKontrolu= sifre.charAt(0)>='A' && sifre.charAt(0)<='Z';
        Assert.assertTrue(ilkHarfKontrolu,"Ilk harf büyük harf olmalidir");

        // 2- Son harf kucuk harf olmali
        boolean sonHarfKontrolu= sifre.charAt(sifre.length()-1)>='a' && sifre.charAt(sifre.length()-1)<='z';
        Assert.assertTrue(sonHarfKontrolu,"Son harf kucuk harf olmalidir");

        // 3- Sifre bosluk icermemeli
        Assert.assertFalse(sifre.contains(" "),"Sifre bosluk icermemelidir");

        // 4- Uzunlugu en az 8 karakter olmali
        Assert.assertTrue(sifre.length()>=8, "Sifrenin Uzunlugu en az 8 karakterden olusmalidir");

        // 5- Tüm sartlari sagliyorsa sifre basari ile kaydedildi yazdirin
        System.out.println("Sifreniz basari ile kaydedildi");
    }

    @Test
    public void softAssertTesti(){

        /*

          JUnit'de de kullandigimiz Assert class'i ilk failed olan assertion'da
          calismayi durdurur ve hata mesaji verir.

          Eger ilk hatada durmasini degil, devam edip sona kadar tum testleri yapmasini
          ve en sonunda durumu raporlayip, failed olan varsa
          calismayi durdurmasini istiyorsaniz;
          SoftAssert class'ini kullanabilirsiniz
          SoftAssert clas'indaki method'lar static degildir,
          SoftAssert class'indaki method'lari kullanmak icin obje olusturmaliyiz


          Genellikle
          hard Assertion kullanmamiz istendiginde test edin (Test)
          soft Assertion kullanmamiz istendiginde dogrulayin (Verify) kelimeleri kullanilir.

        */

        // A- 1. Adim softAssert objesi olustur
        SoftAssert softAssert= new SoftAssert();

        // B- 2. Adim istenen tum assertion'lari softAssert objesini kullanarak yapin
        String sifre="JavAahJava";

        // 1- Ilk harf Buyuk harf olmali
        boolean ilkHarfKontrolu= sifre.charAt(0)>='A' && sifre.charAt(0)<='Z';
        softAssert.assertTrue(ilkHarfKontrolu,"Ilk harf buyuk harf olmali");

        // 2- Son harf kucuk harf olmali
        boolean sonHarfKontrolu= sifre.charAt(sifre.length()-1)>='a' && sifre.charAt(sifre.length()-1)<='z';
        softAssert.assertTrue(sonHarfKontrolu,"Son harf kucuk harf olmali");

        // 3- Sifre bosluk icermemeli
        softAssert.assertFalse(sifre.contains(" "),"Sifre bosluk icermemeli");

        // 4- Uzunlugu en az 8 karakter olmali
        softAssert.assertTrue(sifre.length()>=8, "uzunluk en az 8 karakter olmali");

        // C. Tüm testler bitince, isimiz bitti yapilan tum assert'leri raporla dememiz gerekir.
        // Bir tane bile failed varsa bu satirda kodun calismasi durdurulur

        softAssert.assertAll();

        // 5- Tüm sartlari sagliyorsa sifre basari ile kaydedildi yazdirin
        System.out.println("Sifreniz basari ile kaydedildi");

    }


}
