package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");

    private By getQuestionLocator(int index) {
        return By.id("accordion__heading-" + index);
    }

    private By getAnswerLocator(int index) {
        return By.xpath("//div[@id='accordion__panel-" + index + "']/p");
    }

    public void clickCookieButton() {
        driver.findElement(COOKIE_BUTTON).click();
    }

    public void clickQuestionByIndex(int index) {
        driver.findElement(getQuestionLocator(index)).click();
    }

    public String getAnswerTextByIndex(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement answerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getAnswerLocator(index)));
        return answerElement.getText();
    }

    private final By ORDER_BUTTON_TOP = By.xpath("//button[@class='Button_Button__ra12g']");
    private final By ORDER_BUTTON_MIDDLE = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

    public void clickOrderButtonTop() {
        driver.findElement(ORDER_BUTTON_TOP).click();
    }

    public void clickOrderButtonMiddle() {
        driver.findElement(ORDER_BUTTON_MIDDLE).click();
    }

}


