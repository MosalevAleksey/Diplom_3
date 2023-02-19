package PageObgekt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageElement {
    private WebDriver driver;

    public HomePageElement(WebDriver driver) {
        this.driver = driver;
    }

    // Кнопка "Личный кабинет" Hader
    public static By personalAccountButton = By.xpath("//*[text()='Личный Кабинет']");
    // Кнопка "конструктор" Hader
    public static By constructionButton = By.xpath("//*[text()='Конструктор']");
    // Кнопка "Лента заказов" Hader
    public static By orderArrayButton = By.xpath("//*[text()='Лента Заказов']");
    // Кнопка "Логотип сетлс бургер" Hader
    public static By logoButton = By.className("AppHeader_header__logo__2D0X2");
    //Кнопка "Оформить заказ"
    public static By orderButton = By.xpath("//*[text()='Оформить заказ']");


    // Поле "Булки"
    public static By breadField = By.xpath("//span[text() = 'Булки']");// ".//button[(@class = 'text text_type_main-medium mb-6 mt-10' and text()='Булки') ]"
    // Кнопка "Соусы"
    public static By sousField = By.xpath("//span[text() = 'Соусы']");
    // Кнопка "Начинки"
    public static By fillingBField = By.xpath("//span[text() = 'Начинки']");


    // Кнопка "Булки"
    public static By breadButton = By.xpath("//h2[text() = 'Булки']");
    // Кнопка "Соусы"
    public static By sousButton = By.xpath("//h2[text() = 'Соусы']");
    // Кнопка "Начинка"
    public static By fillingButton = By.xpath("//h2[text() = 'Начинки']");


    // Кнопка "Войти в аккаунт"
    public static By accauntInButton = By.xpath("//*[text()='Войти в аккаунт']");


    // метод ожидания прогрузки данных клиента
    public boolean orderButtonIsExist(By weblocator) throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(weblocator).isDisplayed();
    }

    // метод для нажатия на поле ввода и заолнения  формы
    public void clickEditProfile(By weblocator, String text) {
        driver.findElement(weblocator).click();
        new WebDriverWait(driver, 3);
        driver.findElement(weblocator).sendKeys(text);
    }

    // метод для нажатия кнопку регистрация
    public void clickButton(By weblocator) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(weblocator).click();
    }

}
