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

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderScooterTests {

    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;
    private ConfirmationPopup confirmationPopup;

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderScooterTests(String firstName, String lastName, String address, String metroStation, String phoneNumber, String deliveryDate, String rentalPeriod, String color, String comment) {
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
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Станислав", "Гришин", "Москва, ул. Большая Лубянка, 18с2", "Лубянка", "89998141109", "08.03.2025", "двое суток", "black", "Позвоните при доставке."},
                {"Винцеслав", "Вазилинович", "Москва, ул. Электролитный проезд, 13", "Нагорная", "89091235454", "28.04.2025", "сутки", "grey", "Проверьте заказ перед отправкой."}
        };
    }

    @Before
    public void setUp() {
        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize(); // полноэкранный режим
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
        confirmationPopup = new ConfirmationPopup(driver);
        homePage.clickCookieButton();
    }

    @Test
    // Проверка заказа самоката через верхнюю кнопку "Заказать" и получение номера заказа
    public void testOrderScooterTopButton() {
        homePage.clickOrderButtonTop();
        fillOrderFormAndConfirm();
        assertTrue(driver.getCurrentUrl().contains("track"));
    }

    @Test
    // Проверка заказа самоката через среднюю кнопку "Заказать" и получение номера заказа
    public void testOrderScooterMidButton() {
        homePage.clickOrderButtonMiddle();
        fillOrderFormAndConfirm();
        assertTrue(driver.getCurrentUrl().contains("track"));
    }

    private void fillOrderFormAndConfirm() {
        orderPage.setFirstName(firstName);
        orderPage.setLastName(lastName);
        orderPage.setAddress(address);
        orderPage.setMetroStation(metroStation);
        orderPage.setPhoneNumber(phoneNumber);
        orderPage.clickNextButton();
        orderPage.setDeliveryDate(deliveryDate);
        orderPage.setRentalPeriod(rentalPeriod);
        orderPage.setColor(color);
        orderPage.setComment(comment);
        orderPage.clickOrderButton();
        confirmationPopup.waitForPopupToBeDisplayedAndConfirm();
        confirmationPopup.clickViewStatus();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
