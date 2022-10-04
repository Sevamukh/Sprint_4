import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.samokat.model.MainPage;
import ru.yandex.samokat.model.OrderPage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(JUnitParamsRunner.class)
public class MakeOrderTest {
    private WebDriver driver;
    private MainPage mainPage;
    private OrderPage orderPage;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный форматтер
    private final String dateTest = LocalDate.now().plusDays(2).format(formatter); // получаем текущую дату, прибавляем к ней 2 дня и форматируем
    
    @Before
    public void setUp () {
        // driver = new ChromeDriver(); // В Хроме блокер на эти тесты
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Ждем везде до 10 сек
        mainPage = new MainPage(driver);
        mainPage.open();
    }
    @Test
    @Parameters(method = "parametersForMakeOrder")
    public void makeOrder(By makeOrderButtonSelector, String name, String surname, String address,
                          String metro, String telephone, String comment) {
        mainPage.scrollToMakeOrderButton(makeOrderButtonSelector);
        mainPage.clickMakeOrderButton(makeOrderButtonSelector);
        orderPage = new OrderPage(driver);
        orderPage.enterName(name);
        orderPage.enterSurname(surname);
        orderPage.enterAddress(address);
        orderPage.enterMetro(metro);
        orderPage.enterTelephone(telephone);
        orderPage.clickNextButton();
        orderPage.enterDate(dateTest);
        orderPage.chooseRentalPeriod();
        orderPage.clickBlackCheckbox();
        orderPage.enterComments(comment);
        orderPage.clickMakeOrderButton();
        orderPage.clickConfirmOrderButton();
        Assert.assertTrue("Сообщение об успешном создании заказа не появляется",
                orderPage.isOrderConfirmationVisible());
    }

    private Object[][] parametersForMakeOrder() {
        return new Object[][]{{MainPage.MAKE_ORDER_TOP_BUTTON, "Вася", "Пупкин", "улица Никакая, дом 2",
                    "Лубянка", "80000000000", "Почти"},
                {MainPage.MAKE_ORDER_BOTTOM_BUTTON, "Иван", "Иванов", "бульвар Никакой, дом 12345",
                        "Бульвар", "81234567890", "второй тест"},

        };
    }

    @After
    public void cleanUp () {
        driver.quit();
    }
}