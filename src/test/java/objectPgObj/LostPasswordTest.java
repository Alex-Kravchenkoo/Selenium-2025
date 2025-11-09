package objectPgObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LostPasswordTest {

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
    public void LostPasswordWithWrongAccountTest() {
        LoginPage LoginPage = new LoginPage(driver);
        LoginResultPage loginResultPage = new LoginResultPage(driver);

        LoginPage.enterLogin("alex_kravchenko@mail.ru");
        LoginPage.clickLostPasswordButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginResultPage.errorMessageIsVisible());//Проверяем что ошибка видна пользователю
        softAssert.assertEquals(loginResultPage.getErrorMessageText(),
                "The email address does not exist in our database.");

        softAssert.assertAll();//Выводим результат по списку проверок
//        LoginPage.enterLogin("alex_kravchenko@mail.ru");
//        LoginPage.enterPassword("wertgyhjk");
//        LoginPage.clickLoginButton();

    }
}

