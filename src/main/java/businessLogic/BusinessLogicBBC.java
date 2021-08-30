package businessLogic;

import org.openqa.selenium.WebDriver;
import pagesbbc.*;

import java.util.List;
import java.util.Map;

public class BusinessLogicBBC {

    private WebDriver driver;
    private static final String URL_BBC = "https://www.bbc.com";
    private static final long TIME_TO_WAIT = 30;
    CoronavirusPage coronavirusPage;
    HomePage homePage;
    NewsPage newsPage;
    SearchKeywordResultPage searchKeywordResultPage;
    SendUsAStoryPage sendUsAStoryPage;
    YourCoronaStoriesPage yourCoronaStoriesPage;


    public BusinessLogicBBC(WebDriver driver) {
        this.driver = driver;
        coronavirusPage = new CoronavirusPage(driver);
        homePage = new HomePage(driver);
        newsPage = new NewsPage(driver);
        searchKeywordResultPage = new SearchKeywordResultPage(driver);
        sendUsAStoryPage = new SendUsAStoryPage(driver);
        yourCoronaStoriesPage = new YourCoronaStoriesPage(driver);
    }


    public void openNewsPage() {
        HelpManager.openWelcomePage(driver, URL_BBC);
        homePage.clickOnNewsButton();
    }

    public String headLineArticleNews() {
        newsPage.waitForPageLoadComplete(TIME_TO_WAIT);
        return newsPage.getTextOfHeadLineArticleNews();
    }

    public List<String> listSecondaryArticleTitles() {
        newsPage.waitForPageLoadComplete(TIME_TO_WAIT);
        return HelpManager.textFromListOfElements(newsPage.getSecondaryArticleTitles());
    }

    public String getTextOfCategoryLink() {
        return newsPage.getTextOfCategoryLinkOfHeadlineArticle();
    }

    public void enterSearchKeywordCopyLink(String keyword) {
        HelpManager.enterKeyword(keyword, newsPage.getSearchField());
        searchKeywordResultPage.waitForPageLoadComplete(TIME_TO_WAIT);
    }


    public String getTextFirstElementOnPage() {
        return HelpManager.textOfFirstElement(searchKeywordResultPage.getFirstElementOnPage());
    }

    public void openSendStoryPage() {
        openNewsPage();
        newsPage.goToCoronavirusPage();
        coronavirusPage.goToYourCoronaStoriesPage();
        yourCoronaStoriesPage.goToShareWithBBCPage();
    }

    public void sendStoryToBBC(Map<String, String> map) {
        sendUsAStoryPage.fillFormFields(map);
        sendUsAStoryPage.getSubmitButton();
    }

    public String errorMessageOfForm() {
        return sendUsAStoryPage.getErrorMessage().getText();
    }

    public void waiteText(long timeToWait, String text) {
        HelpManager.waitTextToBePresent(driver, timeToWait, text);
    }
}
