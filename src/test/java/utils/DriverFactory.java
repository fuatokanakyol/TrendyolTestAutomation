package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import java.util.Properties;

public class DriverFactory {
    static WebDriver driver;
    static Properties properties;

    public static WebDriver initialize_Driver() {
        properties = ConfigReader.getProperties();

        String value = ConfigReader.getProperties().getProperty("browser");
        String headlessValue = ConfigReader.getProperties().getProperty("headless");

        switch (value) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if(headlessValue.equals("true")) {
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if(headlessValue.equals("true")) {
                    firefoxOptions.addArguments("--headless");
                }
                firefoxOptions.addArguments("--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");

                driver = new FirefoxDriver(firefoxOptions);
                ;
                break;
            case "Safari":
                WebDriverManager.safaridriver().setup();

                driver = new SafariDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions2 = new ChromeOptions();
                if(headlessValue.equals("true")) {
                    chromeOptions2.addArguments("--headless");
                }
                chromeOptions2.addArguments("--disable-gpu", "--no-sandbox", "--disable-dev-shm-usage");
                driver = new ChromeDriver(chromeOptions2);
                break;
        }
        String url = properties.getProperty("url");
        driver.get(url);
        driver.manage().window().maximize();
        return getDriver();
    }
    public static WebDriver getDriver() {
        return driver;
    }
}