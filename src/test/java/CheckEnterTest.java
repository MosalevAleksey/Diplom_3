import PageObgekt.AccauntProfile;
import PageObgekt.ForgotPassword;
import PageObgekt.HomePageElement;
import PageObgekt.Register;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class CheckEnterTest {

    private final String EMAIL = "a12-24@yandex.ru";
    private final String PASSWORD = "1583117";
    private WebDriver driver;
    private HomePageElement objHomePageElement;
    private AccauntProfile objAccauntProfile;
    private Register objRegisterPage;
    private ForgotPassword objForgotPassword;

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
        objHomePageElement = new HomePageElement(driver);
        objAccauntProfile = new AccauntProfile(driver);
        objRegisterPage = new Register(driver);
        objForgotPassword = new ForgotPassword(driver);
    }

    @Test
    @DisplayName("Проверка входа через кнопку войти")
    public void logInLogInButtonTest() {
        // вызываем метод клик кнопка  войти в аккаунт
        objHomePageElement.clickButton(HomePageElement.accauntInButton);
        // заполняем е майл
        objAccauntProfile.clickEditProfile(AccauntProfile.email, EMAIL);
        //заполняем password
        objAccauntProfile.clickEditProfile(AccauntProfile.password, PASSWORD);
        // нажимает кнопку войти
        objAccauntProfile.clickButton(AccauntProfile.EntrenButton);

        //проверяем что появилась кнопка оформить заказ
        Assert.assertTrue(objHomePageElement.orderButtonIsExist(objHomePageElement.orderButton));
    }

    @Test
    @DisplayName("Проверка входа через кнопку личный кабинет")
    public void personalAccauntButtonTest() {
        // вызываем метод клик кнопка Личный кабинет
        objHomePageElement.clickButton(HomePageElement.personalAccountButton);
        // заполняем е майл
        objAccauntProfile.clickEditProfile(AccauntProfile.email, EMAIL);
        //заполняем password
        objAccauntProfile.clickEditProfile(AccauntProfile.password, PASSWORD);
        // нажимает кнопку войти
        objAccauntProfile.clickButton(AccauntProfile.EntrenButton);
        //проверяем что появилась кнопка оформить заказ
        Assert.assertTrue(objHomePageElement.orderButtonIsExist(objHomePageElement.orderButton));
    }

    @Test
    @DisplayName("Проверка входа через зарегестрироваться кнопку войти")
    public void registretionEnterButtonTest() {
        // вызываем метод клик кнопка Зарегестрироваться
        objHomePageElement.clickButton(HomePageElement.personalAccountButton);
        //нажимаем на кнопку зарегестрироваться
        objAccauntProfile.clickButton(objAccauntProfile.registerButton);
        // нажимаем на кнопку войти
        objRegisterPage.clickRegisterButton(objRegisterPage.enterButton);
        // заполняем е майл
        objAccauntProfile.clickEditProfile(AccauntProfile.email, EMAIL);
        //заполняем password
        objAccauntProfile.clickEditProfile(AccauntProfile.password, PASSWORD);
        // нажимает кнопку войти
        objAccauntProfile.clickButton(AccauntProfile.EntrenButton);

        //проверяем что появилась кнопка оформить заказ
        Assert.assertTrue(objHomePageElement.orderButtonIsExist(objHomePageElement.orderButton));
    }

    @Test
    @DisplayName("Проверка входа через востановление пароля кнопку войти")
    public void passwordRecovoryEnterButtonTest() {
        // вызываем метод клик кнопка смена пароля
        objHomePageElement.clickButton(HomePageElement.personalAccountButton);
        //нажимаем на кнопку востоновить пароль
        objAccauntProfile.clickButton(objAccauntProfile.paswordRecavorByutton);
        // нажимаем на кнопку войти
        objForgotPassword.clickButton(objForgotPassword.enterButton);
        // заполняем е майл
        objAccauntProfile.clickEditProfile(AccauntProfile.email, EMAIL);
        //заполняем password
        objAccauntProfile.clickEditProfile(AccauntProfile.password, PASSWORD);
        // нажимает кнопку войти
        objAccauntProfile.clickButton(AccauntProfile.EntrenButton);

        //проверяем что появилась кнопка оформить заказ
        Assert.assertTrue(objHomePageElement.orderButtonIsExist(objHomePageElement.orderButton));
    }

    @After
    public void teardown() {

        driver.quit();
    }


}

