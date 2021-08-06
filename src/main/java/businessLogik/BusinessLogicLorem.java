package businessLogik;

import manager.PageFactoryManagerLorem;
import org.openqa.selenium.WebDriver;

public class BusinessLogicLorem extends PageFactoryManagerLorem {

    private static final String UNCHECK_START_WITH_LOREM_IPSUM = "start";

    public BusinessLogicLorem(WebDriver driver) {
        super(driver);
    }

    public String textFirstParagraph() {
        return getHomePageLorem().getFirstParagraph().getText();
    }

    public void switchedRussianLanguage() {
        getHomePageLorem().getLinkRussianLanguage().click();
    }

    public void pressGenerateLoremIpsum() {
        getHomePageLorem().getGenerateLoremIpsum().click();
    }

    public String textFirstParagraphOfGenerated() {
        return getGenerateLoremIpsumPage().getFirstParagraph().getText();
    }

    public void optionsOfGenerate(String keyword, String button) {
        getHomePageLorem().chooseRadioButton(button);
        getHomePageLorem().enterAmountInField(keyword);
    }

    public String amountWordsInGeneratedText() {
        String words = textFirstParagraphOfGenerated();
        String[] wordsSplit = words.split("\\W+");
        return String.valueOf(wordsSplit.length);
    }

    public String amountCharsInGeneratedText() {
        String words = textFirstParagraphOfGenerated();
        char[] chars = words.toCharArray();
        return String.valueOf(chars.length);
    }

    public void getUncheckStartWithLoremIpsum() {
        getHomePageLorem().chooseRadioButton(UNCHECK_START_WITH_LOREM_IPSUM);
    }

    public void rerunTheGeneration() {
        getGenerateLoremIpsumPage().clickComebackOnHomePage();
        getHomePageLorem().getGenerateLoremIpsum().click();
    }

    public double amountOfKeywordLoremInTextGenerated() {
        double count=0;
        for (int i = 0; i < 10; i++) {
            count += getGenerateLoremIpsumPage().getParagraphGenerated().stream()
                    .filter(p -> p.getText().contains("lorem")||p.getText().contains("Lorem")).count();
            rerunTheGeneration();
        }
        double result = count/10;
        return result;
    }

}
