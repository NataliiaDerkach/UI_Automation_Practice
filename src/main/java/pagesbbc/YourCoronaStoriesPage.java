package pagesbbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCoronaStoriesPage extends BasePage {

    private static final long TIME_TO_WAIT = 30;

    @FindBy(xpath = "//a[@href='/news/10725415']")
    private WebElement howToShareWithBBCButton;

    public YourCoronaStoriesPage(WebDriver driver) {
        super(driver);
    }

    public void goToShareWithBBCPage() {
        howToShareWithBBCButton.click();
      //  waitForPageLoadComplete(TIME_TO_WAIT);
    }
}
