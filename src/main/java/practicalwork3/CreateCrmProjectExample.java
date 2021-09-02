package practicalwork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CreateCrmProjectExample {
// Объявляю переменную драйвера
    private static WebDriver driver;

// Создаю код выполнения сценария
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
// Инициализирую драйвер
        driver = new ChromeDriver();
        loginToCrm();
// Для наведения на меню создаю экземпляр класса actions
        Actions actions = new Actions(driver);
        WebElement projectMenuElement = driver.findElement(By.xpath("//a/span[text()='Проекты']"));
        actions.moveToElement(projectMenuElement).perform();
// Кликаю на пункт "Все проекты"
        driver.findElement(By.xpath("//li[@data-route='crm_project_index']/a")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
// Далее заполняю все обязательные пункты
// Команда elementToBeClickable откладывает следующее действие до момента, когда элемент становится кликабельным
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Создать проект']")));
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("crm_project[name]");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("test");
// Команда presenceOfElementLocated откладывает следующее действие до момента, когда элемент появляется в локации
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

        webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")));
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_company')]/a")), "123test"));

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='select2-container select2']")));
        driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='select2-drop']//input")));
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("1111");
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys(Keys.ENTER);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning-uid')]")));
        driver.findElement(By.xpath("//body")).sendKeys("testtest");
// Возвращаю обращение к элементам на основную страницу
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
        driver.quit();
    }
// Создаю метод для входа на сайт
    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }
}
