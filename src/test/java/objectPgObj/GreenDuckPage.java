package objectPgObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GreenDuckPage {

    private By addToCartButton = By.name("add_cart_product");
    private By cartQuantity = By.xpath("//*[@id='cart']/a[2]/span[1]");
    private By cart = By.xpath("//*[@id='cart']/a[2]/strong");

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
