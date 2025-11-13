package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage {
    private By orderByNameButton = By.cssSelector("a.button[href*='sort=name']");
    private By productNames = By.cssSelector("div.name");
    private WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderByNameButton() {
        driver.findElement(orderByNameButton).click();
    }

    public List<WebElement> getProductNames() {
        return driver.findElements(productNames);
    }
}
