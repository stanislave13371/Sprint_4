package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class OrderPage {
private WebDriver driver;

public OrderPage(WebDriver driver){
    this.driver = driver;
}
    // Локаторы для первой страницы заказа
    // Локатор для поля Имя
    private final By firstNameField = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // Локатор для поля фамилия
    private final By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");
    // Локатор для поля Адрес
    private final By addressField = By.xpath("//input[@placeholder ='* Адрес: куда привезти заказ']");
    // Локатор для выбора метро
    private final By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    // Локатор для поля номера телефона
    private final By phoneNumberField = By.xpath("//input[contains(@placeholder, 'Телефон')]");
    private final By nextButton = By.xpath("//button[text()='Далее']");

    // Локаторы для второй страницы заказа
    // Локатор когда привезти самокат
    private final By deliveryDateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // Локатор срока аренды
    private final By rentalPeriodField = By.className("Dropdown-control");
    private final By rentalPeriodSelected = By.xpath("//div[@class='Dropdown-placeholder is-selected']");
    // Локатор цвет самоката черный
    private final By colorCheckBoxBlack = By.id("black");
    // Локатор цвет самоката серый
    private final By colorCheckBoxGrey = By.id("grey");
    // Локатор комментарий
    private final By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    // Локатор кнопки заказать
    private final By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM') and not(contains(@class, 'Button_Inverted__3IF-i')) and text()='Заказать']");


    public void setFirstName(String firstName){
        // Ввод имени
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstNameElement = wait.until(
                ExpectedConditions.elementToBeClickable(firstNameField));
        firstNameElement.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        // Ввод фамилии
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        lastNameElement.sendKeys(lastName);
    }

    public void setAddress(String address){
        // Ввод адреса
        driver.findElement(addressField).sendKeys(address);
    }

    public void setMetroStation(String metroStation){
        // Клик по полю выбора станции метро
        driver.findElement(metroStationField).click();
        // Ввод текста для поиска станции
        driver.findElement(metroStationField).sendKeys(metroStation);
        // Клик на станцию в выпадающем списке
        driver.findElement(By.xpath("//div[contains(@class, 'select-search__select')]//div[text()='" + metroStation + "']")).click(); // надо смотреть локаторы
    }

    public void setPhoneNumber(String phoneNumber){
        // Ввод номера телефона
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickNextButton(){
        driver.findElement(nextButton).click();
        // Добавляем ожидание появления поля «Когда привезти самокат»
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryDateField));
    }

    public void setDeliveryDate(String deliveryDate){
        // Ожидаем, выбираем дату, принимаем выбранную дату
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryDateField));
        dateField.sendKeys(deliveryDate);
        dateField.sendKeys(Keys.ENTER);
    }

    public void setRentalPeriod(String rentalPeriod){
        // Клик на срок аренды
        driver.findElement(rentalPeriodField).click();
        // Клик на вариант срока аренды
        driver.findElement(By.xpath("//div[@class='Dropdown-menu']/div[text()='" + rentalPeriod + "']")).click();
        // Ожидаем перед проверкой
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(rentalPeriodSelected));
    }
    // Сделали обработку цветов
    public void setColor(String color){
        if(color.equals("black")){
            driver.findElement(colorCheckBoxBlack).click();
        } else if(color.equals("grey")){
            driver.findElement(colorCheckBoxGrey).click();
        }
    }
    public void setComment(String comment){
        // Ввод комментария
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickOrderButton(){
        // Ожидаем и кликаем кнопку
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(orderButton)).click();
    }
}
