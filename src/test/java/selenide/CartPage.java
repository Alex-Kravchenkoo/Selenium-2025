package selenide;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private By purchaseName = By.xpath("//div[@id='box-checkout-cart']//a/strong");

    public String getPurchaseNameText() {
        return $(purchaseName).getText();
    }
}