package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static constants.Constants.TimeoutVariable.EXPLICIT_WAIT;
import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;


// класс скрыого браузера
public class HiddenPage {
    protected WebDriver driver;

    public HiddenPage() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // создание свойство браузера
        driver = new ChromeDriver(options); //
    }

    public void open(String url){
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(url);
    }
    // функция ожидание появление элемента
    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver,EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
