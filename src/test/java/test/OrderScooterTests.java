package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.ConfirmationPopup;
import pageobject.HomePage;
import pageobject.OrderPage;



@RunWith(Parameterized.class)
public class OrderScooterTests {

    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;
    private ConfirmationPopup confirmationPopup;

    // Параметры для параметризованного теста
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phoneNumber;
    private String deliveryDate;
    private String rentalPeriod;
    private String color;
    private String comment;

    // Конструктор для параметризованного теста
    public OrderScooterTests(String firstName, String lastName, String address, String metroStation, String phoneNumber, String deliveryDate, String rentalPeriod, String color, String comment){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"Станислав", "Гришин", "Москва, ул. Большая Лубянка, 18с2", "Лубянка", "89998141109", "08.03.2025", "двое суток", "black", "Обязательно вызов на телефон как заказ будет обработан и принят"},
                {"Винцеслав", "Вазилинович", "Москва, ул. Электролитный проезд, 13", "Нагорная", "89091235454", "28.04.2025", "сутки", "grey", "Не забудьте пожалуйста про мой заказ!"}
        };

    }
@Before
    public void setUp(){
        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
        confirmationPopup = new ConfirmationPopup(driver);
        homePage.clickCookieButton();
    }
@Test
// Проверка верхней кнопки заказать
    public void testOrderScooterTopButton(){
        homePage.clickOrderButtonTop();
        // Заполняем форму заказа и подтверждаем
        fillOrderFormAndConfirm();
}
@Test
    // Проверка средней кнопки заказать
    public void testOrderScooterMidButton(){
        homePage.clickOrderButtonMiddle();
        // Заполняем форму заказа и подтверждаем
        fillOrderFormAndConfirm();
}
// Метод для заполнения формы заказа и подтверждения
    public void fillOrderFormAndConfirm(){
        // Заполняем первую страницу формы
        orderPage.setFirstName(firstName);
        orderPage.setLastName(lastName);
        orderPage.setAddress(address);
        orderPage.setMetroStation(metroStation);
        orderPage.setPhoneNumber(phoneNumber);
        orderPage.clickNextButton();
        // Заполняем вторую страницу формы
        orderPage.setDeliveryDate(deliveryDate);
        orderPage.setRentalPeriod(rentalPeriod);
        orderPage.setColor(color);
        orderPage.setComment(comment);
        orderPage.clickOrderButton();
        // Подтверждаем заказ


        // Дожидаемся кнопки подтверждения
        confirmationPopup.waitForPopupToBeDisplayedAndConfirm();
        // Нажимаем кнопку подтверждения
        //confirmationPopup.clickConfirmButton();
        confirmationPopup.clickViewStatus();


    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
