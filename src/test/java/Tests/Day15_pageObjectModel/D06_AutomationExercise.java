package Tests.Day15_pageObjectModel;

import Pages.AutomatExercisePage;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D06_AutomationExercise {

    @Test
    public void test01(){

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        SoftAssert softAssert=new SoftAssert();

        String expectedUrl="https://automationexercise.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"Homepage'de degilsiniz.");

        //4. Click on 'Signup / Login' button
        AutomatExercisePage automationExercisePage=new AutomatExercisePage();

        ReusableMethods.waiting(2);
        automationExercisePage.signUpLinki.click();

        //5. Verify 'Login to your account' is visible
        softAssert.assertTrue(automationExercisePage.loginAccountElementi.isDisplayed());

        //6. Enter correct email address and password
        automationExercisePage.emailKutusu.sendKeys("aurora@gmail.com");
        automationExercisePage.passwordKutusu.sendKeys("aurora");

        //7. Click 'login' button
        automationExercisePage.loginButonu.click();

        //8. Verify that 'Logged in as username' is visible

        //9. Click 'Delete Account' button
        //10. Verify that 'ACCOUNT DELETED!' is visible

        //     mail=aurora@gmail.com
        //     password=aurora

        softAssert.assertAll();
        ReusableMethods.waiting(5);
        Driver.closeDriver();
    }
}