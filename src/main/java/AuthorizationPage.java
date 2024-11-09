import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class AuthorizationPage {
    private final WebDriver driver;
    // TODO: Не были добавлены локаторы по причине не доступности сайта и необходимости использования небезопасных VPN
    private final By fieldEmail = By.className(""); // локатор для поля Почта
    private final By fieldPassword = By.className(""); // локатор для поля Пароль
    private final By buttonLogIn = By.className(""); // локатор для кнопки Войти
    private final By logInPage = By.className(""); // окно успешной авторизации
    private final By errorLogInPage = By.className(""); // окно ошибка авторизации

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openFacebook() {
        driver.get("https://ru-ru.facebook.com"); // открытие сайта facebook
    }
    public void inputFieldEmail() {
        driver.findElement(fieldEmail).sendKeys("test@mail.ru"); // ввод существующей почты(существующего пользователя)
    }

    public void inputErrorFieldEmail() {
        driver.findElement(fieldEmail).sendKeys("test@moil.ru"); // ввод несуществующей почты(несуществующего пользователя)
    }

    public void inputFieldPassword() {
        driver.findElement(fieldPassword).sendKeys("123456789");// ввод существующего пароля
    }

    public void inputErrorFieldPassword() {
        driver.findElement(fieldPassword).sendKeys("55454"); // ввод несуществующего пароля
    }

    public void clickLogInButton() {
        driver.findElement(buttonLogIn).click(); // клик по кнопке Войти
    }

    public void checkOpenLogInPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(logInPage));

        assertTrue(driver.findElement(logInPage).isDisplayed()); // Ожидание и проверка отображения страницы об успешной авторизации
    }
    public void checkOpenErrorLogInPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(errorLogInPage));

        assertTrue(driver.findElement(errorLogInPage).isDisplayed()); // Ожидание и проверка отображения страницы об ошибки авторизации
    }

    public void logIn() {
        openFacebook();
        inputFieldEmail();
        inputFieldPassword();
        clickLogInButton();
        checkOpenLogInPage();
    }

    public void errorLogIn() {
        openFacebook();
        inputErrorFieldEmail();
        inputErrorFieldPassword();
        clickLogInButton();
        checkOpenErrorLogInPage();
    }
}
