package pagesloremipsum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RadioButton {

    WebDriver driver;

    private List<WebElement> radioButton;

    public RadioButton(WebDriver driver, List<WebElement> radioButton) {
        this.driver = driver;
        this.radioButton = radioButton;
    }

    public void setValue(String button) {
        radioButton.forEach(element -> {
            if (element.getAttribute("id").contains(button)) {
                element.click();
            }
        });
    }
}
