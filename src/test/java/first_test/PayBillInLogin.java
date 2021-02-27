package first_test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class PayBillInLogin {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
        //   WebDriver driver = new ChromeDriver();
      /* driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.portmone.com.ua");*/
    }

    @Test (description = "Pay bill in login")
    public  void PayBillInLoginResult() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.portmone.com.ua");


        WebElement logIn = driver.findElement(By.xpath("//div[@appportmonelayoutsidenav='login' and @class='header-auth-btn-tablet']"));
        logIn.click();
        WebElement logInEnter = driver.findElement(By.xpath("//input[@id='form-login__input-login']"));
        logInEnter.sendKeys("testportmone342@gmail.com");
        WebElement logInPassword = driver.findElement(By.xpath("//input[@id='form-login__input-password']"));
        logInPassword.sendKeys("123123q");
        WebElement logInSubmit = driver.findElement(By.xpath("//button[@id='form-login__button-submit']"));
        logInSubmit.click();

        // Login Success





        WebElement addMoneyToYourBalanceVodafone = driver.findElement(By.xpath("//div[@class='list-item__checkbox']//span[@class='checkbox-group__checkmark']"));
        addMoneyToYourBalanceVodafone.click();

        WebElement addMoneyToBalances = driver.findElement(By.xpath("//body/app-root[1]/main[1]/app-dashboard-module[1]/div[1]/div[2]/div[1]/app-dashboard-main[1]/div[1]/div[3]/div[2]/div[1]/button[1]"));
        addMoneyToBalances.click();




        WebElement enterPay = driver.findElement(By.xpath("//div[@class='billAmount']//input[@type='text']"));
        enterPay.clear();
        enterPay.sendKeys("5");




        // TODO используется при первой оплате, дальше карта добавляется
       /* WebElement enterCard = driver.findElement(By.xpath("//input[@id='card_number-1']"));
        enterCard.sendKeys("4444333322221111");
        WebElement validYears = driver.findElement(By.xpath("//li[@class='frontSide']//div[@class='account-expiration_date-YY-wrap']"));
        validYears.click();
        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();*/
       // Thread.sleep(3000);
        WebElement cvv2 = driver.findElement(By.xpath("//input[@id='account-cvv2']"));
        cvv2.click();
        cvv2.sendKeys("242");
        //TODO remote virtual panel, for cvv2 input
      //  Actions keyDown2 = new Actions(driver);
       // keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();
       // WebElement cvv2Enter = driver.findElement(By.xpath("//body/div[6]/form[1]/ul[1]/li[4]/div[1]/ul[1]/li[1]/ul[1]/li[2]/div[1]/div[2]/div[1]/div[1]/button[1]"));
       // cvv2Enter.click();
       // cvv2Enter.click();
        // cvv2Enter.click();

        WebElement pay = driver.findElement(By.xpath("//button[@id='button-pay']"));
        pay.click();

        WebDriverWait waiter = new WebDriverWait(driver, 20);
        waiter.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.getText();
        alert.accept();

        WebElement errorPay = driver.findElement(By.xpath("//div[contains(text(),'Операція відхилена моніторинговою системою Portmon')]"));
        Assert.assertEquals(errorPay.getText(),"Операція відхилена моніторинговою системою Portmone.com");




        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

      /*   @AfterMethod (alwaysRun = true)
        public void browserTearDown(){
        driver=null;
        driver.quit();
    }*/

    }
}
