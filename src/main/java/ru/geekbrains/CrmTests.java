package ru.geekbrains;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrmTests {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
// 2 вида ожиданий implicitlyWait и WebDriverWait. Лучше использовать второе, чтобы в пустую не тратить время
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginToCrm();
// Вхожу в пункт в горизонтальном меню
        driver.get("https://crm.geekbrains.space/expense-request/");
        driver.findElement(By.xpath("//a[@title='Создать заявку на расход']")).click();
// Ввожу в поле "назначение"
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_expense_request[description]")));
        driver.findElement(By.name("crm_expense_request[description]")).sendKeys("test");
// Выбираю пункт из списка "Подразделение"
        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select expenditureSelect = new Select(driver.findElement(By.name("crm_expense_request[expenditure]")));
        expenditureSelect.selectByVisibleText("01101 - ОС: вычислительная техника инфраструктуры");

        Select currencySelect = new Select(driver.findElement(By.name("crm_expense_request[currency]")));
        currencySelect.selectByVisibleText("Доллар США");
// Ввожу число в элемент типа input
        driver.findElement(By.name("crm_expense_request[sumPlan]")).sendKeys("100");
// Выбираю в календаре дату
        driver.findElement(By.xpath("//input[contains(@id, 'date_selector_crm_expense_request_datePlan')]")).click();
        driver.findElement(By.xpath("//a[text()='20']")).click();

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Thread.sleep(5000);
        driver.quit();
    }
    // Создаю метод для входа на сайт
    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
// findElement - один из ключевых методов Selenium, находит элемент на странице перед действием
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }
}
