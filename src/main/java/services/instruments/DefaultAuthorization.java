package services.instruments;

import pages.models.LoginAndPassForBruteForce;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;



public class DefaultAuthorization extends BasePage {
    private final LoginAndPassForBruteForce logAndPass = new LoginAndPassForBruteForce();

    public DefaultAuthorization(WebDriver driver) {
        super(driver);
    }

    public DefaultAuthorization start(By txt_field_login, By txt_field_pass, By button_kiru, String []redirectURL){
        WebElement kiru = driver.findElement(button_kiru);
        WebElement el_txt_login = driver.findElement(txt_field_login);
        WebElement el_txt_password = driver.findElement(txt_field_pass);
        if(!waitElementIsVisible(kiru).isDisplayed() || !waitElementIsVisible(el_txt_login).isDisplayed() || !waitElementIsVisible(el_txt_password).isDisplayed()){
            return this;
        }
        for (String login : logAndPass.getLoginsForBrute()){
            for (String password : logAndPass.getPasswordsForBrute()){
                el_txt_login.sendKeys(login);
                el_txt_password.sendKeys(password);
                kiru.click();
                for (String url:redirectURL) {
                    if (driver.getCurrentUrl().equals(url)) {
                        Assert.fail("Логин: " + login + "\nПароль: " + password);
                        return this;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                kiru = driver.findElement(button_kiru);
                el_txt_login = driver.findElement(txt_field_login);
                el_txt_password = driver.findElement(txt_field_pass);
                el_txt_login.clear();
                el_txt_password.clear();
            }
        }
        return this;
    }

}
