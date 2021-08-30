package pagesbbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage {

    @FindBy(xpath = "(//div[@data-entityid='container-top-stories#1']//h3)[1]")
    private WebElement headLineArticleNews;

    @FindBy(xpath = "//div[contains(@class,'gel-layout__item nw-c-top-stories__secondary-item')]//h3")
    private List<WebElement> secondaryArticleTitles;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchField;

    @FindBy(xpath = "//li[contains(@class,'gs-o-list-ui__item--flush gel-long-primer')]//a[@href='/news/coronavirus']")
    private WebElement coronavirusButton;

    @FindBy(xpath = "//div[@data-entityid='container-top-stories#1']//a//span")
    private WebElement textOfCategoryLinkOfTheHeadlineArticle;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfHeadLineArticleNews() {
        return headLineArticleNews.getText();
    }

    public List<WebElement> getSecondaryArticleTitles() {
        return secondaryArticleTitles;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public void goToCoronavirusPage() {
         coronavirusButton.click();
    }

    public String getTextOfCategoryLinkOfHeadlineArticle() {
        return textOfCategoryLinkOfTheHeadlineArticle.getText();
    }
}
