package objectPgObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class PositiveLoginTest {
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
    public void LoginWithCorrectAccountTest() {
        LoginPage LoginPage = new LoginPage(driver);
        LoginResultPage loginResultPage = new LoginResultPage(driver);

        LoginPage.login("b.ur.m.a.b.o.ok.e.r@gmail.com", "ASDqwe");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginResultPage.successMessageIsVisible());//Проверяем что ошибка видна пользователю
        softAssert.assertEquals(loginResultPage.getSuccessMessageText(),
                "You are now logged in as asd asd.");

        softAssert.assertAll();//Выводим результат по списку проверок
    }
}
