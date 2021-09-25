package practical_work8;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProjectsSubMenu {

    private SelenideElement projectsRequestsMenuItem = $(By.xpath("//span[text()='Все проекты']"));

    // Создаю метод, который кликает по кнопке "Заявки на расходы"
    public ProjectsRequestsPage goToProjectsRequestsPage() {
        projectsRequestsMenuItem.click();
        return page(ProjectsRequestsPage.class);
    }
}
