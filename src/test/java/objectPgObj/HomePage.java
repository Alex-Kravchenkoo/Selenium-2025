package objectPgObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


    private By categoryButton = By.xpath("//*[@id=\"site-menu\"]/ul/li[2]/a");
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

