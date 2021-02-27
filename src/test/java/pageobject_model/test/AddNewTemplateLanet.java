package pageobject_model.test;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddNewTemplateLanet {
    private Driver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
       /* driver = new Driver();
        driver.get("https://www.portmone.com.ua");*/
    }

    @Test(description = "Add New Template Lanet")
    public void AddNewTemplateLanetResalt() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.portmone.com.ua");

        WebElement logIn = driver.findElement(By.xpath("//*[@svgicon='portmone_profile']"));
        logIn.click();
        WebElement logInEnter = driver.findElement(By.xpath("//input[@id='form-login__input-login']"));
        logInEnter.sendKeys("testportmone342@gmail.com");
        WebElement logInPassword = driver.findElement(By.xpath("//input[@id='form-login__input-password']"));
        logInPassword.sendKeys("123123q");
        WebElement logInSubmit = driver.findElement(By.xpath("//button[@id='form-login__button-submit']"));
        logInSubmit.click();


        Thread.sleep(5000);

        WebElement menu = driver.findElement(By.xpath("//*[@svgicon='portmone_profile']"));
        menu.click();
        WebElement template = driver.findElement(By.xpath("//div[@id='right-sidenav']//*[@href='/r3/uk/dashboard/profile/requests']"));
        template.click();
        WebElement addTemplate = driver.findElement(By.xpath("//button[contains(text(),'Додати рахунок')]"));
        addTemplate.click();
        Thread.sleep(2222);
        WebElement changeTv = driver.findElement(By.xpath("//a[@id='1004']"));
        changeTv.click();
        Thread.sleep(4222);
        WebElement changeLanet = driver.findElement(By.xpath("//img[@alt='Ланет.']"));
        changeLanet.click();
        Thread.sleep(4222);
        WebElement enterNumber = driver.findElement(By.xpath("//input[@id='request-contract_number']"));
        enterNumber.sendKeys("1233215");
        WebElement submitPay = driver.findElement(By.xpath("//button[@id='button-terminal-pay']"));
        submitPay.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertEquals(errorMessage.getText(),"Реквізити запита на рахунок вказано невірно. [Код помилки 30011] клиент не найден");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }

}
