package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import pages.base.BasePage;


import pages.moocenu.MoocEnuHomePage;
import pages.moocenu.MoocEnuLoginPage;
import pages.mysite.MySiteHomePage;
import pages.mysite.MySiteLoginPage;
import services.instruments.*;


import static config.Config.CLEAR_COOKIES_AND_STORAGE;
import static config.Config.HOLD_BROWSER_OPEN;



public class BaseTest {

    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected SecureConfiguration secureConfiguration = new SecureConfiguration(driver);
    protected SSL ssl = new SSL(driver);

    protected MoocEnuHomePage moocEnuHomePage = new MoocEnuHomePage(driver);
    protected MoocEnuLoginPage moocEnuLoginPage = new MoocEnuLoginPage(driver);

    protected MySiteHomePage mySiteHomePage = new MySiteHomePage(driver);
    protected MySiteLoginPage mySiteLoginPage = new MySiteLoginPage(driver);




    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if(CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void close(){
        if(HOLD_BROWSER_OPEN){
            driver.quit();
        }
    }




}
