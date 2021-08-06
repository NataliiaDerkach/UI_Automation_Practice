package pagesloremipsum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GenerateLoremIpsumPage extends BasePageLorem {

    @FindBy(xpath = "(//div[@id='lipsum']/p)[1]")
    private WebElement firstParagraph;

    @FindBy(xpath = "//div[@id='lipsum']/p")
    private List<WebElement> paragraphGenerated;

    @FindBy(xpath = "//a[@href='https://www.lipsum.com/']")
    private WebElement comebackOnHomePage;


    public GenerateLoremIpsumPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstParagraph() {
        return firstParagraph;
    }

    public void clickComebackOnHomePage() {
        comebackOnHomePage.click();
    }

    public List<WebElement> getParagraphGenerated() {
        return paragraphGenerated;
    }
}
