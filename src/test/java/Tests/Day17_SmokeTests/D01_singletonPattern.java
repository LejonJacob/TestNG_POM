package Tests.Day17_SmokeTests;

import org.testng.annotations.Test;

public class D01_singletonPattern {

     /*

      Soingleton pattern bir class'dan obje olusturulmasini engelleyen
      veya sinirlandiran bir konsepttir.

     */

    @Test
    public void test01(){

        // Amazon anasayfaya gidin

        // Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        /*

          Tum class'lardan yapabildigimiz gibi Driver class'indan da
          obje olusturabilir ve oradaki class uyelerini kullanabiliriz
          Boyle bir kullanimda Driver class'inda yaptigimiz tercihler
          bypass edilmis olur

          Bu tur kullanimin onune gecebilmek icin Java'dan
          singleton pattern konsepti uygulanir

          Driver class'indan obje olusturulmasini engellemek icin

          Driver class'indan obje olusturup, kullanabilmek icin
          Driver() constructor'ina ihtiyac vardir
          Eger bu constructor'i erisilemez yaparsak
          kimse constructor'a erisemez ve dolayisiyla
          kimse Driver class'indan obje olusturamaz

          Bunun icin gorunur parametresiz bir constructor olusturup
          bunu private yapariz
          Bu yonteme SINGLETON PATTERN denir.

         */

        // Driver driver= new Driver();

    }
}