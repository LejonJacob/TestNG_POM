package Tests.Selenium_Practice;

import Utilities.TestBase;
import org.testng.annotations.Test;

public class SQ02 extends TestBase {


        /*
            - Birbirine bagimli testler olusturun.
            - BeforeClass olusturup setUp ayarlarini yapin.
            - Birbirine bagimli testlr olusturarak ;
                => Ilk önce https://www.facebook.com 'a gidin
                => Sonra facebook'a bagimli olarak https://www.google.com 'a gidin
                => Daha sonra google'a bagimli olarak https://www.amazon.com 'a gidin
            - driver'i kapatin.
       */

    @Test(dependsOnMethods = "facebook" )
    public void google(){
        driver.get("https://www.google.com");
    }

    @Test (enabled = false)
    public void facebook(){
        driver.get("https://www.facebook.com");
    }

    @Test (dependsOnMethods = "google" )
    public void amazon(){
        driver.get("https://www.amazon.com");

    }

}
