package pages.mysite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import services.instruments.DefaultAuthorization;
import services.instruments.SQLInjection;

import static constants.Constants.Urls.MY_SITE_AUTORIZATION_PAGES;

public class MySiteLoginPage extends BasePage {
    private SQLInjection sqlInjection = new SQLInjection(driver);
    private DefaultAuthorization defaultAuthorization = new DefaultAuthorization(driver);
    public MySiteLoginPage(WebDriver driver) {
        super(driver);
    }
    private final By button_kiru = By.xpath("//*[@id=\"content\"]/article/div/div/form/div[4]/button");
    private final By field_login = By.xpath("//*[@id=\"user_login\"]");
    private final By field_password = By.xpath("//*[@id=\"user_pass\"]");
    public MySiteLoginPage SqlHack(){
        sqlInjection.start(field_login,field_password,button_kiru,MY_SITE_AUTORIZATION_PAGES);
        return this;
    }
    public MySiteLoginPage bruteForce(){
        defaultAuthorization.start(field_login,field_password,button_kiru,MY_SITE_AUTORIZATION_PAGES);
        return this;
    }
}
