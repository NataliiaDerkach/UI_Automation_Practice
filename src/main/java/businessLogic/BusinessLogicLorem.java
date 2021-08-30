package businessLogic;

import org.openqa.selenium.WebDriver;
import pagesloremipsum.GenerateLoremIpsumPage;
import pagesloremipsum.HomePageLorem;

import java.util.List;

public class BusinessLogicLorem {

    private WebDriver driver;
    private static final String URL_LOREM_IPSUM = "https://lipsum.com/";
    HomePageLorem homePageLorem;
    GenerateLoremIpsumPage generateLoremIpsumPage;

    public BusinessLogicLorem(WebDriver driver) {
        this.driver = driver;
        homePageLorem = new HomePageLorem(driver);
        generateLoremIpsumPage = new GenerateLoremIpsumPage(driver);
    }

    public void choseLanguage() {
        HelpManager.openWelcomePage(driver, URL_LOREM_IPSUM);
        homePageLorem.getLinkRussianLanguage().click();
    }

    public String textFirstParagraph() {
        return HelpManager.textOfFirstElement(homePageLorem.getFirstParagraph());
    }

    public void generateLoremIpsum() {
        HelpManager.openWelcomePage(driver, URL_LOREM_IPSUM);
        homePageLorem.clickOnGenerateLoremIpsum();
    }

    public String firstGeneratedParagraph() {
        return HelpManager.textOfFirstElement(generateLoremIpsumPage.getFirstParagraph());
    }

    public void generate(String keyword, String button) {
        HelpManager.openWelcomePage(driver, URL_LOREM_IPSUM);
        homePageLorem.chooseRadioButton(button);
        homePageLorem.enterAmountInField(keyword);
    }

    public void generate(String button) {
        HelpManager.openWelcomePage(driver, URL_LOREM_IPSUM);
        homePageLorem.chooseRadioButton(button);
        homePageLorem.clickOnGenerateLoremIpsum();
    }

    public String amountWordsInGeneratedText() {
        String words = HelpManager.textOfFirstElement(generateLoremIpsumPage.getFirstParagraph());
        String[] wordsSplit = words.split("\\W+");
        return String.valueOf(wordsSplit.length);
    }

    public String amountCharsInGeneratedText() {
        String words = HelpManager.textOfFirstElement(generateLoremIpsumPage.getFirstParagraph());
        char[] chars = words.toCharArray();
        return String.valueOf(chars.length);
    }

    public void rerunTheGeneration() {
        generateLoremIpsumPage.clickComebackOnHomePage();
        homePageLorem.clickOnGenerateLoremIpsum();
    }

    public double countWordsLoremInText() {
        double count = 0;
        for (int i = 0; i < 10; i++) {
            List<String> elements = HelpManager.textFromListOfElements(generateLoremIpsumPage.getParagraphGenerated());
            count += elements.stream()
                    .filter(p -> p.contains("lorem"))
                    .count();
            rerunTheGeneration();
        }
        return count / 10;
    }

}
