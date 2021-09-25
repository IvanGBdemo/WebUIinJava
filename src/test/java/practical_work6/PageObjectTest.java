package practical_work6;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import practical_work8.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static practical_work8.CreateExpenseTestDataElements.baseCreateExpenseData;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;
@Story("Тест сайта crm.geekbrains.space")
public class PageObjectTest extends BaseTest {

    @Test
    @Description ("Тест создания заявки на расходы")
    void checkTheCreationOfAnExpenseRequest() throws InterruptedException {


        driver.get("https://crm.geekbrains.space/");

        new LoginPage()
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Расходы");

        new ExpensesSubMenu(driver).goToExpensesRequestsPage();

        new ExpensesRequestsPage(driver)
                .createExpense()
                .fillName("test")
                .selectBusinessUnit("Research & Development")
                .selectExpenditure("01101 - ОС: вычислительная техника инфраструктуры")
                .selectCurrency("Доллар США")
                .fillSumPlan("1000")
                .selectDatePlan(baseCreateExpenseData.getDate())
                .saveAndCloseButton.click();

        webDriverWait.until(

                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Загрузка')]")));
        assertThat(new CreateExpensePage(driver).requestSavedSuccessfullyElement, isDisplayed());
    }

    @Test
    @Description ("Тест создания проекта")
    void CreateCrmProjectExampleTest() throws InterruptedException {
        driver.get("https://crm.geekbrains.space/");
        new LoginPage()
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Проекты");

        new ProjectsSubMenu(driver).goToProjectsRequestsPage();

        new ProjectsRequestsPage(driver)
                .createProject()
                .fillName("test")
                .fillCompany("1234")
                .selectPriority("Средний")
                .selectFinanceSource("Инвестиции")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Applanatest Applanatest Applanatest")
                .selectRp("Applanatest1 Applanatest1 Applanatest1")
                .selectAdministrator("Applanatest2 Applanatest2 Applanatest2")
                .selectManager("Амелин Владимир")
                .selectContactMain("1 1")
                .fillPlanning("testtest")
                .fillRequirementsManagement("test1")
                .fillDevelopment("test2")
                .fillTesting("test3")
                .saveAndCloseButton.click();

        webDriverWait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Загрузка')]")));
        assertThat(new CreateProjectPage(driver).requestSavedSuccessfullyElement, isDisplayed());
        Thread.sleep(5000);
    }

}
