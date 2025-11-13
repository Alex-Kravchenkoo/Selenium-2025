package tests;

import pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GreenDuckPage;
import pages.HomePage;

import java.time.Duration;

public class CartTest {


    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        driver.get("https://litecart.stqa.ru/en/");

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void BuyingAGreenDuckTest() {
        HomePage HomePage = new HomePage(driver);
        GreenDuckPage GreenDuckPage = new GreenDuckPage(driver);
        CartPage CartPage = new CartPage(driver);

        HomePage.clickGreenDuck();
        GreenDuckPage.clickAddToCartButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBe(GreenDuckPage.getCartQuantityValue(), "1"));
        GreenDuckPage.clickCart();

        String name = CartPage.getPurchaseNameText();
        Assert.assertEquals(name, "Green Duck", "Текст purchaseName должен быть 'Green Duck'");
    }
}
