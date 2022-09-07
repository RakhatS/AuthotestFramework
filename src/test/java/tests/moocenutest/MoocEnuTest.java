package tests.moocenutest;


import org.testng.annotations.Test;

import services.instruments.LeaderSSL;
import services.instruments.Nmap;
import tests.base.BaseTest;



import static constants.Constants.Urls.MOOC_ENU_HOME_PAGE;

public class MoocEnuTest extends BaseTest {

    @Test(description = "Защита от XSS-атак")
    public void checkXss(){
        basePage.open(MOOC_ENU_HOME_PAGE);
        moocEnuHomePage.checkXSS();

    }
    @Test(description = "SQL-инъекция")
    public void checkLogin(){
        basePage.open(MOOC_ENU_HOME_PAGE);
        moocEnuHomePage.click_button_login();
        moocEnuLoginPage.SqlHack();
    }

    @Test(description = "Проверка сертификата (SSL)")
    public void checkCertification(){
        basePage.open(MOOC_ENU_HOME_PAGE);
        ssl.start();
        LeaderSSL leaderSSL = new LeaderSSL();
       leaderSSL.infoSSl(MOOC_ENU_HOME_PAGE);

    }

    @Test(description = "Безопасная конфигурация")
    public void checkConfiguration(){
        secureConfiguration.start(MOOC_ENU_HOME_PAGE);
    }
    @Test(description = "Проверка логинов и паролей по умолчанию (Brute Force)")
    public void bruteForce(){
        basePage.open(MOOC_ENU_HOME_PAGE);
        moocEnuHomePage.click_button_login();
        moocEnuLoginPage.bruteForce();
    }

    @Test(description = "Открытые порты")
    public void openorts(){
        Nmap nmap = new Nmap();
        nmap.checkPorts(MOOC_ENU_HOME_PAGE);

    }


}
