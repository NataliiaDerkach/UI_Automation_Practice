package stepdefinitions;

import businessLogik.BusinessLogicBBC;
import businessLogik.BusinessLogicLorem;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
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

    @Given("User opens {string} page")
    public void openPage(final String url) {
        businessLogicBBC.openHomePage(url);
    }

    @When("User opens news page")
    public void userOpensNewsPage() {
        businessLogicBBC.goToNewsPage();
    }

    @And("User checks the name {string} of the article")
    public void userChecksTheNameNameOfHeadLineArticleOfTheArticle(String keyword) {
        Assert.assertTrue(businessLogicBBC.textHeadLineArticleNews().contains(keyword));
    }

    @Then("User checks the name of secondary article titles:")
    public void userChecksTheNameOfSecondaryArticleTitles(DataTable dataTable) {
        List<String>list=dataTable.asList();
        List<String> actual = businessLogicBBC.getTextOfElementFromList();
        Assert.assertEquals(actual, list);
    }

    @And("User submitted to the search field the category link from the first article")
    public void userSubmittedToTheSearchFieldTheCategoryLinkFromTheFirstArticle() {
        textOfCopyLink = businessLogicBBC.getTextOfCategoryLink();
        businessLogicBBC.enterSearchKeyword(textOfCopyLink);
    }

    @Then("User checks that the header of the first article contains searched keyword")
    public void userChecksThatTheHeaderOfTheFirstArticleContainsSearchedKeyword() {
        Assert.assertTrue(businessLogicBBC.getTextOfFirstElementOnPage().contains(textOfCopyLink));
    }

    @And("User opens coronavirus page")
    public void userOpensCoronavirusPage() {
        businessLogicBBC.goToCoronaVirusPage();
    }

    @And("User opens your coronavirus stories page")
    public void userOpensYourCoronavirusStoriesPage() {
        businessLogicBBC.goToYourCoronavirusStoriesPage();
    }

    @And("User choose link of how to share with BBC")
    public void userChooseLinkOfHowToShareWithBBC() {
        businessLogicBBC.clickOnHowToShareWithBBC();
    }

    @Then("User checks error message in form{string}")
    public void userChecksErrorMessageInFormErrorMessage(String keyword) {
        businessLogicBBC.waitTextToBePresent(TIME_TO_WAIT, keyword);
        Assert.assertTrue(businessLogicBBC.errorMessageOfForm().contains(keyword));
    }

    @And("User fills out the form field:")
    public void userFillsOutTheFormField(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        businessLogicBBC.testSendStoryToBBC(map);
    }

    @And("User switch to Russian language")
    public void userSwitchToRussianLanguage() {
        businessLogicLorem.switchedRussianLanguage();
    }

    @Then("User verifies that the text of the first paragraph, contains {string}")
    public void userVerifiesThatTheTextOfTheFirstParagraphContainsKeyword(String keyword) {
        Assert.assertTrue(businessLogicLorem.textFirstParagraph().contains(keyword));
    }

    @And("User generate lorem ipsum")
    public void userGenerateLoremIpsum() {
        businessLogicLorem.pressGenerateLoremIpsum();
    }

    @Then("User verifies that default setting result in text contains {string}")
    public void userVerifiesThatDefaultSettingResultInTextContainsExpectedText(String keyword) {
        Assert.assertTrue(businessLogicLorem.textFirstParagraphOfGenerated().contains(keyword));
    }

    @And("User generates {string} of words{string}")
    public void userGeneratesAmountOfWordsButton(String keyword, String button) {
        businessLogicLorem.optionsOfGenerate(keyword, button);

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

    @And("User uncheck start with Lorem Ipsum checkbox")
    public void userUncheckStartWithLoremIpsumCheckbox() {
        businessLogicLorem.getUncheckStartWithLoremIpsum();
    }

    @Then("User verifies that the text of the first paragraph, not contains {string}")
    public void userVerifiesThatTheTextOfTheFirstParagraphNotContainsKeyword(String keyword) {
        Assert.assertFalse(businessLogicLorem.textFirstParagraphOfGenerated().contains(keyword));
    }

    @Then("User runs the generation ten times and checks the average number of paragraphs containing the word lorem")
    public void userRunsTheGenerationTenTimesAndChecksTheAverageNumberOfParagraphsContainingTheWordLorem() {
        System.out.println(businessLogicLorem.amountOfKeywordLoremInTextGenerated());
        Assert.assertTrue(String.valueOf(businessLogicLorem.amountOfKeywordLoremInTextGenerated()),
                businessLogicLorem.amountOfKeywordLoremInTextGenerated() > 2.0 && businessLogicLorem.amountOfKeywordLoremInTextGenerated() < 3.0);

    }


}
