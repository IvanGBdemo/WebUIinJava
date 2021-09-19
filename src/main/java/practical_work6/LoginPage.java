package practical_work6;

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
// Создаю методы, которые позволят работать на странице
    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
// Метод будет возвращать LoginPage и себя (this)
        return this;
    }
// Создаю метод, который нажимает кнопку "Зайти"
    public MainPage clickLoginButton() {
        loginButton.click();
        return new MainPage(driver);
    }

    public void login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        loginButton.click();
    }
// Передаю в конструктор класса WebDriver
    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
