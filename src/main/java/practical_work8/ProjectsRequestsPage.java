package practical_work8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProjectsRequestsPage {

    private SelenideElement createProjectButton = $(By.xpath("createProjectXpathLocator"));

    @Step("Создать проект")
    public CreateProjectPage createProject() {
        createProjectButton.click();
        return page(CreateProjectPage.class);
    }

    public static final String createProjectXpathLocator = "//a[text()='Создать проект']";
}
