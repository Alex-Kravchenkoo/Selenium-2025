package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GreenDuckPage {

    private By addToCartButton = By.name("add_cart_product");
    private By cartQuantity = By.cssSelector("span.quantity");
    private By cart = By.cssSelector("#cart a.link");

    private WebDriver driver;

    public GreenDuckPage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void clickCart() {
        driver.findElement(cart).click();
    }

    public By getCartQuantityValue() {
        return cartQuantity;
    }

    public int getCartQuantity() {
        String countText = driver.findElement(cartQuantity).getText();
        return Integer.parseInt(countText);
    }

}
