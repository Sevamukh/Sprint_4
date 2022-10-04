import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.samokat.model.MainPage;

import java.time.Duration;

@RunWith(JUnitParamsRunner.class)
public class FAQTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Ждем везде до 10 сек
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    @Parameters(method = "parametersForParams")
    public void checkFAQPanelTextByQuestionNumber(int questionNumber, String expectedText) {
        String strFAQNumber = Integer.toString(questionNumber);
        By faqHeadingN = By.id(MainPage.FAQ_HEADING_SELECTOR_ID+strFAQNumber);
        mainPage.scrollToFAQ(faqHeadingN);
        mainPage.clickFAQItemButton(faqHeadingN);
        By faqPanelTextN = By.cssSelector(MainPage.FAQ_PANEL_TEXT_SELECTOR_CSS+strFAQNumber+"] > p");
        Assert.assertEquals("Соответствующий текст FAQ не открывается или не верен.",
                expectedText, mainPage.FAQPanelText(faqPanelTextN));
    }

    private Object[][] parametersForParams() {
        return new Object[][]{{0, MainPage.FAQ_PANEL0_TEXT},
                {1, MainPage.FAQ_PANEL1_TEXT},
                {2, MainPage.FAQ_PANEL2_TEXT},
                {3, MainPage.FAQ_PANEL3_TEXT},
                {4, MainPage.FAQ_PANEL4_TEXT},
                {5, MainPage.FAQ_PANEL5_TEXT},
                {6, MainPage.FAQ_PANEL6_TEXT},
                {7, MainPage.FAQ_PANEL7_TEXT},
        };
    }

    @After
    public void cleanUp () {
        driver.quit();
    }
}