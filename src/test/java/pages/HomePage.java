package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


    private By categoryButton = By.cssSelector("a[href$='rubber-ducks-c-1/']");
    private By GreenDuck = By.xpath("//div[@id='box-most-popular']//div[@class='name' and text()='Green Duck']");

    private WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickCategoryButton() {
        driver.findElement(categoryButton).click();
    }

    public void clickGreenDuck() {
        driver.findElement(GreenDuck).click();
    }
}

