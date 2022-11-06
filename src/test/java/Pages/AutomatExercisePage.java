package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomatExercisePage {

    public AutomatExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = " Signup / Login")
    public WebElement signUpLinki;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginAccountElementi;

    @FindBy(xpath = "(//input[@name='email'])[1]")
    public WebElement emailKutusu;

    @FindBy(xpath = "(//input[@name='password'])[1]")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButonu;

    @FindBy(xpath = "//*[text()=' Logged in as ']")
    public WebElement loggedinAs;

    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement deleteAccountButton;

    @FindBy (xpath = "//*[text()='Account Deleted!']")
    public WebElement accountDeletedlocation;


}
