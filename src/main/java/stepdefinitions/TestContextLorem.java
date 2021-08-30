package stepdefinitions;

import businessLogic.BusinessLogicLorem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class TestContextLorem {

    private final BusinessLogicLorem logicLorem;

    public TestContextLorem(TestContext context) {
        logicLorem = new BusinessLogicLorem(context.getDriver());
    }

    @Given("User switch to Russian language on the home page")
    public void userSwitchToRussianLanguageOnTheHomePage() {
        logicLorem.choseLanguage();
    }

    @Then("User verifies that the text of the first paragraph, contains {string}")
    public void userVerifiesThatTheTextOfTheFirstParagraphContainsKeyword(String keyword) {
        Assert.assertTrue(logicLorem.textFirstParagraph().contains(keyword));
    }

    @Given("User generate lorem ipsum")
    public void userGenerateLoremIpsum() {
        logicLorem.generateLoremIpsum();
    }

    @Then("User verifies that generated text contains {string}")
    public void userVerifiesThatGeneratedTextContainsExpectedText(String keyword) {
        Assert.assertTrue(logicLorem.firstGeneratedParagraph().contains(keyword));
    }

    @Given("User generates {string} of words{string} on the home page")
    public void userGeneratesAmountOfWordsButtonOnTheHomePage(String keyword, String button) {
        logicLorem.generate(keyword, button);
    }

    @Then("User verifies amount words is generated with correct size{string},{string}")
    public void userVerifiesAmountWordsIsGeneratedWithCorrectSizeAmountButton(String keyword, String button) {
        if (button.contains("words")) {
            Assert.assertEquals(logicLorem.amountWordsInGeneratedText(), keyword);
        } else if (button.contains("bytes")) {
            Assert.assertEquals(logicLorem.amountCharsInGeneratedText(), keyword);
        }
    }

    @Then("User verifies amount words is generated is not correct size{string},{string}")
    public void userVerifiesAmountWordsIsGeneratedIsNotCorrectSizeAmountButton(String keyword, String button) {
        if (button.contains("words")) {
            Assert.assertNotEquals(logicLorem.amountWordsInGeneratedText(), keyword);
        } else if (button.contains("bytes")) {
            Assert.assertNotEquals(logicLorem.amountCharsInGeneratedText(), keyword);
        }
    }

    @Given("User uncheck start with Lorem Ipsum {string} and generate text")
    public void userUncheckStartWithLoremIpsumRadioButtonAndGenerateText(String keyword) {
        logicLorem.generate(keyword);
    }

    @Then("User verifies that the text of the first paragraph, not contains {string}")
    public void userVerifiesThatTheTextOfTheFirstParagraphNotContainsKeyword(String keyword) {
        Assert.assertFalse(logicLorem.firstGeneratedParagraph().contains(keyword));
    }

    @Then("User runs the generation ten times and checks the average number of paragraphs containing the word lorem")
    public void userRunsTheGenerationTenTimesAndChecksTheAverageNumberOfParagraphsContainingTheWordLorem() {
        double amount = logicLorem.countWordsLoremInText();
        System.out.println("amount lorem" + "-" + amount);
        Assert.assertTrue(amount > 2.0 && amount <= 3.0);

    }
}
