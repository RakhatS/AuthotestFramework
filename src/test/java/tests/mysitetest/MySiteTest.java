package tests.mysitetest;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constants.Urls.MY_SITE_HOME_PAGE;

public class MySiteTest extends BaseTest {
    @Test(description = "Защита от XSS-атак")
    public void checkXss(){
        basePage.open(MY_SITE_HOME_PAGE);
        mySiteHomePage.checkXSS();

    }
    @Test(description = "SQL-инъекция")
    public void checkLogin(){
        basePage.open(MY_SITE_HOME_PAGE);
        mySiteHomePage.click_button_login();
        mySiteLoginPage.SqlHack();
    }

    @Test(description = "Проверка сертификата (SSL)")
    public void checkCertification(){
        basePage.open(MY_SITE_HOME_PAGE);
        ssl.start();
    }
    @Test(description = "Безопасная конфигурация")
    public void secureConf(){
        secureConfiguration.start(MY_SITE_HOME_PAGE);
    }
    @Test(description = "Проверка логинов и паролей по умолчанию (Brute Force)")
    public void bruteForce(){
        basePage.open(MY_SITE_HOME_PAGE);
        mySiteHomePage.click_button_login();
        mySiteLoginPage.bruteForce();
    }

}
