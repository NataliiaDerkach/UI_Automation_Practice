package pagesbbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchKeywordResultPage extends BasePage {

    @FindBy(xpath = "(//li//p/span[@aria-hidden='false'])[2]")
    private WebElement firstElementOnPage;

    public SearchKeywordResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstElementOnPage() {
        return firstElementOnPage;
    }
}
