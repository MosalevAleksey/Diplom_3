import PageObgekt.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CheckAccountProfileTest {

    private final String EMAIL = "a12-24@yandex.ru";
    private final String PASSWORD = "1583117";
    private WebDriver driver;
    private HomePageElement objQaScooterPageElement;
    private AccauntProfile objAccauntProfile;
    private Register objRegisterPage;
    private ForgotPassword objForgotPassword;
    private PersonalAccount objPersonalAccount;

    @Before
    public void runDrever() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        //драйвер для браузера Chrome
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
        //driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");
        objQaScooterPageElement = new HomePageElement(driver);
        objAccauntProfile = new AccauntProfile(driver);
        objRegisterPage = new Register(driver);
        objForgotPassword = new ForgotPassword(driver);
        objPersonalAccount = new PersonalAccount(driver);
    }

    @Test
    @DisplayName("Проверка перехода через логотп сетелс бургер")
    public void transitionFromPersonalAccauntToConstructTest() throws InterruptedException {
        // вызываем метод клик кнопка  войти в аккаунт
        objQaScooterPageElement.clickButton(HomePageElement.accauntInButton);
        // заполняем е майл
        objAccauntProfile.clickEditProfile(AccauntProfile.email, EMAIL);
        //заполняем password
        objAccauntProfile.clickEditProfile(AccauntProfile.password, PASSWORD);
        // нажимает кнопку войти
        objAccauntProfile.clickButton(AccauntProfile.EntrenButton);
        // вызываем метод нажать на личный кабинет
        objQaScooterPageElement.clickButton(HomePageElement.personalAccountButton);
        // нажимаем логотп сетелс бургер
        objPersonalAccount.clickButton(PersonalAccount.logoButton);

        //Убедиться что оттображается кнопка "Оформить заказ"
        Assert.assertTrue(objQaScooterPageElement.orderButtonIsExist(objQaScooterPageElement.orderButton));
    }

    @Test
    @DisplayName("Проверка перехода  через кнопку личный кабинет")
    public void transitionPersonalAccountTest() throws InterruptedException {
        // вызываем метод клик кнопка  войти в аккаунт
        objQaScooterPageElement.clickButton(HomePageElement.accauntInButton);
        // заполняем е майл
        objAccauntProfile.clickEditProfile(AccauntProfile.email, EMAIL);
        //заполняем password
        objAccauntProfile.clickEditProfile(AccauntProfile.password, PASSWORD);
        // нажимает кнопку войти
        objAccauntProfile.clickButton(AccauntProfile.EntrenButton);
        // вызываем метод нажать на личный кабинет
        objPersonalAccount.clickButton(HomePageElement.personalAccountButton);

        //Убедиться что оттображается поле "В этом разделе вы можете изменить свои персональные данные"
        Assert.assertTrue(objPersonalAccount.orderButtonIsExist(objPersonalAccount.personalData));
    }

    @Test
    @DisplayName("Проверка выхода  через кнопку выйти")
    public void exitfromPersonalAccountTest() throws InterruptedException {
        // вызываем метод клик кнопка  войти в аккаунт
        objQaScooterPageElement.clickButton(HomePageElement.accauntInButton);
        // заполняем е майл
        objAccauntProfile.clickEditProfile(AccauntProfile.email, EMAIL);
        //заполняем password
        objAccauntProfile.clickEditProfile(AccauntProfile.password, PASSWORD);
        // нажимает кнопку войти
        objAccauntProfile.clickButton(AccauntProfile.EntrenButton);
        // вызываем метод нажать на личный кабинет
        objQaScooterPageElement.clickButton(HomePageElement.personalAccountButton);
        // нажимаем кнопку выход
        objPersonalAccount.clickButton(PersonalAccount.exitButton);

        //Убедиться что оттображается кнопка "Зарегистрироваться"
        Assert.assertTrue(objAccauntProfile.orderButtonIsExist(AccauntProfile.registerButton));
    }

    @After
    public void teardown() {

        driver.quit();
    }


}
