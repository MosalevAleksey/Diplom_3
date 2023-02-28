package PageObgekt;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccount {
    // поле login
    public static By login = By.xpath("//label[text() = 'login']//following-sibling::input");
    //Поле  емайл
    public static By email = By.xpath("//label[text() = 'Email']//following-sibling::input");
    //Поле  пароль
    public static By password = By.xpath("//label[text() = 'Пароль']//following-sibling::input");
    // Кнопка "ds[jl"
    public static By exitButton = By.xpath("//*[text() = 'Выход']");
    //Поле "В этом разделе вы можете изменить свои персональные данные"
    public static By personalData = By.xpath("//*[text() = 'В этом разделе вы можете изменить свои персональные данные']");
    // Кнопка "Логотип сетлс бургер" Hader
    public static By logoButton = By.className("AppHeader_header__logo__2D0X2");
    private WebDriver driver;
    public PersonalAccount(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Убедиться в наличии надписи на экране")
    public boolean orderButtonIsExist(By weblocator) throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(weblocator).isDisplayed();
    }
    @Step("Нажатия на поле ввода и заолнения формы")
    // метод для нажатия на поле ввода и заолнения  формы
    public void clickEditProfile(By weblocator, String text) {
        driver.findElement(weblocator).click();
        new WebDriverWait(driver, 3);
        driver.findElement(weblocator).sendKeys(text);
    }
    @Step("Нажатие на кнопку ")
    // метод для нажатия кнопку регистрация
    public void clickButton(By weblocator) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(weblocator).click();
    }


}
