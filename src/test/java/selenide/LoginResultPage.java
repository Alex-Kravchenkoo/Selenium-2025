package selenide;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginResultPage {

    private By errorMessage = By.cssSelector(".notice.errors");
    private By successMessage = By.cssSelector(".notice.success");


    public boolean errorMessageIsVisible() {
        return $(errorMessage).isDisplayed(); //для проверки, что уведомление об ошибке отображается
    }

    public String getErrorMessageText() {
        return $(errorMessage).getText();
    }

    public boolean successMessageIsVisible() {
        return $(successMessage).isDisplayed(); //для проверки, что уведомление об ошибке отображается
    }

    public String getSuccessMessageText() {
        return $(successMessage).getText();
    }
}
