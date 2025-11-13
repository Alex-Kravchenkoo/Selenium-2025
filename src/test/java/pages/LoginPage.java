package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By loginInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");
    private By lostPasswordButton = By.name("lost_password");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public void enterLogin(String username) {
        driver.findElement(loginInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickLostPasswordButton() {
        driver.findElement(lostPasswordButton).click();
    }

    public void login(String username, String password) {
        enterLogin(username);
        enterPassword(password);
        clickLoginButton();
    }
}


