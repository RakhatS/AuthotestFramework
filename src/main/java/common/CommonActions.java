package common;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static config.Config.PLATFORM_AND_BROWSER;
import static constants.Constants.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {

    public static WebDriver createDriver(){
        WebDriver driver = null;
        /*
        * выбор браузера
        * */
        switch (PLATFORM_AND_BROWSER){
            case "win_chrome":
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                allureEnvironmentWriter(ImmutableMap.<String,String>builder().put("Browser","Chrome").build());
                break;
            default:
                Assert.fail("Неверная платформа или название браузера: " + PLATFORM_AND_BROWSER);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        return driver;
    }
}
