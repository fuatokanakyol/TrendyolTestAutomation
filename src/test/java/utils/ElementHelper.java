package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ElementHelper {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    HashMap<String,String> keyMap = new HashMap<String,String>();
    private Logger logger = LoggerFactory.getLogger(getClass());

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.action = new Actions(driver);
    }

    public void click(By locator) {
        checkElement(locator);
        driver.findElement(locator).click();
        logger.info("Bulunan Elemente tıklandı");
    }
    public void doubleClick(By locator, int times) throws InterruptedException {
        checkElement(locator);
        for(int i=0; i<times; i++){

            driver.findElement(locator).click();
            wait(2);
        }
        logger.info("Bulunan Elemente " + times + " Kere Tiklandi" );
    }
    public void writeToElement(By locator, String value) {
        checkElement(locator);
        driver.findElement(locator).sendKeys(value);
        logger.info("Bulunan Elemente " + value + " değeri yazıldı.");
    }
    public void wait(int saniye) throws InterruptedException {
        Thread.sleep(saniye * 1000);
    }
    public boolean checkElement(By locator){
        try {
            WebDriverWait elementVarmı = new WebDriverWait(driver, Duration.ofSeconds(5));
            elementVarmı.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info(locator + " Elementi Bulundu ");
            return true;
        } catch (Exception e){
            logger.info(locator + " Elementini Bulmak Icin 30 SN Beklendi Fakat Bulunamadı");
            return false;
        }
    }
    public void checkText(By locator, String expText){
        checkElement(locator);

        if (expText.equals(driver.findElement(locator).getText())){
            logger.info( "Elementin Text Degeri " + expText + " Degerini Iceriyor");
        }else{
            logger.info("Elementin Text degeri Beklenen " + expText + " Text Degerini Icermiyor");
        }
    }
    public void clickRandom(By locator) {

        checkElement(locator);
        List<WebElement> elements = driver.findElements(locator);
        Random rand = new Random();
        int index = rand.nextInt(Math.min(elements.size(),4));
        elements.get(index).click();
        logger.info("Bulunan Elemente Random Metodu Ile Tiklandi");
    }
    public void saveValue(String key, String val){
        keyMap.put(key,val);
    }
    public void saverMethod(By locator, String key){
        String savedTxt = driver.findElement(locator).getText();
        saveValue(key,savedTxt);
        logger.info(locator + " Elementinde Bulunan " + savedTxt +" Text Degeri " + key + " Adiyla Kaydedildi");
    }
    public String getValue(String key){
        return keyMap.get(key).toString();
    }
    public void checkerMethod(By locator, String key){
        String checkedTxt = driver.findElement(locator).getText();
        //" assert .assertEquals(getValue(key), checkedTxt);
        logger.info(key + " Adiyla Kaydedilmis Text Degeri " + locator + " Icerisinde Bulunan " + checkedTxt + " Ile Karsilastirildi");
    }
}


