package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // Amazondaki arama kutusunu locate edelim
    @FindBy(id="twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath="//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]")
    public WebElement aramaSonucElementi;

    @FindBy(xpath = "//select[@title=\"Search in\"]")
    public WebElement dropdownMenu;

}