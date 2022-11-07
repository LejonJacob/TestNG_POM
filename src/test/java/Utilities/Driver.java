package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    static WebDriver driver;

    private Driver(){


    }

    public static WebDriver getDriver() {

        if (driver==null){ // method ilk cagrildiginda driver degeri atanmamis oldugundan deger atar

            String browser = ConfigReader.getProperty("browser");

            switch (browser){

                case "chrome" : WebDriverManager.chromedriver().setup();
                                driver = new ChromeDriver();
                                break;

                case "edge" : WebDriverManager.edgedriver().setup();
                              driver = new EdgeDriver();
                              break;

                case "safari" : WebDriverManager.safaridriver().setup();
                                driver = new SafariDriver();
                                break;

                case "firefox" : WebDriverManager.firefoxdriver().setup();
                                 driver = new FirefoxDriver();
                                 break;

                default: WebDriverManager.chromedriver().setup();
                         driver = new ChromeDriver();
                         break;
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;

    }

    public static void closeDriver(){

        if (driver!=null){

            driver.close();
            driver=null;

        }

    }

}
