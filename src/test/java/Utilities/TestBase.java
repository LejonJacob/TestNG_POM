package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestBase {


    protected WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }


    public void threadSleep(int saniye){

        try {
            Thread.sleep(saniye*1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void captureScreen(String resimIsmi){

        TakesScreenshot tss= (TakesScreenshot) driver;

        File resimDosyasi= new File("target/screnShots/"+resimIsmi+".jpeg");

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciResim,resimDosyasi);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}