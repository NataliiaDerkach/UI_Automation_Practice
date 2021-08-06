package pagesbbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchKeywordResultPage extends BasePage {

    @FindBy(xpath = "(//div[@class='ssrcss-12gv2og-Promo ett16tt0']//span[@aria-hidden='false'])[1]")
    private WebElement firstElementOnPage;

    public SearchKeywordResultPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstElementOnPage() {
        return firstElementOnPage;
    }
}
