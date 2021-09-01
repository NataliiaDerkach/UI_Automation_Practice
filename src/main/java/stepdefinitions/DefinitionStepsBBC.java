package stepdefinitions;

import businessLogic.BusinessLogicBBC;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class DefinitionStepsBBC {

    private String textOfCopyLink = "";
    private static final long TIME_TO_WAIT = 30;
    private final BusinessLogicBBC logicBBC;

    public DefinitionStepsBBC(TestContext context) {
        logicBBC = new BusinessLogicBBC(context.getDriver());
    }

    @Given("User opens news page")
    public void userOpensNewsPage() {
        logicBBC.openNewsPage();
    }

    @Then("User checks the {string} name of the article")
    public void userChecksTheTitleHeadLineNameOfTheArticle(String keyword) {
        Assert.assertTrue(logicBBC.headLineArticleNews().contains(keyword));
    }

    @Then("User checks the name of secondary article titles:")
    public void userChecksTheNameOfSecondaryArticleTitles(DataTable dataTable) {
        List<String> list = dataTable.asList();
        List<String> actual = logicBBC.listSecondaryArticleTitles();
        Assert.assertEquals(actual, list);
    }

    @And("User submitted to the search field the category link from the first article")
    public void userSubmittedToTheSearchFieldTheCategoryLinkFromTheFirstArticle() {
        textOfCopyLink = logicBBC.getTextOfCategoryLink();
        logicBBC.enterSearchKeywordCopyLink(textOfCopyLink);
    }

    @Then("User checks that the header of the first article contains searched keyword")
    public void userChecksThatTheHeaderOfTheFirstArticleContainsSearchedKeyword() {
        Assert.assertTrue(logicBBC.getTextFirstElementOnPage().contains(textOfCopyLink));
    }

    @Given("User opens page contains form")
    public void userOpensPageContainsForm() {
        logicBBC.openSendStoryPage();
    }

    @And("User fills out the form field:")
    public void userFillsOutTheFormField(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        logicBBC.sendStoryToBBC(map);
    }

    @Then("User checks error message in form{string}")
    public void userChecksErrorMessageInFormErrorMessage(String keyword) {
        logicBBC.waiteText(TIME_TO_WAIT, keyword);
        Assert.assertTrue(logicBBC.errorMessageOfForm().contains(keyword));
    }
}
