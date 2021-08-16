package businessLogic;

import org.openqa.selenium.WebDriver;
import pagesloremipsum.GenerateLoremIpsumPage;
import pagesloremipsum.HomePageLorem;

import java.util.List;

public class BusinessLogicLorem extends BLL {

    private static final String URL_LOREM_IPSUM = "https://lipsum.com/";
    private final HomePageLorem homePageLorem = new HomePageLorem(getDriver());
    private final GenerateLoremIpsumPage generateLoremIpsumPage = new GenerateLoremIpsumPage(getDriver());

    public BusinessLogicLorem(WebDriver driver) {
        super(driver);
    }


    public void choseLanguage() {
        openWelcomePage(URL_LOREM_IPSUM);
        homePageLorem.getLinkRussianLanguage().click();
    }

    public String textFirstParagraph() {
        return textOfFirstElement(homePageLorem.getFirstParagraph());
    }

    public void generateLoremIpsum() {
        openWelcomePage(URL_LOREM_IPSUM);
        homePageLorem.clickOnGenerateLoremIpsum();
    }

    public String firstGeneratedParagraph() {
        return textOfFirstElement(generateLoremIpsumPage.getFirstParagraph());
    }

    public void generate(String keyword, String button) {
        openWelcomePage(URL_LOREM_IPSUM);
        homePageLorem.chooseRadioButton(button);
        homePageLorem.enterAmountInField(keyword);
    }

    public void generate(String button) {
        openWelcomePage(URL_LOREM_IPSUM);
        homePageLorem.chooseRadioButton(button);
        homePageLorem.clickOnGenerateLoremIpsum();
    }

    public String amountWordsInGeneratedText() {
        String words = textOfFirstElement(generateLoremIpsumPage.getFirstParagraph());
        String[] wordsSplit = words.split("\\W+");
        return String.valueOf(wordsSplit.length);
    }

    public String amountCharsInGeneratedText() {
        String words = textOfFirstElement(generateLoremIpsumPage.getFirstParagraph());
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
            List<String> elements = textFromListOfElements(generateLoremIpsumPage.getParagraphGenerated());
            count += elements.stream()
                    .filter(p -> p.contains("lorem"))
                    .count();
            rerunTheGeneration();
        }
        return count / 10;
    }

}
