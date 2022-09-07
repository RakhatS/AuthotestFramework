package pages.moocenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import services.instruments.DefaultAuthorization;
import services.instruments.SQLInjection;

import static constants.Constants.Urls.MOOC_ENU_AUTORIZATION_PAGES;

public class MoocEnuLoginPage extends BasePage {
    private SQLInjection sqlInjection = new SQLInjection(driver);
    private DefaultAuthorization defaultAuthorization = new DefaultAuthorization(driver);
    public MoocEnuLoginPage(WebDriver driver) {
        super(driver);
    }
    private final By button_kiru = By.xpath("//*[@id=\"loginbtn\"]");
    private final By field_login = By.xpath("//*[@id=\"username\"]");
    private final By field_password = By.xpath("//*[@id=\"password\"]");
    public MoocEnuLoginPage SqlHack(){
        sqlInjection.start(field_login,field_password,button_kiru,MOOC_ENU_AUTORIZATION_PAGES);
        return this;
    }
    public MoocEnuLoginPage bruteForce(){
        defaultAuthorization.start(field_login,field_password,button_kiru,MOOC_ENU_AUTORIZATION_PAGES);
        return this;
    }
}
