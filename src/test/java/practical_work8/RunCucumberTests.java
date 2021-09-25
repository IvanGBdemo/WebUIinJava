package practical_work8;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
// Обозначаю, что тест запускается с помощью Cucumber
@RunWith(Cucumber.class)
// Устанавливаю параметры, которые будут использоваться при запуске
// Прописываю местоположение файлов Cucumber
@CucumberOptions(features = {"src/test/resources"},
// Настраиваю генерацию отчётов: pretty - раскрашивание шрифта,
// "html:target/cucumber-report/report.html" - тип и местонахождение отчёта
        plugin = {"pretty", "html:target/cucumber-report/report.html"})
public class RunCucumberTests {
}
