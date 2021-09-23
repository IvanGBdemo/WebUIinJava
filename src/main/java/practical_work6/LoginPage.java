package practical_work6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {
// Указываю ти локатора, который применяю
    @FindBy(id = "prependedInput")
// Объявляю WebElement, который называется inputLogin
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    @Step("Ввод логина")
    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Ввод пароля")
    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Клик на кнопку Войти")
    public MainPage clickLoginButton() {
        loginButton.click();
        return new MainPage(driver);
    }

    public void login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
