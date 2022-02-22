package com.kitapyurdu.page;

import com.kitapyurdu.method.method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;


public class LoginPage {
    method methods;
    Logger logger= LogManager.getLogger(LoginPage.class);
    public LoginPage(){
        methods = new method();
    }

    public void login(){
        methods.click(By.cssSelector(".menu-top-button.login>a"));
        methods.sendKeys(By.id("login-email"),"serenberber@gmail.com");
        methods.sendKeys(By.id("login-password"),"1q2w3e4r5t");
        methods.waitBySeconds(1);

        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));

        methods.waitBySeconds(1);
        Assert.assertTrue(methods.isElementVisible(By.cssSelector(".section")));
        //String chechtext= methods.getText(By.cssSelector("#content.grid_12.mg-b-30.account-menu>21"));
        //System.out.println("alınantxt:"+chechtext);
        //logger.info("alınan text"+chechtext);
        //Assert.assertEquals("Hesabım", chechtext);
        //burada hesabım yazısı kontrol edildi


    }
}
