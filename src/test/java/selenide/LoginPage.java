package selenide;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private By loginInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");
    private By lostPasswordButton = By.name("lost_password");

    @Step("Enter login")
    public void enterLogin(String username) {
        $(loginInput).sendKeys(username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        $(passwordInput).sendKeys(password);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        $(loginButton).click();
    }

    @Step("Click lost password button")
    public void clickLostPasswordButton() {
        $(lostPasswordButton).click();
    }

    @Step("Login")
    public void login(String username, String password) {
        enterLogin(username);
        enterPassword(password);
        clickLoginButton();
    }
}


