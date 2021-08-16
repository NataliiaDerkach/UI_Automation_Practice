package businessLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BLL {

    private WebDriver driver;

    public BLL(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void openWelcomePage(String url) {
        getDriver().get(url);
    }


    public void enterKeyword(final String keyword, WebElement element) {
        element.sendKeys(keyword, Keys.ENTER);
    }

    public String textOfFirstElement(WebElement element) {
        return element.getText();
    }


    public List<String> textFromListOfElements(List<WebElement>list) {
        List<String> elements = new ArrayList<>();
       list.forEach(i->{
           elements.add(i.getText());
       });
        return elements;
    }

    public void waitTextToBePresent(long timeToWait, String text) {
        new WebDriverWait(driver, timeToWait)
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='input-error-message']"), text));
    }

}
