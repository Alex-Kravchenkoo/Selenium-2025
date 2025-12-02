package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.LoginResultPage;


public class LoginTest {


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
    public void LoginWithDisabledAccountTest() {
        LoginPage LoginPage = new LoginPage();
        LoginResultPage loginResultPage = new LoginResultPage();

        LoginPage.login("alex_kravchenko@mail.ru", "wertgyhjk");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginResultPage.errorMessageIsVisible());//Проверяем что ошибка видна пользователю
        softAssert.assertEquals(loginResultPage.getErrorMessageText(),
                "Wrong password or the account is disabled, or does not exist");

        softAssert.assertAll();//Выводим результат по списку проверок
//        LoginPage.enterLogin("alex_kravchenko@mail.ru");
//        LoginPage.enterPassword("wertgyhjk");
//        LoginPage.clickLoginButton();
    }
}
