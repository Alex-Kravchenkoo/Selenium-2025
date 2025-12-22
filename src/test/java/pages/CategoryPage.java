package pages;

import org.openqa.selenium.By;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryPage {

    private By orderByNameButton = By.cssSelector("a.button[href*='sort=name']");
    private By productNames = By.cssSelector("div.name");

    public void clickOrderByNameButton() {
        $(orderByNameButton).click();
    }

    public ElementsCollection getProductNames() {
        return $$(productNames);
    }
}