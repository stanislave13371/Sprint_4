package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPopup {
    private WebDriver driver;
    // Локатор к попапу. Перенес в класс
    private final By confirmButton = By.xpath("//button[text()='Да' and contains(@class, 'Button_Button__ra12g')]");
    private final By viewStatus = By.xpath("//div[@class='Order_NextButton__1_rCA']/button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM') and text()='Посмотреть статус']");

    public ConfirmationPopup(WebDriver driver) {
        this.driver = driver;
    }

    // Метод проверяющий появление попапа и нажимающий на кнопку подтверждения
    public void waitForPopupToBeDisplayedAndConfirm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }
    // Метод проверяющий кнопку посмотреть статус
    public void clickViewStatus() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement viewStatusElement = wait.until(ExpectedConditions.elementToBeClickable(viewStatus));
        viewStatusElement.click();
    }
}
