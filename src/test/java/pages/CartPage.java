package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private By purchaseName = By.xpath("//div[@id='box-checkout-cart']//a/strong");

    private WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    public String getPurchaseNameText() {
        return driver.findElement(purchaseName).getText();
    }
}
