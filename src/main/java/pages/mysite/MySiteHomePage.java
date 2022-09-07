package pages.mysite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import services.instruments.XSS;

public class MySiteHomePage extends BasePage {
    public MySiteHomePage(WebDriver driver) {
        super(driver);
    }
    private final By button_login = By.xpath("//*[@id=\"block-7\"]/div/div[1]/div/div/a");
    private final By search_field = By.xpath("//*[@id=\"wp-block-search__input-1\"]");
    private final By search_button = By.xpath("//*[@id=\"block-2\"]/form/div/button");
    private XSS xss = new XSS(driver);

    public MySiteHomePage click_button_login(){
        WebElement b_login = driver.findElement(button_login);
        waitElementIsVisible(b_login).click();
        return this;
    }
    public MySiteHomePage checkXSS(){

        xss.start(search_field,search_button);
        return this;
    }
}
