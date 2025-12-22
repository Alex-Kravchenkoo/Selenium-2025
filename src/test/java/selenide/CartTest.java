package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.GreenDuckPage;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.$;


public class CartTest {

    @BeforeMethod
    public void setup() {
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 10000;
        Configuration.browserSize = "1920x1080";
        Selenide.open("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public void teardown() {
        Selenide.closeWebDriver();
    }

    @Description("This test validates that when I adds a duck to the cart, the correct item is displayed in the cart")
    @Test(description = "Add duck to the cart")
    public void BuyingAGreenDuckTest() {
        HomePage homePage = new HomePage();
        GreenDuckPage greenDuckPage = new GreenDuckPage();
        CartPage cartPage = new CartPage();

        homePage.clickGreenDuck();
        greenDuckPage.clickAddToCartButton();

        // Ждём, пока счётчик корзины станет "1"
        $(greenDuckPage.getCartQuantityValue()).shouldHave(com.codeborne.selenide.Condition.text("1"));

        greenDuckPage.clickCart();

        String expectedProductName = "Green Duck";
        String actualName = cartPage.getPurchaseNameText();
        Assert.assertEquals(
                actualName,
                expectedProductName,
                "Текст purchaseName должен быть '" + expectedProductName + "'");
    }
}
