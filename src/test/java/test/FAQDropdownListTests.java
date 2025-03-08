package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.HomePage;
import static org.junit.Assert.assertTrue;

public class FAQDropdownListTests {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setup() {
        // Драйвер хром
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Драйвер фаерфокс
        // WebDriverManager.firefoxdriver().setup();
        // driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePage = new HomePage(driver);
        // Принятие кук
        homePage.clickCookieButton();
    }

    @Test
    public void testFirstQuestion(){
        // Клик по первому вопросу
        homePage.ClickDropDown0();
        // Получение текста ответа
        String actualAnswer = homePage.getDropDownAnswerText0();
        //Проверка, что текст ответа не пустой
        assertTrue(!actualAnswer.isEmpty());
    }

    @Test
    public void testSecondQuestion(){
        // Клик по второму вопросу
        homePage.ClickDropDown1();
        // Получение текста ответа
        String actualAnswer = homePage.getDropDownAnswerText1();
        //Проверка, что текст ответа не пустой
        assertTrue(!actualAnswer.isEmpty());
    }

    @Test
    public void testThirdQuestion() {
        // Клик по третьему вопросу
        homePage.ClickDropDown2();
        // Получение текста ответа
        String actualAnswer = homePage.getDropDownAnswerText2();
        // Проверка, что текст ответа не пустой
        assertTrue(!actualAnswer.isEmpty());
    }

    @Test
    public void testFourthQuestion() {
        // Клик по четвертому вопросу
        homePage.ClickDropDown3();
        // Получение текста ответа
        String actualAnswer = homePage.getDropDownAnswerText3();
        //Проверка, что текст ответа не пустой
        assertTrue(!actualAnswer.isEmpty());
    }

    @Test
    public void testFifthQuestion(){
        // Клик по пятому вопросу
        homePage.ClickDropDown4();
        // Получение текста ответа
        String actualAnswer = homePage.getDropDownAnswerText4();
        // Проверка, что текст ответа не пустой
        assertTrue(!actualAnswer.isEmpty());
    }

    @Test
    public void testSixthQuestion(){
        // Клик по шестому вопросу
        homePage.ClickDropDown5();
        // Получение текста ответа
        String actualAnswer = homePage.getDropDownAnswerText5();
        // Проверка, что текст ответа не пустой
        assertTrue(!actualAnswer.isEmpty());
    }

    @Test
    public void testSeventhQuestion(){
        // Клик по седьмому вопросу
        homePage.ClickDropDown6();
        // Получение текста ответа
        String actualAnswer = homePage.getDropDownAnswerText6();
        // Проверка, что текст ответа не пустой
        assertTrue(!actualAnswer.isEmpty());
    }

    @Test
    public void testEighthQuestion(){
        // Клик по восьмому вопросу
        homePage.ClickDropDown7();
        // Получение текста ответа
        String actualAnswer = homePage.getDropDownAnswerText7();
        // Проверка, что текст ответа не пустой
        assertTrue(!actualAnswer.isEmpty());
    }

    @After
    //Закрыть браузер
    public void tearDown(){
        driver.quit();
    }
}
