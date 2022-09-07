package services.instruments;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecureConfiguration extends BasePage {

    public SecureConfiguration(WebDriver driver) {
        super(driver);
    }

    public boolean is404() {
        Pattern pattern = Pattern.compile("404|Страница не найдена");
        Matcher matcher = pattern.matcher(driver.getTitle());
        if (!matcher.find())
            return true;
        return false;
    }
    public SecureConfiguration start(String url){
        String []pages = {"\\main.php", "\\main.inc", "\\wp-config", "\\wp-admin", "\\function.php"};
        String s = "";
        for (String p : pages){
            open(url+p);
            if(is404())
                s +=p + " ";
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(s != "")
            Assert.fail("Эти страницы могут быть небезопасными: "+s);
        return this;
    }
}
