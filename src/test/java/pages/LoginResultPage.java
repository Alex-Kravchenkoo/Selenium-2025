package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginResultPage {

    private By errorMessage = By.cssSelector(".notice.errors");
    private By successMessage = By.cssSelector(".notice.success");

    private WebDriver driver;

    public LoginResultPage(WebDriver driver) {

        this.driver = driver;
    }

    public boolean errorMessageIsVisible() {
        return driver.findElement(errorMessage).isDisplayed(); //для проверки, что уведомление об ошибке отображается
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean successMessageIsVisible() {
        return driver.findElement(successMessage).isDisplayed(); //для проверки, что уведомление об ошибке отображается
    }

    public String getSuccessMessageText() {
        return driver.findElement(successMessage).getText();
    }
}
