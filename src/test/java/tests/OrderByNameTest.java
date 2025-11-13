package tests;

import pages.CategoryPage;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class OrderByNameTest {
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
    public void OrderByName() {
        HomePage HomePage = new HomePage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        // Нажимаем на заголовок "Name" для сортировки
        HomePage.clickCategoryButton();
        categoryPage.clickOrderByNameButton();

        // Получаем список названий товаров после сортировки
        List<String> productNames = categoryPage.getProductNames().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        System.out.println("Product count: " + categoryPage.getProductNames().size());
        System.out.println(productNames);

        // Проверяем, что список отсортирован по алфавиту
        List<String> sortedNames = productNames.stream()
                .sorted()
                .collect(Collectors.toList());

        Assert.assertEquals(productNames, sortedNames, "Товары должны быть отсортированы по названию");
        // Проверка, что первый товар "Blue Duck"
        Assert.assertEquals(productNames.get(0), "Blue Duck", "Первый товар должен быть 'Blue Duck'");
    }
}
