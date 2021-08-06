package pagesbbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//nav[@role='navigation']//a[@href='https://www.bbc.com/news']")
    private WebElement newsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnNewsButton() {
        newsButton.click();
    }
}
