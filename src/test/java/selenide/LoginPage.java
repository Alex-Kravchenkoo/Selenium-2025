package selenide;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private  By loginInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");
    private By lostPasswordButton = By.name("lost_password");


    public void enterLogin(String username) {
        $(loginInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        $(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        $(loginButton).click();
    }

    public void clickLostPasswordButton() {
        $(lostPasswordButton).click();
    }

    public void login(String username, String password) {
        enterLogin(username);
        enterPassword(password);
        clickLoginButton();
    }
}


