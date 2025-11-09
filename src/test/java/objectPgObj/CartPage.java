package objectPgObj;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private By purchaseName = By.xpath("//*[@id='box-checkout-cart']/div/ul/li/form/div/p[1]/a/strong");

    private WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    public String getPurchaseNameText() {
        return driver.findElement(purchaseName).getText();
    }
}
