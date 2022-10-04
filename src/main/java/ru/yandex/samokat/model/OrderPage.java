package ru.yandex.samokat.model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    // Поле "Имя"
    private final static By NAME_INPUT_FIELD = By.cssSelector("input[placeholder='* Имя']");
    // Поле "Фамилия"
    private final static By SURNAME_INPUT_FIELD = By.cssSelector("input[placeholder='* Фамилия']");
    // Поле адреса
    private final static By ADDRESS_INPUT_FIELD = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    // Поле станция метро
    private final static By METRO_STATION_INPUT_FIELD = By.cssSelector("input[placeholder='* Станция метро']");
    // Поле телефон
    private final static By TELEPHONE_NUMBER_INPUT_FIELD = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка далее
    private final static By NEXT_BUTTON = By.cssSelector("button.Button_Middle__1CSJM");
    // Поле дата
    private final static By DATE_INPUT_FIELD = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    // Чекбокс "Черный"
    private final static By BLACK_CHECKBOX = By.cssSelector("#black");
    // Выпадающий список
    private final static By RENTAL_PERIOD_DROPDOWN = By.cssSelector("div.Dropdown-placeholder");

    private final static By RENTAL_PERIOD_OPTION1 = By.xpath("//div[text()='сутки']");

    // Поле для комментариев
    private final static By COMMENTS_INPUT_FIELD = By.cssSelector("input[placeholder=\"Комментарий для курьера\"]");
    // Кнопка "Заказать"
    private final static By MAKE_ORDER_BUTTON = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Кнопка "Да"
    private final static By CONFIRM_ORDER_BUTTON = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    // Форма подтвеждения заказа
    private final static By ORDER_CONFIRMATION_POPUP = By.cssSelector("div.Order_Modal__YZ-d3");


    private final WebDriver driver;

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterName(String name){
        driver.findElement(NAME_INPUT_FIELD).sendKeys(name);
    }

    public void enterSurname(String surname){
        driver.findElement(SURNAME_INPUT_FIELD).sendKeys(surname);
    }

    public void enterAddress(String address){
        driver.findElement(ADDRESS_INPUT_FIELD).sendKeys(address);
    }

    public void enterMetro(String metro){
        driver.findElement(METRO_STATION_INPUT_FIELD).sendKeys(metro);
        driver.findElement(METRO_STATION_INPUT_FIELD).sendKeys(Keys.DOWN);
        driver.findElement(METRO_STATION_INPUT_FIELD).sendKeys(Keys.ENTER);
    }

    public void enterTelephone(String telephone){
        driver.findElement(TELEPHONE_NUMBER_INPUT_FIELD).sendKeys(telephone);
    }

    public void clickNextButton(){
        driver.findElement(NEXT_BUTTON).click();
    }

    public void enterDate(String date){
        driver.findElement(DATE_INPUT_FIELD).sendKeys(date);
        driver.findElement(DATE_INPUT_FIELD).sendKeys(Keys.ENTER);
    }

    public void chooseRentalPeriod(){
        driver.findElement(RENTAL_PERIOD_DROPDOWN).click();
        driver.findElement(RENTAL_PERIOD_OPTION1).click();
    }

    public void clickBlackCheckbox(){
        driver.findElement(BLACK_CHECKBOX).click();
    }
    public void enterComments(String comment){
        driver.findElement(COMMENTS_INPUT_FIELD).sendKeys(comment);
    }

    public void clickMakeOrderButton(){
        driver.findElement(MAKE_ORDER_BUTTON).click();
    }

    public void clickConfirmOrderButton(){
        driver.findElement(CONFIRM_ORDER_BUTTON).click();
    }

    public boolean isOrderConfirmationVisible(){
        return driver.findElement(ORDER_CONFIRMATION_POPUP).isDisplayed();
    }

}
