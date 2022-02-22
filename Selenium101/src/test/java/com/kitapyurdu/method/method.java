package com.kitapyurdu.method;

import com.kitapyurdu.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class method {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger = LogManager.getLogger(method.class);

    public method() {
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30)).
                pollingEvery((Duration.ofMillis(300))).
                ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    //locatorları çekme
    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
    } //input içine text yazdırma

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementVisible(By by) {//sayfa yüklenmediği durumda
        //logger= hata mesajı almak için
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));// beklenen koşullar //untiil= olay gerçekleşene kadar bekle
            logger.info("true");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("False" + e.getMessage());
            return false;
        }
    }

    public void clickJS(By by) {
        jsdriver.executeScript("arguments[0].click();", findElement(by));

    }

    public void scrollWithAction(By by) {  //scrool kaydırma
        Actions actions = new Actions(driver); // actionslarda drivere çapırmak zorundayız
        actions.moveToElement(findElement(by)).build().perform();

    }

    public void scrollWithAction(WebElement al) {
        Actions actions = new Actions(driver);
        actions.moveToElement(al).build().perform();

    }

    public void getFavorite() {
        List<WebElement> favori = findElements(By.cssSelector(".add-to-favorites"));
        for (int i = 1; i < 5; i++) {
            WebElement al = favori.get(i);
            scrollWithAction(al);
            favori.get(i).click();
            waitBySeconds(1);
        }
    }

    public void favoriCheck() {
        click(By.cssSelector(".menu.top.my-list"));
        click(By.linkText("Favorilerim"));
        Assert.assertTrue(isElementVisible(By.cssSelector(".limit")));
        logger.info("Ürün favorilere eklendi.");
    }

    public Select getSelect(By by) {

        return new Select(findElement(by));
    }

    public void selectByText(By by, String text) {

        getSelect(by).selectByVisibleText(text);
    }

    public void selectByValue(By by, String text) {

        getSelect(by).selectByValue(text);
    }

    public String getAttribute(By by, String attributeName) { //attribute'e gelen değeri çekiyoruz
        return findElement(by).getAttribute(attributeName);

    }

    public String getText(By by) { //text mesajını çekiyoruz
        return findElement(by).getText();

    }

    public String getValue(By by) {
        return jsdriver.executeScript("return argument[0].value;", findElement(by)).toString();
    }


}