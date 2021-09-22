package practical_work6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExpensesSubMenu extends BaseView {
// Создаю конструктор класса
    public ExpensesSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Заявки на расходы']")
    public WebElement expensesRequestsMenuItem;
// Создаю метод, который кликает по кнопке "Заявки на расходы"
    public void goToExpensesRequestsPage() {
        expensesRequestsMenuItem.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(ExpensesRequestsPage.createExpenseXpathLocator)));
    }
}
