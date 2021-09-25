package practical_work8;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCrmProjectSteps {

    @Given("I am authorized")
    public void iAmAuthorized() {
        new LoginPage().login("Applanatest1","Student2020!");
    }

    @Given("I am at projects requests page")
    public void iAmAtProjectsRequestsPage() {
        new MainPage().navigationMenu.openNavigationMenuItem("Проекты");
        new ProjectsSubMenu().goToProjectsRequestsPage().createProject();
    }

    @When("I fill name field")
    public void iFillNameField() {
        new CreateProjectPage().fillName("test");
    }

    @And("I fill company")
    public void iFillCompany() {
        new CreateProjectPage().fillCompany("1234");
    }

    @And("I select priority")
    public void iSelectPriority() {
        new CreateProjectPage().selectPriority("Средний");
    }

    @And("I select finance source")
    public void iSelectFinanceSource() {
        new CreateProjectPage().selectFinanceSource("Инвестиции");
    }

    @And("I select business unit")
    public void iSelectBusinessUnit() {
        new CreateProjectPage().selectBusinessUnit("Research & Development");
    }

    @And("I select curator")
    public void iSelectCurator() {
        new CreateProjectPage().selectCurator("Applanatest Applanatest Applanatest"); }

    @And("I select rp")
    public void iSelectRp() {
        new CreateProjectPage().selectRp("Applanatest1 Applanatest1 Applanatest1"); }

    @And("I select administrator")
    public void iSelectAdministrator() {
        new CreateProjectPage().selectAdministrator("Applanatest2 Applanatest2 Applanatest2"); }

    @And("I select manager")
    public void iSelectManager() {
        new CreateProjectPage().selectManager("Амелин Владимир"); }

    @And("I select contact main")
    public void iSelectContactMain() {
        new CreateProjectPage().selectContactMain("1 1"); }

    @And("I fill planning")
    public void iFillPlanning() {
        new CreateProjectPage().fillPlanning("testtest"); }

    @And("I fill requirements management")
    public void iFillRequirementsManagement() {
        new CreateProjectPage().fillRequirementsManagement("test1"); }

    @And("I fill development")
    public void iFillDevelopment() {
        new CreateProjectPage().fillDevelopment("test2");
    }

    @And("I fill testing")
    public void iFillTesting() {
        new CreateProjectPage().fillTesting("test3"); }

    @And("I click save and close button")
    public void iClickSaveAndCloseButton() {
        new CreateProjectPage().saveAndCloseButton.click(); }

    @Then("Success message is visible")
    public void successMessageIsVisible() {
        new CreateProjectPage().requestSavedSuccessfullyElement.shouldBe(Condition.visible); }

    @When("I fill {string} field")
    public void iFillNameField(String name) {
        new CreateProjectPage().fillName(name);
    }
}
