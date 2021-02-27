import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class Login {


     public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.portmone.com.ua");

        WebElement logIn = driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]"));
        logIn.click();
        WebElement logInEnter = driver.findElement(By.xpath("//input[@id='form-login__input-login']"));
        logInEnter.sendKeys("testportmone342@gmail.com");
        WebElement logInPassword = driver.findElement(By.xpath("//input[@id='form-login__input-password']"));
        logInPassword.sendKeys("123123q");
        WebElement logInSubmit = driver.findElement(By.xpath("//button[@id='form-login__button-submit']"));
        logInSubmit.click();


        Thread.sleep(5000);
        driver.quit();

    }
}
