package pagesloremipsum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageLorem {

    WebDriver driver;

    public BasePageLorem(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
