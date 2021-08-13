package businessLogik;

import org.openqa.selenium.WebDriver;
import pagesbbc.*;

import java.util.List;
import java.util.Map;

public class BusinessLogicBBC extends BLL {

    private static final long TIME_TO_WAIT = 30;
    private final CoronavirusPage coronavirusPage = new CoronavirusPage(getDriver());
    private final HomePage homePage = new HomePage(getDriver());
    private final NewsPage newsPage = new NewsPage(getDriver());
    private final SearchKeywordResultPage searchKeywordResultPage = new SearchKeywordResultPage(getDriver());
    private final SendUsAStoryPage sendUsAStoryPage = new SendUsAStoryPage(getDriver());
    private final YourCoronavirusStoriesPage yourCoronavirusStoriesPage = new YourCoronavirusStoriesPage(getDriver());


    public BusinessLogicBBC(WebDriver driver) {
        super(driver);
    }


    public void openNewsPage(String url) {
        openWelcomePage(url);
        homePage.clickOnNewsButton();
    }

    public String headLineArticleNews() {
        newsPage.waitForPageLoadComplete(TIME_TO_WAIT);
        return newsPage.getTextOfHeadLineArticleNews();
    }

    public List<String> listSecondaryArticleTitles() {
        newsPage.waitForPageLoadComplete(TIME_TO_WAIT);
        return textFromListOfElements(newsPage.getSecondaryArticleTitles());
    }

    public String getTextOfCategoryLink() {              //added
        return newsPage.getTextOfCategoryLinkOfTheHeadlineArticle();
    }

    public void enterSearchKeywordCopyLink(String keyword) {
        enterKeyword(keyword, newsPage.getSearchField());
        searchKeywordResultPage.waitForPageLoadComplete(TIME_TO_WAIT);
    }


    public String getTextFirstElementOnPage() {
        return textOfFirstElement(searchKeywordResultPage.getFirstElementOnPage());
    }

    public void openSendStoryPage(String url) {
        openNewsPage(url);
        clickOnElement(newsPage.getCoronavirusButton());
        clickOnElement(coronavirusPage.getYourCoronavirusStoriesButton());
        clickOnElement(yourCoronavirusStoriesPage.getHowToShareWithBBCButton());
        sendUsAStoryPage.waitForPageLoadComplete(TIME_TO_WAIT);
    }

    public void sendStoryToBBC(Map<String, String> map) {
        sendUsAStoryPage.fillFormFields(map);
        sendUsAStoryPage.getSubmitButton().click();
    }

    public String errorMessageOfForm() {
        return sendUsAStoryPage.getErrorMessage().getText();
    }
}
