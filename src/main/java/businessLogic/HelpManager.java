package businessLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HelpManager {


    public static void openWelcomePage(WebDriver driver, String url) {
        driver.get(url);
    }


    public static void enterKeyword(final String keyword, WebElement element) {
        element.sendKeys(keyword, Keys.ENTER);
    }

    public static String textOfFirstElement(WebElement element) {
        return element.getText();
    }


    public static List<String> textFromListOfElements(List<WebElement> list) {
        List<String> elements = new ArrayList<>();
        list.forEach(i -> {
            elements.add(i.getText());
        });
        return elements;
    }

    public static void waitTextToBePresent(WebDriver driver, long timeToWait, String text) {
        new WebDriverWait(driver, timeToWait)
                .until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='input-error-message']"), text));
    }


}
