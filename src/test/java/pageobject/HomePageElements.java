package pageobject;

import org.openqa.selenium.By;

public class HomePageElements {

    // Локатор кнопки принятия кук
    public static final By COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");

    // Локатор для первого вопроса
    public static final By DROPDOWN_QUESTION_0 = By.id("accordion__heading-0");
    // Локатор для второго вопроса
    public static final By DROPDOWN_QUESTION_1 = By.id("accordion__heading-1");
    // Локатор для третьего вопроса
    public static final By DROPDOWN_QUESTION_2 = By.id("accordion__heading-2");
    // Локатор для четвертого вопроса
    public static final By DROPDOWN_QUESTION_3 = By.id("accordion__heading-3");
    // Локатор для пятого вопроса
    public static final By DROPDOWN_QUESTION_4 = By.id("accordion__heading-4");
    // Локатор для шестого вопроса
    public static final By DROPDOWN_QUESTION_5 = By.id("accordion__heading-5");
    // Локатор для седьмого вопроса
    public static final By DROPDOWN_QUESTION_6 = By.id("accordion__heading-6");
    // Локатор для восьмого вопроса
    public static final By DROPDOWN_QUESTION_7 = By.id("accordion__heading-7");

    // Локатор для текста ответа на первый вопрос
    public static final By DROPDOWN_ANSWER_0 = By.xpath("//div[@id='accordion__panel-0']/p");
    // Локатор для текста ответа на второй вопрос
    public static final By DROPDOWN_ANSWER_1 = By.xpath("//div[@id='accordion__panel-1']/p");
    // Локатор для текста ответа на третий вопрос
    public static final By DROPDOWN_ANSWER_2 = By.xpath("//div[@id='accordion__panel-2']/p");
    // Локатор для текста ответа на четвертый вопрос
    public static final By DROPDOWN_ANSWER_3 = By.xpath("//div[@id='accordion__panel-3']/p");
    // Локатор для текста ответа на пятый вопрос
    public static final By DROPDOWN_ANSWER_4 = By.xpath("//div[@id='accordion__panel-4']/p");
    // Локатор для текста ответа на шестой вопрос
    public static final By DROPDOWN_ANSWER_5 = By.xpath("//div[@id='accordion__panel-5']/p");
    // Локатор для текста ответа на седьмой вопрос
    public static final By DROPDOWN_ANSWER_6 = By.xpath("//div[@id='accordion__panel-6']/p");
    // Локатор для текста ответа на восьмой вопрос
    public static final By DROPDOWN_ANSWER_7 = By.xpath("//div[@id='accordion__panel-7']/p");

    // Локатор для кнопки "Заказать" сверху страницы
    public static final By ORDER_BUTTON_TOP = By.xpath("//button[@class='Button_Button__ra12g']");
    // Локатор для кнопки "Заказать" середина страницы
    public static final By ORDER_BUTTON_MIDDLE = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
}