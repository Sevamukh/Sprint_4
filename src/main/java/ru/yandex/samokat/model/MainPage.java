package ru.yandex.samokat.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    // URL главной страницы
    private final static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    // Кнопка "Заказать" сверху
    public final static By MAKE_ORDER_TOP_BUTTON = By.cssSelector("div.Header_Nav__AGCXC > button.Button_Button__ra12g");
    // Кнопка "Заказать" снизу
    public final static By MAKE_ORDER_BOTTOM_BUTTON = By.cssSelector("div.Home_FinishButton__1_cWm > button.Button_Button__ra12g");
    // FAQs:
    // 2 вспомогательные строки для селекторов
    public final static String FAQ_HEADING_SELECTOR_ID = "accordion__heading-";
    public final static String FAQ_PANEL_TEXT_SELECTOR_CSS = "div[id=accordion__panel-";
    // Строки с ожидаемым текстом для панели вопросов
    public final static String FAQ_PANEL0_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public final static String FAQ_PANEL1_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public final static String FAQ_PANEL2_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public final static String FAQ_PANEL3_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public final static String FAQ_PANEL4_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public final static String FAQ_PANEL5_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public final static String FAQ_PANEL6_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public final static String FAQ_PANEL7_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    private final WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(MAIN_PAGE_URL);
    }

    public void scrollToFAQ(By selector){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(selector));
    }

    public void clickFAQItemButton(By selector){
        driver.findElement(selector).click();
    }

    public String FAQPanelText(By selector){
        return driver.findElement(selector).getText();
    }

    public void scrollToMakeOrderButton(By selector){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(selector));
    }

    public void clickMakeOrderButton(By selector){
        driver.findElement(selector).click();
    }

}
