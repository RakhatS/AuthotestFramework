package services.instruments;

import io.qameta.allure.Attachment;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import pages.base.HiddenPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Nmap extends HiddenPage {

    private final By search_field = By.xpath("//*[@id=\"form-scanner\"]/div/div/div/input");
    private final By search_button = By.xpath("//*[@id=\"form-scanner\"]/button");
    public Nmap() {
        super();
    }
    public void checkPorts(String url){
        open("https://free.proxy-sale.com/skaner-portov/");
        WebElement search_text = driver.findElement(search_field);
        WebElement search_click = driver.findElement(search_button);
        waitElementIsVisible(search_text).sendKeys(url);
        waitElementIsVisible(search_click).click();

        Pattern pattern = Pattern.compile("Domain");
        WebElement result = driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/div[3]/div[2]/div/div[1]"));
        Matcher matcher = pattern.matcher(result.getText());
        while (!matcher.find()) {
            result = driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/div[3]/div[2]/div/div[1]"));
            matcher = pattern.matcher(result.getText());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String total = "Error";
        if(result.getText().isEmpty()) {
            driver.quit();
            sendMessagePorts(total);
            return;
        }
        total = result.getText();
        driver.quit();
        sendMessagePorts(total);
    }

    @Attachment(value = "Список портов", type = "text/html")
    public String sendMessagePorts(String message) {
        return message;
    }
}
