package practical_work8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import static com.codeborne.selenide.Selenide.$;

public class CreateProjectPage {

    private SelenideElement projectRequestName = $(By.name("crm_project[name]"));

    @Step("Ввод названия проекта")
    public CreateProjectPage fillName(String name) {
        projectRequestName.sendKeys(name);
        return this;
    }

    private SelenideElement companyFill = $(By.xpath("//div[@id='select2-drop']//input"));

    @Step("Ввод названия компании")
    public CreateProjectPage fillCompany(String company) {
        companyFill.sendKeys(company);
        return this;
    }

    private SelenideElement selectPriority = $(By.name("crm_project[priority]"));

    @Step("Выбор приоритета")
    public CreateProjectPage selectPriority(String priority) {
        new Select(selectPriority).selectByVisibleText(priority);
        return this;
    }

    private SelenideElement financeSource = $(By.name("crm_project[financeSource]"));

    @Step("Выбор источника финансирования")
    public CreateProjectPage selectFinanceSource(String finance) {
        financeSource.sendKeys(finance);
        return this;
    }

    private SelenideElement businessUnitSelect = $(By.name("crm_project[businessUnit]"));

    @Step("Выбор подразделения")
    public CreateProjectPage selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    private SelenideElement curatorSelect = $(By.name("crm_project[curator]"));

    @Step("Выбор куратора")
    public CreateProjectPage selectCurator(String curator) {
        new Select(curatorSelect).selectByVisibleText(curator);
        return this;
    }

    private SelenideElement rpSelect = $(By.name("crm_project[rp]"));

    @Step("Выбор руководителя проекта")
    public CreateProjectPage selectRp(String rp) {
        new Select(rpSelect).selectByVisibleText(rp);
        return this;
    }

    private SelenideElement administratorSelect = $(By.name("crm_project[administrator]"));

    @Step("Выбор администратора")
    public CreateProjectPage selectAdministrator(String administrator) {
        new Select(administratorSelect).selectByVisibleText(administrator);
        return this;
    }

    private SelenideElement managerSelect = $(By.name("crm_project[manager]"));

    @Step("Выбор менеджера проекта")
    public CreateProjectPage selectManager(String manager) {
        new Select(managerSelect).selectByVisibleText(manager);
        return this;
    }

    private SelenideElement contactMainSelect = $(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a"));

    @Step("Выбор контактного лица")
    public CreateProjectPage selectContactMain(String contactMain) {
        new Select(contactMainSelect).selectByVisibleText(contactMain);
        return this;
    }

    private SelenideElement planningFill = $(By.xpath("//iframe[contains(@id, 'crm_project_planning-uid')]"));

    @Step("Ввод планирования")
    public CreateProjectPage fillPlanning(String planning) {
        new Select(planningFill).selectByVisibleText(planning);
        return this;
    }

    private SelenideElement requirementsManagementFill = $(By
            .xpath("//iframe[contains(@id, 'crm_project_requirementsManagement')]"));

    @Step("Ввод требований менеджмента")
    public CreateProjectPage fillRequirementsManagement(String requirementsManagement) {
        new Select(requirementsManagementFill).selectByVisibleText(requirementsManagement);
        return this;
    }

    private SelenideElement developmentFill = $(By.xpath("//iframe[contains(@id, 'crm_project_development')]"));

    @Step("Ввод программистов")
    public CreateProjectPage fillDevelopment(String development) {
        new Select(developmentFill).selectByVisibleText(development);
        return this;
    }

    private SelenideElement testingFill = $(By.xpath("//iframe[contains(@id, 'crm_project_testing')]"));

    @Step("Ввод тестировщиков")
    public CreateProjectPage fillTesting(String testing) {
        new Select(testingFill).selectByVisibleText(testing);
        return this;
    }

    public SelenideElement saveAndCloseButton = $(By.xpath(saveAndCloseButtonXpathLocator));

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

    public SelenideElement requestSavedSuccessfullyElement = $(By.xpath("//*[text()='Проект сохранен']"));
}
