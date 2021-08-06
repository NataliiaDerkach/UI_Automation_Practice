package businessLogik;

import manager.PageFactoryManagerBBC;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class BusinessLogicBBC extends PageFactoryManagerBBC {

    private static final long TIME_TO_WAIT = 30;


    public BusinessLogicBBC(WebDriver driver) {
        super(driver);
    }


    public void clickOnHowToShareWithBBC() {
        getYourCoronavirusStoriesPage().getHowToShareWithBBCButton().click();
        getSendUsAStoryPage().waitForPageLoadComplete(TIME_TO_WAIT);
    }

    public String getTextOfCategoryLink() {
        return getNewsPage().getTextOfCategoryLinkOfTheHeadlineArticle().getText();
    }

    public String getTextOfFirstElementOnPage(){
        return getSearchKeywordResultPage().getFirstElementOnPage().getText();
    }

    public List<String> getTextOfElementFromList() {
        getNewsPage().waitForPageLoadComplete(TIME_TO_WAIT);
        return getNewsPage().getTextOfSecondaryArticleTitles();
    }

    public void enterSearchKeyword(final String keyword) {
        getNewsPage().getSearchField().sendKeys(keyword, Keys.ENTER);
        getSearchKeywordResultPage().waitForPageLoadComplete(TIME_TO_WAIT);
    }

    public void openHomePage(String url) {
        getDriver().get(url);
    }

    public void goToNewsPage() {
        getHomePage().clickOnNewsButton();
    }

    public void goToCoronaVirusPage() {
        getNewsPage().getCoronavirusButton().click();
        getCoronavirusPage().waitForPageLoadComplete(TIME_TO_WAIT);
    }

    public void goToYourCoronavirusStoriesPage() {
        getCoronavirusPage().getYourCoronavirusStoriesButton().click();
        getYourCoronavirusStoriesPage().waitForPageLoadComplete(TIME_TO_WAIT);
    }


    public String textHeadLineArticleNews() {
        getNewsPage().waitForPageLoadComplete(TIME_TO_WAIT);
        return getNewsPage().getTextOfHeadLineArticleNews();
    }

    public void testSendStoryToBBC(Map<String, String> map) {
        getSendUsAStoryPage().fillFormFields(map);
        getSendUsAStoryPage().getSubmitButton().click();
    }

    public String errorMessageOfForm() {
        return getSendUsAStoryPage().getErrorMessage().getText();
    }



}
