package Tests.Day13_testNGFramework;

import Utilities.TestBase;
import org.testng.annotations.Test;

public class D01_TestNGIlkTest extends TestBase {

    @Test(priority = 10)
    public void ilkTest(){

        driver.get("https://www.amazon.com");

    }

    @Test()
    public void ikinciTest(){

        driver.get("https://www.youtube.com");

    }

    @Test(priority = -12)
    public void ucuncuTest(){

        driver.get("https://www.wisequarter.com");

    }


}
