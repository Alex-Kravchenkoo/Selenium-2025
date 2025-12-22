package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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

    @Test
    public void BuyingAGreenDuckTest() {
        HomePage homePage = new HomePage();
        GreenDuckPage greenDuckPage = new GreenDuckPage();
        CartPage cartPage = new CartPage();

        homePage.clickGreenDuck();
        greenDuckPage.clickAddToCartButton();

        // Ждём, пока счётчик корзины станет "1"
        $(greenDuckPage.getCartQuantityValue()).shouldHave(com.codeborne.selenide.Condition.text("1"));

        greenDuckPage.clickCart();

        String name = cartPage.getPurchaseNameText();
        Assert.assertEquals(name, "Green Duck", "Текст purchaseName должен быть 'Green Duck'");
    }
}
