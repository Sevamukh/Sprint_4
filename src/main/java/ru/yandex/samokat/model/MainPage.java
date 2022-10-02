package ru.yandex.samokat.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    // URL главной страницы
    private final static String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    // Кнопка "Заказать" сверху
    private final static By MAKE_ORDER_BUTTON = By.cssSelector("div.Header_Nav__AGCXC > button.Button_Button__ra12g");
    // Кнопка "Заказать" снизу
    private final static By MAKE_ORDER_BUTTON1 = By.cssSelector("div.Home_FinishButton__1_cWm > button.Button_Button__ra12g");
    // FAQs
    // FAQ0
    private final static By FAQ_0_HEADING = By.id("accordion__heading-0");
    private final static By FAQ_0_PANEL_TEXT = By.id("accordion__panel-0");
    // FAQ1
    private final static By FAQ_1_HEADING = By.id("accordion__heading-1");
    private final static By FAQ_1_PANEL_TEXT = By.id("accordion__panel-1");

    private final WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(MAIN_PAGE_URL);
    }

    public void scrollToFAQ0(){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(FAQ_0_HEADING));
    }

    public void clickFAQ0ItemButton(){
        driver.findElement(FAQ_0_HEADING).click();
    }

    public boolean isFAQ0PanelVisible(){
        return driver.findElement(FAQ_0_PANEL_TEXT).isDisplayed();
    }

    public void scrollToFAQ1(){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(FAQ_1_HEADING));
    }

    public void clickFAQ1ItemButton(){
        driver.findElement(FAQ_1_HEADING).click();
    }

    public boolean isFAQ1PanelVisible(){
        return driver.findElement(FAQ_1_PANEL_TEXT).isDisplayed();
    }

    public void clickMakeOrderButton(){
        driver.findElement(MAKE_ORDER_BUTTON).click();
    }

    public void scrollToMakeOrderButton1(){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(MAKE_ORDER_BUTTON1));
    }

    public void clickMakeOrderButton1(){
        driver.findElement(MAKE_ORDER_BUTTON1).click();
    }

}
