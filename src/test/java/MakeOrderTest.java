import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.samokat.model.MainPage;
import ru.yandex.samokat.model.OrderPage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MakeOrderTest {
    private WebDriver driver;
    private MainPage mainPage;

    private OrderPage orderPage;

    private String dateTest;
    
    @Before
    public void setUp () {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // готовим нужный форматтер
        dateTest = LocalDate.now().plusDays(2).format(formatter); // получаем текущую дату, прибавляем к ней 2 дня и форматируем
        // driver = new ChromeDriver(); // В Хроме блокер на эти тесты
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Ждем везде до 5 сек
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    public void makeOrder() {
        mainPage.clickMakeOrderButton();
        orderPage = new OrderPage(driver);
        orderPage.enterName("Вася");
        orderPage.enterSurname("Пупкин");
        orderPage.enterAddress("город Нигде, дом 1");
        orderPage.enterMetro("Лубянка");
        orderPage.enterTelephone("80000000000");
        orderPage.clickNextButton();
        orderPage.enterDate(dateTest);
        orderPage.chooseRentalPeriod();
        orderPage.clickBlackCheckbox();
        orderPage.enterComments("Почти закончил");
        orderPage.clickMakeOrderButton();
        orderPage.clickConfirmOrderButton();
        Assert.assertTrue("Сообщение об успешном создании заказа не появляется",
                orderPage.isOrderConfirmationVisible());
    }

    @Test
    public void makeOrder2way() {
        mainPage.scrollToMakeOrderButton1();
        mainPage.clickMakeOrderButton1();
        orderPage = new OrderPage(driver);
        orderPage.enterName("Васяня");
        orderPage.enterSurname("Пупкин");
        orderPage.enterAddress("город Нигде, дом 2");
        orderPage.enterMetro("Лубянка");
        orderPage.enterTelephone("80000000000");
        orderPage.clickNextButton();
        orderPage.enterDate(dateTest);
        orderPage.chooseRentalPeriod();
        orderPage.clickBlackCheckbox();
        orderPage.enterComments("Почти");
        orderPage.clickMakeOrderButton();
        orderPage.clickConfirmOrderButton();
        Assert.assertTrue("Сообщение об успешном создании заказа не появляется",
                orderPage.isOrderConfirmationVisible());
    }

    @After
    public void cleanUp () {
        driver.quit();
    }
}