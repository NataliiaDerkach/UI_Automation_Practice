package stepdefinitions;

import businessLogic.BusinessLogicLorem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DefinitionStepsLorem {

    private final BusinessLogicLorem logicLorem;


    public DefinitionStepsLorem(TestContext context) {
        logicLorem = new BusinessLogicLorem(context.getDriver());
    }

    @Given("User switch to Russian language on the home page")
    public void userSwitchToRussianLanguageOnTheHomePage() {
        logicLorem.choseLanguage();
    }

    @Then("^User verifies that the text contains (.*)$")
    public void userVerifiesThatTheTextKeywordContains(String keyword) {
        Assert.assertTrue(logicLorem.textFirstParagraph().contains(keyword));
    }

    @Given("User generate lorem ipsum")
    public void userGenerateLoremIpsum() {
        logicLorem.generateLoremIpsum();
    }

    @Given("^User generates (.*) of (.*) on the home page$")
    public void userGeneratesAmountOfButtonOnTheHomePage(String keyword, String button) {
        logicLorem.generate(keyword, button);
    }

    @Then("^User verifies (.*) of (.*) is generated$")
    public void userVerifiesAmountOfButtonIsGenerated(String keyword, String button) {
        if (button.contains("words")) {
            Assert.assertEquals(logicLorem.amountWordsInGeneratedText(), keyword);
        } else if (button.contains("bytes")) {
            Assert.assertEquals(logicLorem.amountCharsInGeneratedText(), keyword);
        }
    }

    @Then("^User verifies that (.*) of (.*) is generated is not correct size$")
    public void userVerifiesThatAmountOfButtonIsGeneratedIsNotCorrectSize(String keyword, String button) {
        if (button.contains("words")) {
            Assert.assertNotEquals(logicLorem.amountWordsInGeneratedText(), keyword);
        } else if (button.contains("bytes")) {
            Assert.assertNotEquals(logicLorem.amountCharsInGeneratedText(), keyword);
        }
    }

    @Given("^User uncheck to (.*) with Lorem Ipsum and generates text$")
    public void userUncheckToStartWithLoremIpsumAndGenerateText(String keyword) {
        logicLorem.generate(keyword);
    }

    @Then("^User verifies that the text not contains (.*)$")
    public void userVerifiesThatTheTextOfTheFirstParagraphNotContainsKeyword(String keyword) {
        Assert.assertFalse(logicLorem.firstGeneratedParagraph().contains(keyword));
    }

    @Then("^User generates (\\d+) times and checks that the word lorem in paragraphs equals to range$")
    public void userGeneratesTimesAndChecksTheAverageNumberOfTheWordLoremInParagraphs(int times) {
        double averageNumber = logicLorem.countWordsLoremInText(times);
        Assert.assertTrue(averageNumber > 2.0 && averageNumber <= 3.0);
    }

}
