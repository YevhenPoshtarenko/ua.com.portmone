import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.portmone.com.ua");
        Thread.sleep(2000);
        WebElement logIn = driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]"));
        logIn.click();
        Thread.sleep(2000);
        WebElement registration = driver.findElement(By.xpath("//div[contains(text(),'Реєстрація')]"));
        registration.click();

        WebElement emailEnter = driver.findElement(By.xpath("//input[@id='form-signup__input-email']"));
        emailEnter.sendKeys("testportmone342@gmail.com");
        Thread.sleep(2000);
        WebElement mobileNumber = driver.findElement(By.xpath("//input[@id='form-signup__input-phone-number']"));
        mobileNumber.sendKeys("0502222222");
        Thread.sleep(2000);
        WebElement passwordEnter = driver.findElement(By.xpath("//input[@id='form-signup__input-password']"));
        passwordEnter.sendKeys("123123q");
        Thread.sleep(2000);
        WebElement submitRegistration = driver.findElement(By.xpath("//button[@id='form-signup__button-submit']"));
        submitRegistration.click();
        Thread.sleep(3000);

        //driver.quit();

    }
}
