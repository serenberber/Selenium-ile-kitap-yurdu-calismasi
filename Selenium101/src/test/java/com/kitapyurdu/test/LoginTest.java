package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.page.LoginPage;
import com.kitapyurdu.page.ProductPage;
import org.junit.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest(){
        LoginPage loginpage=new LoginPage();
        ProductPage productPage= new ProductPage();

        loginpage.login();
        productPage.selectProduct();
    }
}
