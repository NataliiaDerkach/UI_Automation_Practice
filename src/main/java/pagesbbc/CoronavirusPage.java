package pagesbbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronavirusPage extends BasePage{

    @FindBy(xpath = "//ul[contains(@class,'gs-o-list-ui--top-no-border nw-c-nav')]//a[@href='/news/have_your_say']")
    private WebElement yourCoronavirusStoriesButton;

    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }

    public void goToYourCoronaStoriesPage() {
        yourCoronavirusStoriesButton.click();
    }
}
