import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.samokat.model.MainPage;

import java.time.Duration;

public class FAQTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Ждем везде до 5 сек
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    public void checkFAQ0PanelVisibility() {
        mainPage.scrollToFAQ0();
        mainPage.clickFAQ0ItemButton();
        Assert.assertTrue("Соответствующий текст не открывается", mainPage.isFAQ0PanelVisible());
    }

    @Test
    public void checkFAQ1PanelVisibility() {
        mainPage.scrollToFAQ1();
        mainPage.clickFAQ1ItemButton();
        Assert.assertTrue("Соответствующий текст не открывается", mainPage.isFAQ1PanelVisible());
    }

    @After
    public void cleanUp () {
        driver.quit();
    }
}