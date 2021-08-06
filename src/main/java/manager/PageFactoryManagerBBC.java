package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagesbbc.*;

public class PageFactoryManagerBBC {

    private WebDriver driver;

    public PageFactoryManagerBBC(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitTextToBePresent(long timeToWait, String text) {
        new WebDriverWait(driver, timeToWait)
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='input-error-message']"), text));
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public NewsPage getNewsPage() {
        return new NewsPage(getDriver());
    }

    public SearchKeywordResultPage getSearchKeywordResultPage() {
        return new SearchKeywordResultPage(getDriver());
    }

    public CoronavirusPage getCoronavirusPage() {
        return new CoronavirusPage(getDriver());
    }

    public YourCoronavirusStoriesPage getYourCoronavirusStoriesPage() {
        return new YourCoronavirusStoriesPage(getDriver());
    }

    public SendUsAStoryPage getSendUsAStoryPage() {
        return new SendUsAStoryPage(getDriver());
    }
}
