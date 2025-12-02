package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.HomePage;

import java.util.List;
import java.util.stream.Collectors;

public class OrderByNameTest {

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
    public void OrderByName() {
        HomePage homePage = new HomePage();
        CategoryPage categoryPage = new CategoryPage();

        // Нажимаем на заголовок "Name" для сортировки
        homePage.clickCategoryButton();
        categoryPage.clickOrderByNameButton();

        // Получаем список названий товаров после сортировки
        List<String> productNames = categoryPage.getProductNames().stream()
                .map(element -> element.getText())
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
