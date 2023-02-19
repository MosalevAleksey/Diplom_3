package PageObgekt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword {
    private WebDriver driver;
    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }



    //Поле  емайл
    By email = By.xpath("/html/body/div/div/main/div/form/fieldset/div/div/input");

    // Кнопка "Востановить"
    public static By recovoryButton = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa");
    // Кнопка "войти"
      public static By enterButton = By.xpath("//*[text()='Войти']");

    // метод ожидания прогрузки данных клиента
    public void waitForLoadProfileName() {
        new WebDriverWait(driver, 10);
    }
    // метод для нажатия на поле ввода и заолнения  формы
    public void clickEditProfile(By weblocator, String text) {
        driver.findElement(weblocator).click();
        new WebDriverWait(driver, 3);
        driver.findElement(weblocator).sendKeys(text);
    }
    // метод для нажатия кнопку регистрация
    public void clickButton(By weblocator) {
        driver.findElement(weblocator).click();
    }
}

