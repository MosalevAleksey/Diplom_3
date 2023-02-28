package PageObgekt;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Register {
    //Текст не коректный пароль
    public static By notCorrectPassword = By.xpath("//p[@class = 'input__error text_type_main-default']");
    public static By errorLocator = By.xpath("//p[@class = 'input__error text_type_main-default']");
    //Текст такой пользователь существует
    public static By userAlreadyexists = By.xpath("//*[text()='Такой пользователь уже существует']");
    // Кнопка "Регистрация"
    public static By registerButton = By.xpath("//*[text()='Зарегистрироваться']");
    // Кнопка "войти"
    public static By enterButton = By.className("Auth_link__1fOlj");
    //Поле  Имя
    public By login = By.xpath("//label[text() = 'Имя']//following-sibling::input");
    //Поле  емайл
    public By email = By.xpath("//label[text() = 'Email']//following-sibling::input");
    //Поле  пароль
    public By password = By.xpath("//label[text() = 'Пароль']//following-sibling::input");
    private WebDriver driver;
    public Register(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Нажатия на поле ввода и заолнения формы")
    // метод ожидания прогрузки данных клиента
    public void waitForLoadProfileName() {
        new WebDriverWait(driver, 3);
    }
    @Step("Нажатия на поле ввода и заолнения формы")
    // метод для нажатия на поле ввода и заолнения  формы
    public void clickEditProfile(By weblocator, String text) {
        driver.findElement(weblocator).click();
        new WebDriverWait(driver, 3);
        driver.findElement(weblocator).sendKeys(text);
    }
    @Step("Нажатия кнопку")
    // метод для нажатия кнопку регистрация
    public void clickRegisterButton(By weblocator) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(weblocator).click();
    }
}