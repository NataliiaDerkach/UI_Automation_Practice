package pagesbbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SendUsAStoryPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'text-input')]//input")
    private List<WebElement> formFields;

    @FindBy(xpath = "//div[contains(@class,'text-input')]//textarea")
    private WebElement storyField;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkbox;

    @FindBy(xpath = "//div[@class='button-container']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='input-error-message']")
    private WebElement errorMessage;


    public SendUsAStoryPage(WebDriver driver) {
        super(driver);
    }


    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public void fillFormFields(Map<String, String> map) {
        List<WebElement> list = new ArrayList<>();
        list.add(storyField);
        list.addAll(formFields);
        Forms forms = new Forms(driver, list, checkbox);
        forms.fillForm(map);
    }

}
