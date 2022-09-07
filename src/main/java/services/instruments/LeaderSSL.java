package services.instruments;


import io.qameta.allure.Attachment;
import pages.models.SSLInfo;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import pages.base.HiddenPage;


public class LeaderSSL extends HiddenPage{
    private final By search_field = By.xpath("//*[@id=\"cn\"]");
    private final By search_button = By.xpath("//*[@id=\"search_form\"]/div/div[3]/input");
    private SSLInfo sslInfo;

    public LeaderSSL() {
        super();
    }

    public void infoSSl (String url){
        open("https://www.leaderssl.ru/tools/ssl_checker?");
        WebElement search_text = driver.findElement(search_field);
        WebElement search_click = driver.findElement(search_button);
        waitElementIsVisible(search_text).sendKeys(url);
        waitElementIsVisible(search_click).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement signature = driver.findElement(By.xpath("//*[@id=\"certificate-details\"]/table/tbody/tr[9]/td[2]"));
        WebElement algorithm = driver.findElement(By.xpath("//*[@id=\"certificate-details\"]/table/tbody/tr[8]/td[3]"));
        WebElement serial_number = driver.findElement(By.xpath("//*[@id=\"certificate-details\"]/table/tbody/tr[12]/td[2]"));
        WebElement MD5 = driver.findElement(By.xpath("//*[@id=\"certificate-details\"]/table/tbody/tr[10]/td[3]"));
        WebElement SHA1 = driver.findElement(By.xpath("//*[@id=\"certificate-details\"]/table/tbody/tr[11]/td[2]"));
        WebElement expires = driver.findElement(By.xpath("//*[@id=\"certificate-details\"]/table/tbody/tr[5]/td[2]"));
        WebElement certificate_type = driver.findElement(By.xpath("//*[@id=\"certificate-details\"]/table/tbody/tr[3]/td[2]"));
        sslInfo = new SSLInfo(waitElementIsVisible(expires).getText(),waitElementIsVisible(certificate_type).getText(),waitElementIsVisible(algorithm).getText(),waitElementIsVisible(signature).getText(),waitElementIsVisible(serial_number).getText(),waitElementIsVisible(MD5).getText(),waitElementIsVisible(SHA1).getText());
        driver.quit();
        sendMessageSSL(sslInfo.toString());
    }
    @Attachment(value = "SSL-информация", type = "text/html")
    public String sendMessageSSL(String message) {
        return message;
    }


}
