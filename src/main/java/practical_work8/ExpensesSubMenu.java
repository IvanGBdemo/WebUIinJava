package practical_work8;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ExpensesSubMenu {

    private SelenideElement expensesRequestsMenuItem = $(By.xpath("//span[text()='Заявки на расходы']"));

    public ExpensesRequestsPage goToExpensesRequestsPage() {
        expensesRequestsMenuItem.click();
        return page(ExpensesRequestsPage.class);
    }
}
