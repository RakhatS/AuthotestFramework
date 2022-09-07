package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constants.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    // веб драйвер
    protected WebDriver driver;

    // конструктор
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    // открыть драйвер
    public void open(String url){
        driver.get(url);
    }
    // функция ожидание появление элемента
    public  WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver,EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
