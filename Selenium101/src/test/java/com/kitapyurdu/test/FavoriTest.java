package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.page.Favori;
import com.kitapyurdu.page.LoginPage;
import org.junit.Test;

public class FavoriTest extends BaseTest {
    @Test
    public void scroll(){
        LoginPage loginpage=new LoginPage();
        Favori favori=new Favori();
        loginpage.login();
        favori.scroll();
    }
}
