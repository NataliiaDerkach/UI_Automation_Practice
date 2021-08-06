package manager;

import org.openqa.selenium.WebDriver;
import pagesloremipsum.GenerateLoremIpsumPage;
import pagesloremipsum.HomePageLorem;

public class PageFactoryManagerLorem {

    private WebDriver driver;

    public PageFactoryManagerLorem(WebDriver driver) {
        this.driver = driver;
    }

    public HomePageLorem getHomePageLorem() {
        return new HomePageLorem(driver);
    }

    public GenerateLoremIpsumPage getGenerateLoremIpsumPage() {
        return new GenerateLoremIpsumPage(driver);
    }
}
