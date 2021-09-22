package practical_work6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationMenu extends BaseView {

    public NavigationMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li")
// Тип элемента меню будет являться списком
    public List<WebElement> navigationMenuItems;

    public void openNavigationMenuItem(String menuName) {
// Для возможности наведения мышки создаю экземпляр класса Actions
        Actions actions = new Actions(driver);
// Чтобы отфильтровать элементы меню
        actions.moveToElement(navigationMenuItems.stream()
                .filter(element -> element.getText().equals(menuName))
                .findFirst().get()).perform();
    }
}
