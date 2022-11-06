package Tests.Day16_PageObjectModel;

import org.testng.annotations.Test;

public class D02_xmlFiles {

    @Test
    public void test01(){
        System.out.println("Test 01 calisti");

    }@Test(groups = "smoke")
    public void test02(){
        System.out.println("Test 02 calisti");

    }@Test(groups = {"smoke", "regression"})
    public void test03(){
        System.out.println("Test 03 calisti");

    }@Test(groups = "regression")
    public void test04(){
        System.out.println("Test 04 calisti");

    }@Test
    public void test05(){
        System.out.println("Test 05 calisti");

    }
}
