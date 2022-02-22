package com.kitapyurdu.page;

import com.kitapyurdu.method.method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class Favori {
    method methods;
    Logger logger= LogManager.getLogger(Favori.class);
    public Favori(){
        methods=new method();
    }
    public void scroll(){
        methods.sendKeys(By.id("search-input"), "Oyuncak");
        methods.waitBySeconds(3);
        methods.click(By.cssSelector("#product-532576"));
        methods.waitBySeconds(3);
    }
}
