package com.kitapyurdu.page;

import com.kitapyurdu.method.method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;


public class ProductPage {
    method methods;
    Logger logger = LogManager.getLogger(ProductPage.class);
    Random rnd = new Random();

    //kayıt alıyor.
    public ProductPage() {
        methods = new method();
    }

    public void selectProduct() {
        methods.sendKeys(By.id("search-input"), "Oyuncak");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.cssSelector(".sprite.sprite-stars-3"));
        methods.waitBySeconds(2);
        methods.getFavorite();
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".logo-icon"));
        //puan katoloğu
        methods.click(By.cssSelector("#mainNav > div.nav-content > div > div.lvl1catalog > a"));
        //türk klasikleri sayfası
        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        // methods.click(By.cssSelector("#landing-point > div:nth-child(4) > a:nth-child(2) > img"));
        methods.waitBySeconds(3);
        methods.click(By.cssSelector(".product-filter-header"));
        methods.waitBySeconds(1);
        //sıralama satırı
        //sıralama yüksek falan
        methods.selectByText(By.cssSelector("#content > div > div > div.product-filter > div > div.sort > select"), "Yüksek Oylama");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#mainNav > div.nav-content > ul > li.book.has-menu.active > div.lvl2.js-bookCr > ul > li:nth-child(3) > span"));
        methods.waitBySeconds(1);
        //hobi sayfasına giriyor
        methods.click(By.cssSelector("li>a[href='kategori/kitap-hobi/1_212.html']"));
        List<WebElement> productList = methods.findElements(By.cssSelector(".cover"));
        int randNum = rnd.nextInt(productList.size());
        productList.get(randNum).click();
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.xpath("//*[@id=\'button-cart\']"));
        methods.click(By.xpath("//*[@id=\'button-cart\']"));
        methods.waitBySeconds(2);
        methods.favoriCheck();
        methods.waitBySeconds(1);
        methods.scrollWithAction(By.cssSelector("#content > div.grid_9 > div.box.no-padding > div.pagination"));
        //methods.click(By.xpath("(//*[@data-title='Favorilerimden Sil'])[4]"));
        methods.click(By.xpath("(//*[@data-title='Favorilerimden Sil'])[3]"));
        // methods.click(By.xpath("(//*[@data-title='Favorilerimden Sil'])[2]"));
        //methods.click(By.xpath("(//*[@data-title='Favorilerimden Sil'])[1]"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.cssSelector("body > div.content-bg > div > div.breadcrumb"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#cart > div.heading > div:nth-child(2) > h4"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("#js-cart"));
        methods.waitBySeconds(2);
        // value clear
        methods.findElement(By.xpath("//input[@name='quantity']")).clear();
        methods.waitBySeconds(1);
        //arttırma
        methods.sendKeys(By.xpath("//input[@name='quantity']"), "4");
        methods.waitBySeconds(2);
        methods.click(By.xpath("//i[@title='Güncelle']"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("div[class='right']>a[class='button red']"));
        methods.waitBySeconds(3);
        //satınal
        //   methods.click(By.cssSelector("#cart_module > div.cart-info > table > thead > tr > td.to-wishlist > a"));
        methods.waitBySeconds(2);

        //Adres

        methods.sendKeys(By.id("address-firstname-companyname"), "Adım");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-lastname-title"), "Soyadım");
        methods.waitBySeconds(1);
        methods.selectByValue(By.id("address-zone-id"), "İstanbul");
        methods.waitBySeconds(1);
        methods.selectByValue(By.id("address-county-id"), "ÜMRANİYE");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-address-text"), "Adresim");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-mobile-telephone"), "5434242342");
        methods.waitBySeconds(2);
        //kart bilgi
        methods.sendKeys(By.cssSelector("#credit-card-owner"), "DenemeAd DenemeSoyad");
        methods.waitBySeconds(1);
        methods.sendKeys(By.cssSelector("#credit_card_number_1"), "1234");
        methods.sendKeys(By.cssSelector("#credit_card_number_2"), "1234");
        methods.sendKeys(By.cssSelector("#credit_card_number_3"), "1234");
        methods.sendKeys(By.cssSelector("#credit_card_number_4"), "1234");
        methods.waitBySeconds(1);
        methods.selectByValue(By.cssSelector("#credit-card-expire-date-month"), "01");
        methods.selectByValue(By.cssSelector("#credit-card-expire-date-year"), "2024");
        methods.waitBySeconds(1);
        methods.sendKeys(By.cssSelector("#credit-card-security-code"), "123");
        methods.click(By.cssSelector("#button-checkout-continue"));
        methods.waitBySeconds(1);
        String errorText = methods.getText(By.cssSelector("#form-credit-card > div.credit-card-form-content > table > tbody > tr:nth-child(5) > td > span"));
        if (errorText != null) {
            System.out.println(errorText);
            methods.click(By.cssSelector("#logo > a > img"));
            methods.scrollWithAction(By.cssSelector("#header-top > div > div.welcome.fl > div.menu.top.login > ul > li > a"));
            methods.clickJS(By.cssSelector("#header-top > div > div.welcome.fl > div.menu.top.login > ul > li > div > ul > li:nth-child(4) > a"));
        } else if (errorText == null) {
            System.out.println("Satın alma işlemi gerçekleşiyor.");
        }
        methods.waitBySeconds(3);


    }

    public void attributeTest() {
        String attribute = methods.getAttribute(By.cssSelector(".logo-text>a>img"), "title");
        logger.info("alınan text" + attribute);
    }

    public void textControlTest() {
        String text = methods.getText(By.cssSelector(".common-sprite"));
        logger.info("alınan text;" + text);
    }

    public void valueControlTest() {
        methods.sendKeys(By.id("search-input"), "testinium");
        String value = methods.getValue(By.id("search-input"));
        System.out.println("alınan text" + value);
        logger.info("alınan text" + value);
        Assert.assertEquals("testinium", value);
        methods.waitBySeconds(1);
    }
}
