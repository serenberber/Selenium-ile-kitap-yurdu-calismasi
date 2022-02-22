package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.page.LoginPage;
import com.kitapyurdu.page.ProductPage;
import org.junit.Test;

public class ProductTest extends BaseTest {
    @Test
    public void productTest(){
        LoginPage loginPage=new LoginPage();
        ProductPage productPage= new ProductPage();
        loginPage.login();
        productPage.selectProduct();
    }
    @Test
    public void getAttributeText(){
        ProductPage productPage= new ProductPage();
        productPage.attributeTest();
    }
    @Test
    public void getTextTest(){
        ProductPage productPage=new ProductPage();
        LoginPage loginPage=new LoginPage();
        loginPage.login();
        productPage.textControlTest();
    }

    @Test
    public void valueTest(){
        ProductPage productpage= new ProductPage();
        productpage.valueControlTest();
    }

}