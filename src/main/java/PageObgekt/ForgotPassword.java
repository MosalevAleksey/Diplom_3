package PageObgekt;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword {
    // Кнопка "Востановить"
    public static By recovoryButton = By.xpath("//*[text()='Востановить пароль']");
    // Кнопка "войти"
    public static By enterButton = By.xpath("//*[text()='Войти']");
    //Поле  емайл
    By email =By.xpath("//*[text()='email']");
    private WebDriver driver;
    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатия на поле ввода и заолнения формы")
    // метод для нажатия на поле ввода и заолнения  формы
    public void clickEditProfile(By weblocator, String text) {
        driver.findElement(weblocator).click();
        new WebDriverWait(driver, 3);
        driver.findElement(weblocator).sendKeys(text);
    }
    @Step("Нажатие на кнопку")
    // метод для нажатия кнопку регистрация
    public void clickButton(By weblocator) {
        driver.findElement(weblocator).click();
    }
}

