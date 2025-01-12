package testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions", "utils"},
        tags = "",
        plugin = {
                "summary", "pretty", "html:Reports/CucumberReport/Reports.html"
        },publish = true
        //mvn test -Dcucumber.filter.tags="@debug"
)
public class runner extends AbstractTestNGCucumberTests {
    static WebDriver driver = DriverFactory.getDriver();
}