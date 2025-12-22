package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GreenDuckPage {

    private By addToCartButton = By.name("add_cart_product");
    private By cartQuantity = By.cssSelector("span.quantity");
    private By cart = By.cssSelector("#cart a.link");

    public void clickAddToCartButton() {
        $(addToCartButton).click();
    }

    public void clickCart() {
        $(cart).click();
    }

    // Локатор для проверки в тесте
    public By getCartQuantityValue() {
        return cartQuantity;
    }

    // Если где-то нужно получить число из корзины
    public int getCartQuantity() {
        String countText = $(cartQuantity).getText();
        return Integer.parseInt(countText);
    }
}

