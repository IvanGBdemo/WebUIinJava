package practical_work5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

import java.util.List;

public class CrmTests {
    static WebDriver driver;
    WebDriverWait webDriverWait;

    private static final String BASE_URL = "https://crm.geekbrains.space/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
    }

    @Test
    void checkTheCreationOfAnExpenseRequest() throws InterruptedException {
        loginToCrm();

        driver.get("https://crm.geekbrains.space/expense-request/");
        driver.findElement(By.xpath("//a[@title='Создать заявку на расход']")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_expense_request[description]")));
        driver.findElement(By.name("crm_expense_request[description]")).sendKeys("test");

        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select expenditureSelect = new Select(driver.findElement(By.name("crm_expense_request[expenditure]")));
        expenditureSelect.selectByVisibleText("01101 - ОС: вычислительная техника инфраструктуры");

        Select currencySelect = new Select(driver.findElement(By.name("crm_expense_request[currency]")));
        currencySelect.selectByVisibleText("Доллар США");

        driver.findElement(By.name("crm_expense_request[sumPlan]")).sendKeys("100");

        driver.findElement(By.xpath("//input[contains(@id, 'date_selector_crm_expense_request_datePlan')]")).click();
        driver.findElement(By.xpath("//a[text()='20']")).click();

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Thread.sleep(5000);

        assertThat(driver.findElement(By
                        .xpath("//*[@class='string-cell grid-cell grid-body-cell grid-body-cell-description']")),
                hasText("test"));

        Thread.sleep(5000);
    }

    @Test
    void createCrmProjectExampleTest() throws InterruptedException {
        loginToCrm();

        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Проекты']"));
        actions.moveToElement(projectMenuElement).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_project_index']/a")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("crm_project[name]");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("1234");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> organizationVars = driver.findElements(By.xpath("//div[@class='select2-result-label']"));
        organizationVars.get(0).click();

        Select prioritySelect = new Select(driver.findElement(By.name("crm_project[priority]")));
        prioritySelect.selectByVisibleText("Средний");

        Select financeSourceSelect = new Select(driver.findElement(By.name("crm_project[financeSource]")));
        financeSourceSelect.selectByVisibleText("Инвестиции");

        Select businessUnitSelect = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        businessUnitSelect.selectByVisibleText("Research & Development");

        Select curatorSelect = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorSelect.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select rpSelect = new Select(driver.findElement(By.name("crm_project[rp]")));
        rpSelect.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select administratorSelect = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorSelect.selectByVisibleText("Applanatest2 Applanatest2 Applanatest2");

        Select managerSelect = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerSelect.selectByVisibleText("Амелин Владимир");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")));
        driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='select2-drop']//input")));
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("1 1");
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys(Keys.ENTER);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning-uid')]")));
        driver.findElement(By.xpath("//body")).sendKeys("testtest");

        driver.switchTo().parentFrame();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_requirementsManagement')]")));
        driver.findElement(By.xpath("//body")).sendKeys("test1");
        driver.switchTo().parentFrame();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_development')]")));
        driver.findElement(By.xpath("//body")).sendKeys("test2");
        driver.switchTo().parentFrame();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_testing')]")));
        driver.findElement(By.xpath("//body")).sendKeys("test3");
        driver.switchTo().parentFrame();

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();
        Thread.sleep(5000);

        assertThat(driver.findElement(By
                        .xpath("//*[@class=\"string-cell grid-cell grid-body-cell grid-body-cell-name\"]")),
                hasText("crm_project[name]"));

        Thread.sleep(5000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }
}