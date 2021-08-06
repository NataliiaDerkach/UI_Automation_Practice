package pagesbbc;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class Forms {

    WebDriver driver;
    private List<WebElement> formField;
    private List<WebElement> checkbox;

    public Forms(WebDriver driver, List<WebElement> formField, List<WebElement> checkbox) {
        this.driver = driver;
        this.formField = formField;
        this.checkbox = checkbox;
    }

    public void fillForm(Map<String, String> map) {
        map.forEach((k, v) -> {
            formField.forEach(i -> {
                if (i.getAttribute("aria-label").contains(k)) {
                    i.sendKeys(v, Keys.ENTER);
                }
            });
            if (k.contains("checkbox")) {
                checkbox.forEach(WebElement::click);
            }
        });
    }
}
