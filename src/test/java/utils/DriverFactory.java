package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    static WebDriver driver;
    static Properties properties;

    public static WebDriver initialize_Driver() {
        properties = ConfigReader.getProperties();
        String value = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        //String value = ConfigReader.getProperties().getProperty("browser");
        if (value.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver","./src/test/java/libraries/chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);

        } else if (value.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver","./src/test/java/libraries/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (value.equals("Safari")) {
            driver = new SafariDriver();
        } else {
            driver = new EdgeDriver();
        }
        String url = properties.getProperty("url");
        int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeout"));
        int impWait = Integer.parseInt(properties.getProperty("implicitlyWait"));
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(pageWait, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);
        return getDriver();
    }
    public static WebDriver getDriver() {
        return driver;
    }
}