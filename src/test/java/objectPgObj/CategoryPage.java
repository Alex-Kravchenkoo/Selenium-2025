package objectPgObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage {
    private By orderByNameButton = By.xpath("//*[@id='box-category']/nav/a[1]");
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
