package stepdefinitions;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class TestContext {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public TestContext() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void close() {
        getDriver().close();
    }

}
