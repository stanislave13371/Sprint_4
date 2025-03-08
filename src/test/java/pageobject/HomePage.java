package pageobject;

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

    // Принятие кук
    public void clickCookieButton() {
        driver.findElement(HomePageElements.COOKIE_BUTTON).click();
    }

    // Метод клика по первому вопросу
    public void ClickDropDown0() {
        driver.findElement(HomePageElements.DROPDOWN_QUESTION_0).click();
    }

    public String getDropDownAnswerText0() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement answerElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageElements.DROPDOWN_ANSWER_0));
        return answerElement.getText();
    }

    // Метод клика по второму вопросу
    public void ClickDropDown1() {
        driver.findElement(HomePageElements.DROPDOWN_QUESTION_1).click();
    }
    public String getDropDownAnswerText1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement answerElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageElements.DROPDOWN_ANSWER_1));
        return answerElement.getText();
    }

    // Метод клика по третьему вопросу
    public void ClickDropDown2(){
        driver.findElement(HomePageElements.DROPDOWN_QUESTION_2).click();
    }
    public String getDropDownAnswerText2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement answerElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageElements.DROPDOWN_ANSWER_2));
        return answerElement.getText();
    }

    // Метод клика по четвертому вопросу
    public void ClickDropDown3(){
        driver.findElement(HomePageElements.DROPDOWN_QUESTION_3).click();
    }
    public String getDropDownAnswerText3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement answerElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageElements.DROPDOWN_ANSWER_3));
        return answerElement.getText();
    }

    // Метод клика по пятому вопросу
    public void ClickDropDown4(){
        driver.findElement(HomePageElements.DROPDOWN_QUESTION_4).click();
    }
    public String getDropDownAnswerText4() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement answerElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageElements.DROPDOWN_ANSWER_4));
        return answerElement.getText();
    }

    // Метод клика по шестому вопросу
    public void ClickDropDown5(){
        driver.findElement(HomePageElements.DROPDOWN_QUESTION_5).click();
    }
    public String getDropDownAnswerText5() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement answerElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageElements.DROPDOWN_ANSWER_5));
        return answerElement.getText();
    }

    // Метод клика по седьмому вопросу
    public void ClickDropDown6(){
        driver.findElement(HomePageElements.DROPDOWN_QUESTION_6).click();
    }
    public String getDropDownAnswerText6() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement answerElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageElements.DROPDOWN_ANSWER_6));
        return answerElement.getText();
    }

    // Метод клика по восьмому вопросу
    public void ClickDropDown7(){
        driver.findElement(HomePageElements.DROPDOWN_QUESTION_7).click();
    }
    public String getDropDownAnswerText7() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement answerElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageElements.DROPDOWN_ANSWER_7));
        return answerElement.getText();
    }
    public void clickOrderButtonTop(){
        driver.findElement(HomePageElements.ORDER_BUTTON_TOP).click();
    }
    public void clickOrderButtonMiddle(){
        driver.findElement(HomePageElements.ORDER_BUTTON_MIDDLE).click();
    }
}

