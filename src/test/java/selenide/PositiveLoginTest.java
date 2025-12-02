package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.LoginResultPage;


public class PositiveLoginTest {

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
    public void LoginWithCorrectAccountTest() {
        LoginPage LoginPage = new LoginPage();
        LoginResultPage loginResultPage = new LoginResultPage();

        LoginPage.login("c9tpp@comfythings.com", "ASDqwe");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginResultPage.successMessageIsVisible());//Проверяем что ошибка видна пользователю
        softAssert.assertEquals(loginResultPage.getSuccessMessageText(),
                "You are now logged in as asdscf dsadsa.");

        softAssert.assertAll();//Выводим результат по списку проверок
    }
}
