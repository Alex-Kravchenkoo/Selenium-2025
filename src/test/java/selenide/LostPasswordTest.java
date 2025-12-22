package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.LoginResultPage;
import io.qameta.allure.Step;

public class LostPasswordTest {

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

    @Description("This test validates that when invalid login is used for password recovery, the expected error notification is displayed on the page")
    @Test(description = "Wrong account test")
    public void LostPasswordWithWrongAccountTest() {
        LoginPage loginPage = new LoginPage();
        LoginResultPage loginResultPage = new LoginResultPage();

        loginPage.enterLogin("alex_kravchenko@mail.ru");
        loginPage.clickLostPasswordButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginResultPage.errorMessageIsVisible());//Проверяем что ошибка видна пользователю
        softAssert.assertEquals(loginResultPage.getErrorMessageText(),
                "The email address does not exist in our database.");

        softAssert.assertAll();//Выводим результат по списку проверок

        //LoginPage.enterLogin("alex_kravchenko@mail.ru");
        //LoginPage.enterPassword("wertgyhjk");
        //LoginPage.clickLoginButton();
    }
}
