package stepdefinitions;

import businessLogic.BusinessLogicBBC;
import businessLogic.BusinessLogicLorem;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps{

    private static final long TIME_TO_WAIT = 30;
    private String textOfCopyLink = "";

    WebDriver driver;
    private BusinessLogicBBC businessLogicBBC;
    private BusinessLogicLorem businessLogicLorem;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        businessLogicBBC = new BusinessLogicBBC(driver);
        businessLogicLorem = new BusinessLogicLorem(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("User opens news page {string}")
    public void userOpensNewsPageHomePage(final String url) {
        businessLogicBBC.openNewsPage(url);
    }

    @Then("User checks the {string} name of the article")
    public void userChecksTheTitleHeadLineNameOfTheArticle(String keyword) {
        Assert.assertTrue(businessLogicBBC.headLineArticleNews().contains(keyword));
    }

    @Then("User checks the name of secondary article titles:")
    public void userChecksTheNameOfSecondaryArticleTitles(DataTable dataTable) {
        List<String>list=dataTable.asList();
        List<String> actual = businessLogicBBC.listSecondaryArticleTitles();
        Assert.assertEquals(actual, list);
    }

    @And("User submitted to the search field the category link from the first article")
    public void userSubmittedToTheSearchFieldTheCategoryLinkFromTheFirstArticle() {
        textOfCopyLink = businessLogicBBC.getTextOfCategoryLink();
        businessLogicBBC.enterSearchKeywordCopyLink(textOfCopyLink);
    }

    @Then("User checks that the header of the first article contains searched keyword")
    public void userChecksThatTheHeaderOfTheFirstArticleContainsSearchedKeyword() {
        Assert.assertTrue(businessLogicBBC.getTextFirstElementOnPage().contains(textOfCopyLink));
    }

    @Given("User opens page contains form{string}")
    public void userOpensPageContainsFormHomePage(String keyword) {
        businessLogicBBC.openSendStoryPage(keyword);
    }

    @And("User fills out the form field:")
    public void userFillsOutTheFormField(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        businessLogicBBC.sendStoryToBBC(map);
    }

    @Then("User checks error message in form{string}")
    public void userChecksErrorMessageInFormErrorMessage(String keyword) {
        businessLogicBBC.waitTextToBePresent(TIME_TO_WAIT, keyword);
        Assert.assertTrue(businessLogicBBC.errorMessageOfForm().contains(keyword));
    }

    @Given("User switch to Russian language on the home page")
    public void userSwitchToRussianLanguageOnTheHomePage() {
        businessLogicLorem.choseLanguage();
    }

    @Then("User verifies that the text of the first paragraph, contains {string}")
    public void userVerifiesThatTheTextOfTheFirstParagraphContainsKeyword(String keyword) {
        Assert.assertTrue(businessLogicLorem.textFirstParagraph().contains(keyword));
    }

    @Given("User generate lorem ipsum")
    public void userGenerateLoremIpsum() {
        businessLogicLorem.generateLoremIpsum();
    }

    @Then("User verifies that generated text contains {string}")
    public void userVerifiesThatGeneratedTextContainsExpectedText(String keyword) {
        Assert.assertTrue(businessLogicLorem.firstGeneratedParagraph().contains(keyword));
    }

    @Given("User generates {string} of words{string} on the home page")
    public void userGeneratesAmountOfWordsButtonOnTheHomePage(String keyword, String button) {
        businessLogicLorem.generate(keyword, button);
    }

    @Then("User verifies amount words is generated with correct size{string},{string}")
    public void userVerifiesAmountWordsIsGeneratedWithCorrectSizeAmountButton(String keyword, String button) {
        if (button.contains("words")) {
            Assert.assertEquals(businessLogicLorem.amountWordsInGeneratedText(), keyword);
        } else if (button.contains("bytes")) {
            Assert.assertEquals(businessLogicLorem.amountCharsInGeneratedText(), keyword);
        }
    }

    @Then("User verifies amount words is generated is not correct size{string},{string}")
    public void userVerifiesAmountWordsIsGeneratedIsNotCorrectSizeAmountButton(String keyword, String button) {
        if (button.contains("words")) {
            Assert.assertNotEquals(businessLogicLorem.amountWordsInGeneratedText(), keyword);
        } else if (button.contains("bytes")) {
            Assert.assertNotEquals(businessLogicLorem.amountCharsInGeneratedText(), keyword);
        }
    }

    @Given("User uncheck start with Lorem Ipsum {string} and generate text")
    public void userUncheckStartWithLoremIpsumRadioButtonAndGenerateText(String keyword) {
        businessLogicLorem.generate(keyword);
    }

    @Then("User verifies that the text of the first paragraph, not contains {string}")
    public void userVerifiesThatTheTextOfTheFirstParagraphNotContainsKeyword(String keyword) {
        Assert.assertFalse(businessLogicLorem.firstGeneratedParagraph().contains(keyword));
    }

    @Then("User runs the generation ten times and checks the average number of paragraphs containing the word lorem")
    public void userRunsTheGenerationTenTimesAndChecksTheAverageNumberOfParagraphsContainingTheWordLorem() {
        double amount=businessLogicLorem.countWordsLoremInText();
        System.out.println("amount lorem"+ "-"+amount);
        Assert.assertTrue(amount > 2.0 && amount <= 3.0);

    }
}
