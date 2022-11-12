package Pages;

import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCoursedemyPage {

    public MyCoursedemyPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }



    @FindBy(xpath = "//a[text()=\"Log in\"]")
    public WebElement loginLink;

    @FindBy(xpath = "//a[@onclick=\"cookieAccept();\"]")
    public WebElement cookies;


    @FindBy(xpath = "//input[@id=\"login-email\"]")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id=\"login-password\"]")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[text()=\"Login\"]")
    public WebElement loginButton;

    @FindBy(linkText = "My courses")
    public WebElement myCoursesLink;

    @FindBy(linkText = "Instructor")
    public WebElement instructorLinki;

    @FindBy(xpath = "//*[text()=\"Course manager\"]")
    public WebElement courseManagerLinki;

    @FindBy(xpath = "//*[text()=\"Add new course\"]")
    public WebElement addNewCourseButonu;

    @FindBy(xpath = "//*[@id=\"course_title\"]")
    public WebElement courseTitleKutusu;

    @FindBy(xpath = "(//*[text()=\"Select a category\"])[2]")
    public WebElement categoryMenusu;

    @FindBy(xpath = "(//*[text()=\"Web Design for Web Developers\"])[2]")
    public WebElement categorySecimi;

    @FindBy(xpath = "//*[@class=\"mdi mdi-arrow-right-bold\"]")
    public WebElement ilkNextButonu;

    @FindBy(xpath = "//*[@placeholder=\"Enter course course price\"]")
    public WebElement coursePrice;

    @FindBy(xpath = "//*[@name=\"discounted_price\"]")
    public WebElement discountKutusu;

    @FindBy(xpath = "(//*[@placeholder=\"Write a keyword and then press enter button\"])[2]")
    public WebElement metaKeywordsKutusu;

    @FindBy(xpath = "//*[text()=\"Submit\"]")
    public WebElement submitButonu;

    @FindBy(xpath = "//*[text()=\" Back to course list\"]")
    public WebElement backToCourseListButonu;


    public void loginMethod(){
        cookies.click();
        ReusableMethods.waiting(2);
        loginLink.click();
        emailBox.sendKeys(ConfigReader.getProperty("myCourseEmail"));
        passwordBox.sendKeys(ConfigReader.getProperty("myCoursePassword"));
        loginButton.click();
    }

}
