package pages.moocenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import services.instruments.XSS;

public class MoocEnuHomePage extends BasePage {
    public MoocEnuHomePage(WebDriver driver) {
        super(driver);
    }
    //  элементы сайта по xpath
    private final By button_login = By.xpath("//*[@id=\"page-wrapper\"]/nav/ul[2]/li[2]/div/span/a");
    private final By search_field = By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/section[1]/div[3]/div[2]/div/form/div/input");
    private final By search_button = By.xpath("//*[@id=\"region-main\"]/div[3]/div[2]/div/form/div/div/button");
    private XSS xss = new XSS(driver);

    public MoocEnuHomePage click_button_login(){
        WebElement b_login = driver.findElement(button_login);
        waitElementIsVisible(b_login).click();
        return this;
    }
    public MoocEnuHomePage checkXSS(){
        xss.start(search_field,search_button);
        return this;
    }
}
