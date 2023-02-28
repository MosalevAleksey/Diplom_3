import PageObgekt.AccauntProfile;
import PageObgekt.HomePageElement;
import PageObgekt.PersonalAccount;
import PageObgekt.Register;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Parameterized.class)
public class CheckRegistreTest {
    private final String NAME;
    private final String EMAIL;
    private final String PASSWORD;
    private final String TEXT;
    private final By LOCKATOR;
    private WebDriver driver;
    private HomePageElement objQaScooterPageElement;
    private Register objRegisterPage;
    private PersonalAccount objPersonalAccount;

    public CheckRegistreTest(String name, String email, String password, String Text, By lockator) {
        NAME = name;
        EMAIL = email;
        PASSWORD = password;
        TEXT = Text;
        LOCKATOR = lockator;
    }

    @Parameterized.Parameters
    public static Object[][] checkTexst() {
        return new Object[][]{

                {"Сергей", "mata@ya.com", "123456", "Такой пользователь уже существует", Register.userAlreadyexists},
                {"Сергей", "mata@ya.com", "12345", "Некорректный пароль", Register.errorLocator},
        };
    }

    @Before
    public void runDrever() {

        //Драйвер Chrome без UI.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        //драйвер для браузера Chrome
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
       // driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");
        objQaScooterPageElement = new HomePageElement(driver);
        objRegisterPage = new Register(driver);
        objPersonalAccount = new PersonalAccount(driver);
    }
    @Test
    @DisplayName("Проверка регистрации с правильнм и коротким паролем")
    public void userRegistrationTest() throws InterruptedException {
        // вызываем метод клик кнопка войти в аккаунт
        objQaScooterPageElement.clickButton(HomePageElement.accauntInButton);
        // создай объект класса заполнения заказа
        objPersonalAccount.clickButton(AccauntProfile.registerButton);
        //метод ожидания поля формы
        objRegisterPage.waitForLoadProfileName();
        //метод заполнения поля имя
        objRegisterPage.clickEditProfile(objRegisterPage.login, NAME);
        //метод заполнения поля имя
        objRegisterPage.clickEditProfile(objRegisterPage.email, EMAIL);
        //метод заполнения поля имя
        objRegisterPage.clickEditProfile(objRegisterPage.password, PASSWORD);
        //нажимем кнопку зарегестрироваться
        objRegisterPage.clickRegisterButton(objRegisterPage.registerButton);
        Thread.sleep(5000);
        //String expected = driver.findElement(LOCKATOR).getText();
        //System.out.println(expected); //.input__error
        //проверяем что текст ошибки совподает с предпологаемым
        Assert.assertEquals(driver.findElement(LOCKATOR).getText(), TEXT);
    }


    @After
    public void teardown() {

        driver.quit();
    }


}
