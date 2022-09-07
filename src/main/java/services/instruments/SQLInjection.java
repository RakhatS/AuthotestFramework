package services.instruments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

public class SQLInjection extends BasePage {
    public SQLInjection(WebDriver driver) {
        super(driver);
    }

    public SQLInjection start(By txt_field_one, By txt_field_two, By button_kiru, String []redirectURL){
        WebElement kiru = driver.findElement(button_kiru);
        WebElement el_txt_one = driver.findElement(txt_field_one);
        WebElement el_txt_two = driver.findElement(txt_field_two);
        waitElementIsVisible(el_txt_one).sendKeys("OR 1 = 1 LIMIT 1");
        waitElementIsVisible(el_txt_two).sendKeys("0");
        waitElementIsVisible(kiru).click();
        for (String url:redirectURL) {
            if (driver.getCurrentUrl().equals(url)) {
                Assert.fail("На сайте есть уязвимость SQL-инъекции.");
                return this;
            }
        }

        return this;
    }
}
