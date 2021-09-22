package practical_work6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsSubMenu extends BaseView {
    // Создаю конструктор класса
    public ProjectsSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Все проекты']")
    public WebElement projectsRequestsMenuItem;
    // Создаю метод, который кликает по кнопке "Заявки на расходы"
    public void goToProjectsRequestsPage() {
        projectsRequestsMenuItem.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(ProjectsRequestsPage.createProjectXpathLocator)));
    }
}
