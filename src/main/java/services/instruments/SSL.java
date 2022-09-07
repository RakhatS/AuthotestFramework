package services.instruments;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SSL extends BasePage {
    public SSL(WebDriver driver) {
        super(driver);
    }

    public SSL start(){
        Pattern pattern = Pattern.compile("https");
        Matcher matcher = pattern.matcher(driver.getCurrentUrl());
        if (!matcher.find())
            Assert.fail("Этот сайт не сертифицирован");
        return this;
    }
}
