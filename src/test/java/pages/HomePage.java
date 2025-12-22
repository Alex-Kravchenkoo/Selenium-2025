package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private By categoryButton = By.cssSelector("a[href$='rubber-ducks-c-1/']");
    private By GreenDuck = By.xpath("//*[@id='box-most-popular']//div[@class='name' and text()='Green Duck']");

    public void clickCategoryButton() {
        $(categoryButton).click();
    }

    public void clickGreenDuck() {
        $(GreenDuck).click();
    }
}
