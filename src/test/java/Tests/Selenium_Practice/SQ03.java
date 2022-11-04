package Tests.Selenium_Practice;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SQ03 extends TestBase {

        /*
            - go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
            - Task 1 - Find Dropdown on Multi Selection
            - Task 2 - Find all Dropdown Elements
            - Task 3 - Printout Dropdown Elements' number
            - Task 4 - Choose all Dropdown elements and printout Dropdown elements' name on Multi Selection
            - Task 5 - Check until choice 6
        */


    @Test
    public void test01() {
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        WebElement dropDown = driver.findElement(By.xpath("//input[@id='justAnInputBox']"));
        dropDown.click();

        List<WebElement> dropList = driver.findElements(By.className("ComboTreeItemChlid"));
        System.out.println("Dropdownlardaki element sayisi = " + dropList.size());

        /*

         for (int i = 0; i < dropList.size(); i++) {

             String text = dropList.get(i).getText();
             System.out.println("text = " + text);

             if (!text.isEmpty()){
                 dropList.get(i).click();
             }

             if (text.equals("choice 5")){
                 break;
             }
         }

         */

         Select select = new Select(dropDown);

         for (int i = 0; i < dropList.size(); i++) {

            select.selectByIndex(i);
            String text = dropList.get(i).getText();

            if (!text.isEmpty()) {
                dropList.get(i).click();
            }

            if (text.equals("choice 5")) {
                break;
            }

         }
    }
}
