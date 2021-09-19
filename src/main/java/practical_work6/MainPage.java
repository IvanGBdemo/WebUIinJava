package practical_work6;

import org.openqa.selenium.WebDriver;

public class MainPage extends BaseView {
// Создаю экземпляр ранее собранного класса NavigationMenu на странице
    public NavigationMenu navigationMenu;

    public MainPage(WebDriver driver) {
        super(driver);
// Инициализирую экземпляр NavigationMenu
        navigationMenu = new NavigationMenu(driver);
    }
}
