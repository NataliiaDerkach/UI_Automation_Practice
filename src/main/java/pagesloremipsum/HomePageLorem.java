package pagesloremipsum;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageLorem extends BasePageLorem {

    @FindBy(xpath = "(//div/p)[1]")
    private WebElement firstParagraph;

    @FindBy(xpath = "//a[@href='http://ru.lipsum.com/']")
    private WebElement russianLanguageLink;

    @FindBy(xpath = "//input[@id='generate']")
    private WebElement generateLoremIpsum;

    @FindBy(xpath = "//input[@id='amount']")
    private WebElement amountField;

    @FindBy(xpath = "//tr//td//input")
    private List<WebElement> radioButtons;

    public HomePageLorem(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstParagraph() {
        return firstParagraph;
    }

    public WebElement getLinkRussianLanguage() {
        return russianLanguageLink;
    }

    public void clickOnGenerateLoremIpsum() {
         generateLoremIpsum.click();
    }

    public void enterAmountInField(final String keyword) {
        amountField.clear();
        amountField.sendKeys(keyword, Keys.ENTER);
    }

    public void chooseRadioButton(String button) {
        RadioButton radioButton = new RadioButton(driver, radioButtons);
        radioButton.setValue(button);
    }
}
