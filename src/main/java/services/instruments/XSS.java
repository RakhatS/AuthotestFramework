package services.instruments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;


public class XSS extends BasePage {

    public XSS(WebDriver driver) {
        super(driver);
    }

    public XSS start(By search_field, By search_button){
        WebElement field = driver.findElement(search_field);
        WebElement button = driver.findElement(search_button);
        waitElementIsVisible(field).sendKeys("<script>alert(document.cookie)</script>");
        waitElementIsVisible(button).click();
        if(ExpectedConditions.alertIsPresent() == null)
            Assert.fail("Сайт может быть уязвим для XSS-атак.");
        return this;
    }
}
