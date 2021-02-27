package pageobject_model.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddMobileVodafoneWithHomePage {
    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
       /* driver = new Driver();
        driver.get("https://www.portmone.com.ua");*/
    }

    @Test(description = "Add Mobile Vodafone")
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        /*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15,TimeUnit.SECONDS);*/
        driver.get("https://www.portmone.com.ua");

        WebElement enterMobilePhone = driver.findElement(By.xpath("//input[@id='form-top-up-widget__phone-number']"));
        enterMobilePhone.sendKeys("0502222222");
        try {
            Thread.sleep(2222);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement enterMount = driver.findElement(By.xpath("//input[@id='form-top-up-widget__amount']"));
        enterMount.sendKeys("6");
        WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Поповнити')]"));
        submit.click();


        WebElement enterCardNumber = driver.findElement(By.xpath("//input[@name='ccnumber']"));
        enterCardNumber.sendKeys("4444333322221111");

        WebElement enterMmPp = driver.findElement(By.xpath("//input[@name='expdate']"));
        enterMmPp.sendKeys("1123");

        WebElement enterCvv2 = driver.findElement(By.xpath("//input[@name='cvv2']"));
        enterCvv2.sendKeys("112");

        try {
            Thread.sleep(5555);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement submitSecond = driver.findElement(By.xpath("//button[@type='submit']"));
        submitSecond.click();

        WebElement alertError = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertEquals(alertError.getText(),"Операція відхилена моніторинговою системою Portmone.com");
    }

}
