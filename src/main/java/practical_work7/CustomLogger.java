package practical_work7;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

import static org.openqa.selenium.OutputType.BYTES;

public class CustomLogger implements WebDriverEventListener {

    private static Logger logger = LoggerFactory.getLogger("WebDriver");

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        logger.info("Перед предупреждением примите");
        Allure.step("Перед предупреждением примите");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        logger.info("После предупреждения примите");
        Allure.step("После предупреждения примите");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        logger.info("После предупреждения отклонить");
        Allure.step("После предупреждения отклонить");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        logger.info("Перед предупреждением отклонить");
        Allure.step("Перед предупреждением отклонить");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        logger.info("Прежде чем перейти к");
        Allure.step("Прежде чем перейти к");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        logger.info("После перейти к");
        Allure.step("После перейти к");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        logger.info("Прежде чем вернуться назад");
        Allure.step("Прежде чем вернуться назад");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        logger.info("После того, как вернетесь назад");
        Allure.step("После того, как вернетесь назад");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        logger.info("Прежде чем двигаться вперед");
        Allure.step("Прежде чем двигаться вперед");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        logger.info("После перехода вперед");
        Allure.step("После перехода вперед");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        logger.info("Перед переходом обновить");
        Allure.step("Перед переходом обновить");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        logger.info("После перехода обновить");
        Allure.step("После перехода обновить");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("Перед тем, как найти: " + webElement.getText());
        Allure.step("Перед тем, как найти: " + webElement.getText());

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        logger.info("После того, как найдете: " + webElement.getText());
        Allure.step("После того, как найдете: " + webElement.getText());

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("Перед кликом на элемент c текстом: " + webElement.getText());
        Allure.step("Перед кликом на элемент c текстом: " + webElement.getText());

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        logger.info("После клика на элемент c текстом: " + webElement.getText());
        Allure.step("После клика на элемент c текстом: " + webElement.getText());

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        logger.info("Перед изменением значения: " + webElement.getText());
        Allure.step("Перед изменением значения: " + webElement.getText());

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        logger.info("После изменения значения: " + webElement.getText());
        Allure.step("После изменения значения: " + webElement.getText());

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        logger.info("Перед сценарием");
        Allure.step("Перед сценарием");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        logger.info("После сценария");
        Allure.step("После сценария");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("Прежде чем переключиться на окно");
        Allure.step("Прежде чем переключиться на окно");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        logger.info("После переключения в окно");
        Allure.step("После переключения в окно");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        logger.info("В порядке исключения");
        Allure.step("В порядке исключения");

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        logger.info("Прежде чем получить скриншот");
        Allure.step("Прежде чем получить скриншот");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        logger.info("После получения скриншота");
        Allure.step("После получения скриншота");
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        logger.info("Прежде чем получить текст: " + webElement.getText());
        Allure.step("Прежде чем получить текст: " + webElement.getText());

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        logger.info("После получения текста: " + webElement.getText());
        Allure.step("После получения текста: " + webElement.getText());

        Allure.addAttachment("Скриншот страницы", new ByteArrayInputStream(
                ((TakesScreenshot)webDriver).getScreenshotAs(BYTES)));
    }
}
