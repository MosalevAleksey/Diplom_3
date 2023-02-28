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
public class CheckConstructionTest {
    private final String INGRIDIENT;
    private final By LOCKATOR;
    private final By LOCKATOR1;
    private final By LOCKATOR2;
    private WebDriver driver;
    private HomePageElement objHomePageElement;
    private Register objRegisterPage;
    private PersonalAccount objPersonalAccount;

    public CheckConstructionTest(String ingridient, By lockator, By lockator1, By lockator2) {
        INGRIDIENT = ingridient;
        LOCKATOR1 = lockator1;
        LOCKATOR = lockator;
        LOCKATOR2 = lockator2;
    }

    @Parameterized.Parameters
    public static Object[][] checkTexst() {
        return new Object[][]{
                {"Начинки", HomePageElement.fillingBField, HomePageElement.fillingButton, HomePageElement.fillingBField},
                {"Соусы", HomePageElement.sousField, HomePageElement.sousButton, HomePageElement.fillingBField},
                {"Булки", HomePageElement.breadField, HomePageElement.breadButton, HomePageElement.fillingBField},

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
        //driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");
        objHomePageElement = new HomePageElement(driver);
        objRegisterPage = new Register(driver);
        objPersonalAccount = new PersonalAccount(driver);
    }

    @Test
    @DisplayName("Проверка слайдера с ингридиентами")
    public void changeConstructTest() throws InterruptedException {

        // Нажали на кнопку
        if (INGRIDIENT.equals("Булки")) {
            objHomePageElement.clickButton(LOCKATOR2);
        }
        objHomePageElement.clickButton(LOCKATOR);
        Thread.sleep(2000);
        // отоброжается нужный раздел
        Assert.assertEquals(driver.findElement(LOCKATOR1).getText(), INGRIDIENT);
    }


    @After
    public void teardown() {

        driver.quit();
    }


}


