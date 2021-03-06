package practical_work6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateProjectPage extends BaseView {
    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_project[name]")
    public WebElement projectRequestName;

    public CreateProjectPage fillName(String name) {
        projectRequestName.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement companyFill;

    public CreateProjectPage fillCompany(String company) {
        companyFill.sendKeys(company);
        return this;
    }

    @FindBy(name = "crm_project[priority]")
    public WebElement selectPriority;

    public CreateProjectPage selectPriority(String priority) {
        new Select(selectPriority).selectByVisibleText(priority);
        return this;
    }

    @FindBy(name = "crm_project[financeSource]")
    public WebElement financeSource;

    public CreateProjectPage selectFinanceSource(String finance) {
        financeSource.sendKeys(finance);
        return this;
    }

    @FindBy(name = "crm_project[businessUnit]")
    public WebElement businessUnitSelect;

    public CreateProjectPage selectBusinessUnit(String businessUnit) {
        new Select(businessUnitSelect).selectByVisibleText(businessUnit);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
    public WebElement curatorSelect;

    public CreateProjectPage selectCurator(String curator) {
        new Select(curatorSelect).selectByVisibleText(curator);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement rpSelect;

    public CreateProjectPage selectRp(String rp) {
        new Select(rpSelect).selectByVisibleText(rp);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement administratorSelect;

    public CreateProjectPage selectAdministrator(String administrator) {
        new Select(administratorSelect).selectByVisibleText(administrator);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement managerSelect;

    public CreateProjectPage selectManager(String manager) {
        new Select(managerSelect).selectByVisibleText(manager);
        return this;
    }

    @FindBy(xpath = "//div[contains(@id, 's2id_crm_project_contactMain-uid')]/a")
    public WebElement contactMainSelect;

    public CreateProjectPage selectContactMain(String contactMain) {
        new Select(contactMainSelect).selectByVisibleText(contactMain);
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@id, 'crm_project_planning-uid')]")
    public WebElement planningFill;

    public CreateProjectPage fillPlanning(String planning) {
        new Select(planningFill).selectByVisibleText(planning);
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@id, 'crm_project_requirementsManagement')]")
    public WebElement requirementsManagementFill;

    public CreateProjectPage fillRequirementsManagement(String requirementsManagement) {
        new Select(requirementsManagementFill).selectByVisibleText(requirementsManagement);
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@id, 'crm_project_development')]")
    public WebElement developmentFill;

    public CreateProjectPage fillDevelopment(String development) {
        new Select(developmentFill).selectByVisibleText(development);
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@id, 'crm_project_testing')]")
    public WebElement testingFill;

    public CreateProjectPage fillTesting(String testing) {
        new Select(testingFill).selectByVisibleText(testing);
        return this;
    }

    @FindBy(xpath = saveAndCloseButtonXpathLocator)
    public WebElement saveAndCloseButton;

    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), '?????????????????? ?? ??????????????')]";

    @FindBy(xpath = "//*[text()='???????????? ????????????????']")
    public WebElement requestSavedSuccessfullyElement;
}
